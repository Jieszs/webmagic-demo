package selenium.samples.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *  获取属性
 *
 * https://www.selenium.dev/documentation/zh-cn/webdriver/browser_manipulation/
 *
 * @author qq3434569
 */
public class BrowserAttributeTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");

        //获得百度输入框的尺寸
        WebElement size = driver.findElement(By.id("kw"));
        System.out.println(size.getSize());

        //返回百度输入框信息
        WebElement text = driver.findElement(By.id("kw"));
        System.out.println(text.getText());

        //返回元素的属性值， 可以是 id、 name、 type 或元素拥有的其它任意属性
        WebElement ty = driver.findElement(By.id("kw"));
        System.out.println(ty.getAttribute("type"));

        //返回元素的结果是否可见， 返回结果为 True 或 False
        WebElement display = driver.findElement(By.id("kw"));
        System.out.println(display.isDisplayed());

        driver.quit();
    }
}
