package samples.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 上传文件

 * https://www.selenium.dev/documentation/zh-cn/webdriver/browser_manipulation/
 *
 * @author qq3434569
 */
public class UploadFileTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://cli.im/deqr");

        WebElement upload =driver.findElement(By.xpath("//*[@id=\"filedatacode\"]"));
        upload.sendKeys("C:\\Users\\qq3434569\\Pictures\\2.png");
        driver.findElement(By.xpath("//*[@id=\"warper\"]/div[1]/div[1]/div[4]/a")).click();

        Thread.sleep(10000);
        driver.quit();

    }


}
