package samples.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import samples.download.IDriverProcessor;

import java.util.concurrent.TimeUnit;

/**
 * 智齿客服处理器
 *
 * @author qq3434569
 */
public class ZhiChiKeFuDriverProcessor implements IDriverProcessor {
    private static final String LOGIN_URL = "https://www.sobot.com/console/login";
    private static final String USER_LIST_URL = "https://www.sobot.com/console/customerCenter/customer";

    @Override
    public void process(WebDriver webDriver) {
        String url = webDriver.getCurrentUrl();
        if (LOGIN_URL.equals(url)) {
            login(webDriver);
        } else {
            waitLoading(webDriver);
        }
    }

    private void waitLoading(WebDriver driver) {
        WebElement search_text = new WebDriverWait(driver, 10,1)
                .until((ExpectedCondition<WebElement>) webDriver -> webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[2]/div/div[2]/div/div/div[3]/div/table/tbody/tr[1]/td[3]")));

    }

    private void login(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS);
        driver.get("https://www.sobot.com/console/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement email = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement password = driver.findElement(By.xpath("//*[@id=\"userPassword\"]"));
        email.sendKeys("xxx@qq.com");
        password.sendKeys("xxx");
        password.submit();
    }
}
