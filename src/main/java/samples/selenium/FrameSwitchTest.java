package samples.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 *Frame切换
 *
 *
 * https://www.selenium.dev/documentation/zh-cn/webdriver/browser_manipulation/
 * @author qq3434569
 */
public class FrameSwitchTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.126.com");

        WebElement xf = driver.findElement(By.xpath("//*[@id='loginDiv']/iframe"));
        driver.switchTo().frame(xf);
        driver.findElement(By.name("email")).clear();
        Thread.sleep(2000);
        driver.findElement(By.name("email")).sendKeys("username");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).clear();
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("password");
        Thread.sleep(2000);
        driver.findElement(By.id("dologin")).click();
        //通过switchTo().defaultContent()方法跳出表单
        driver.switchTo().defaultContent();

    }
}
