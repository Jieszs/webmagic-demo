package samples.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

/**
 * 调用JavaScript代码
 * https://www.selenium.dev/documentation/zh-cn/webdriver/browser_manipulation/
 *
 * @author qq3434569
 */
public class JsTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();


        //设置浏览器窗口大小
        driver.manage().window().setSize(new Dimension(700, 600));
        driver.get("https://www.baidu.com");


        //进行百度搜索
        driver.findElement(By.id("kw")).sendKeys("webdriver api");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);


        //将页面滚动条拖到底部
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(100,450);");
        Thread.sleep(3000);


        driver.quit();

    }


}
