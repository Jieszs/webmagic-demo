package samples.selenium.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 模拟浏览器点击、键盘输入、清除文本、提交。
 * https://www.selenium.dev/documentation/zh-cn/webdriver/browser_manipulation/
 *
 * clear()方法用于清除文本输入框中的内容。
 * sendKeys()方法模拟键盘向输入框里输入内容,用它来指定上传的文件。
 * click()方法可以用来单击一个元素，可以单击任何可以单击的文字/图片链接、复选框、单选框、下拉框等。
 * submit()方法用于提交表单。 例如，在搜索框输入关键字之后的“回车” 操作， 就可以通过 submit()方法模拟.
 *
 * @author qq3434569
 */
public class BrowserBasisOperatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");

        WebElement search_text = driver.findElement(By.id("kw"));
        WebElement search_button = driver.findElement(By.id("su"));

        search_text.sendKeys("Java");
        Thread.sleep(1000);

        search_text.clear();
        search_text.sendKeys("Selenium");
        Thread.sleep(1000);

        search_button.click();
        Thread.sleep(4000);

        search_text.clear();
        search_text.sendKeys("github");
        search_text.submit();
        Thread.sleep(4000);
        driver.quit();



    }
}
