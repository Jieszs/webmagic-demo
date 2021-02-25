package samples.selenium.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 *显示等待
 *
 * 显示等待 是Selenium客户可以使用的命令式过程语言。它们允许您的代码暂停程序执行，或冻结线程，直到满足通过的 条件 。这个条件会以一定的频率一直被调用，直到等待超时。这意味着只要条件返回一个假值，它就会一直尝试和等待
 *
 * 由于显式等待允许您等待条件的发生，所以它们非常适合在浏览器及其DOM和WebDriver脚本之间同步状态。
 *
 * https://www.selenium.dev/documentation/zh-cn/webdriver/browser_manipulation/
 * @author qq3434569
 */
public class ExpectedWaitTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
        //显式等待， 针对某个元素等待
        WebElement search_text = new WebDriverWait(driver, 10,1)
                .until((ExpectedCondition<WebElement>)webDriver -> webDriver.findElement(By.id("kw")));
        search_text.sendKeys("selenium");

        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);

        driver.quit();

    }
}
