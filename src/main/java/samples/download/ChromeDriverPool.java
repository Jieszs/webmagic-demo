package samples.download;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 谷歌连接池
 *
 * @author qq3434569
 */
public class ChromeDriverPool {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private final static int DEFAULT_CAPACITY = 5;

    private final int capacity;

    private final static int STAT_RUNNING = 1;

    private final static int STAT_CLOSED = 2;

    private AtomicInteger stat = new AtomicInteger(STAT_RUNNING);

    /*
     * new fields for configuring phantomJS
     */
    private WebDriver mDriver = null;


    /**
     * Configure the GhostDriver, and initialize a WebDriver instance. This part
     * of code comes from GhostDriver.
     * https://github.com/detro/ghostdriver/tree/master/test/java/src/test/java/ghostdriver
     *
     * @author bob.li.0718@gmail.com
     * @throws IOException
     */
    public void configure() throws IOException {
        ChromeOptions options = new ChromeOptions();
        //不弹窗
        options.setHeadless(true);
        mDriver = new ChromeDriver(options);
    }

    /**
     * check whether input is a valid URL
     *
     * @author bob.li.0718@gmail.com
     * @param urlString urlString
     * @return true means yes, otherwise no.
     */
    private boolean isUrl(String urlString) {
        try {
            new URL(urlString);
            return true;
        } catch (MalformedURLException mue) {
            return false;
        }
    }

    /**
     * store webDrivers created
     */
    private List<WebDriver> webDriverList = Collections
            .synchronizedList(new ArrayList<WebDriver>());

    /**
     * store webDrivers available
     */
    private BlockingDeque<WebDriver> innerQueue = new LinkedBlockingDeque<WebDriver>();

    public ChromeDriverPool(int capacity) {
        this.capacity = capacity;
    }

    public ChromeDriverPool() {
        this(DEFAULT_CAPACITY);
    }

    /**
     *
     * @return
     * @throws InterruptedException
     */
    public WebDriver get() throws InterruptedException {
        checkRunning();
        WebDriver poll = innerQueue.poll();
        if (poll != null) {
            return poll;
        }
        if (webDriverList.size() < capacity) {
            synchronized (webDriverList) {
                if (webDriverList.size() < capacity) {

                    // add new WebDriver instance into pool
                    try {
                        configure();
                        innerQueue.add(mDriver);
                        webDriverList.add(mDriver);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

        }
        return innerQueue.take();
    }

    public void returnToPool(WebDriver webDriver) {
        checkRunning();
        innerQueue.add(webDriver);
    }

    protected void checkRunning() {
        if (!stat.compareAndSet(STAT_RUNNING, STAT_RUNNING)) {
            throw new IllegalStateException("Already closed!");
        }
    }

    public void closeAll() {
        boolean b = stat.compareAndSet(STAT_RUNNING, STAT_CLOSED);
        if (!b) {
            throw new IllegalStateException("Already closed!");
        }
        for (WebDriver webDriver : webDriverList) {
            logger.info("Quit webDriver" + webDriver);
            webDriver.quit();
            webDriver = null;
        }
    }
}
