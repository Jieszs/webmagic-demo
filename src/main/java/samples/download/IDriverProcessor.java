package samples.download;

import org.openqa.selenium.WebDriver;

/**
 * @author qq3434569
 */
public interface IDriverProcessor {
    /**
     * 对浏览器进行自定义selenium操作
     *
     * @param webDriver
     */
    void process(WebDriver webDriver);
}
