package samples.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 模拟键盘操作
 * sendKeys(Keys.BACK_SPACE) 回格键（BackSpace）
 * sendKeys(Keys.SPACE) 空格键(Space)
 * sendKeys(Keys.TAB) 制表键(Tab)
 * sendKeys(Keys.ESCAPE) 回退键（Esc）
 * sendKeys(Keys.ENTER) 回车键（Enter）
 * sendKeys(Keys.CONTROL,‘a’) 全选（Ctrl+A）
 * sendKeys(Keys.CONTROL,‘c’) 复制（Ctrl+C）
 * sendKeys(Keys.CONTROL,‘x’) 剪切（Ctrl+X）
 * sendKeys(Keys.CONTROL,‘v’) 粘贴（Ctrl+V）
 * https://www.selenium.dev/documentation/zh-cn/webdriver/browser_manipulation/
 *
 * @author qq3434569
 */
public class KeyboardTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");

        WebElement input = driver.findElement(By.id("kw"));

        //输入框输入内容
        input.sendKeys("seleniumm");
        Thread.sleep(2000);

        //删除多输入的一个 m
        input.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);

        //输入空格键+“教程”
        input.sendKeys(Keys.SPACE);
        input.sendKeys("教程");
        Thread.sleep(2000);

        //ctrl+a 全选输入框内容
        input.sendKeys(Keys.CONTROL, "a");
        Thread.sleep(2000);

        //ctrl+x 剪切输入框内容
        input.sendKeys(Keys.CONTROL, "x");
        Thread.sleep(2000);

        //ctrl+v 粘贴内容到输入框
        input.sendKeys(Keys.CONTROL, "v");
        Thread.sleep(2000);

        //通过回车键盘来代替点击操作
        input.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        driver.quit();
    }


}
