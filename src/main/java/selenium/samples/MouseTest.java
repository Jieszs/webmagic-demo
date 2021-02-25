package selenium.samples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 *模拟鼠标操作
 *
 * contextClick() 右击
 * clickAndHold() 鼠标点击并控制
 * doubleClick() 双击
 * dragAndDrop() 拖动
 * release() 释放鼠标
 * perform() 执行所有Actions中存储的行为
 *
 * https://www.selenium.dev/documentation/zh-cn/webdriver/browser_manipulation/
 * @author qq3434569
 */
public class MouseTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");

        WebElement setting = driver.findElement(By.xpath("//*[@id=\"s-usersetting-top\"]"));
        Actions action = new Actions(driver);
        action.clickAndHold(setting).perform();
        Thread.sleep(2000);

        WebElement search_setting = driver.findElement(By.xpath("//*[@id=\"s-user-setting-menu\"]/div/a[2]"));
        action.click(search_setting).perform();

        Thread.sleep(2000);
        driver.quit();

    }
}
