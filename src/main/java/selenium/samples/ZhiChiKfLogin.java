package selenium.samples;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * 模拟登录智齿客服
 *
 * Date: 21-2-24
 * Time: 下午5:31
 *
 * @author qq3434569
 */
public class ZhiChiKfLogin {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
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
