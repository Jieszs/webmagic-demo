package selenium.samples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 警告框
 * https://www.selenium.dev/documentation/zh-cn/webdriver/browser_manipulation/
 *
 * @author qq3434569
 */
public class AlertTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");

        driver.findElement(By.xpath("//*[@id=\"s-usersetting-top\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"s-user-setting-menu\"]/div/a[1]")).click();
        Thread.sleep(2000);

        //保存设置
        driver.findElement(By.className("prefpanelgo")).click();
        Thread.sleep(2000);
        //接收弹窗
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.quit();




    }


}
