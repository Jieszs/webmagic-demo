package samples.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

/**
 * 浏览器cookie操作

 * https://www.selenium.dev/documentation/zh-cn/webdriver/browser_manipulation/
 *
 * @author qq3434569
 */
public class CookieTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");

        Cookie c1 = new Cookie("name", "key-aaaaaaa");
        Cookie c2 = new Cookie("value", "value-bbbbbb");
        driver.manage().addCookie(c1);
        driver.manage().addCookie(c2);

        //获得 cookie
        Set<Cookie> coo = driver.manage().getCookies();
        System.out.println(coo);
        //删除所有 cookie
        //driver.manage().deleteAllCookies();

        driver.quit();


    }


}
