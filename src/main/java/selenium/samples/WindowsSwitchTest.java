package selenium.samples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

/**
 * 窗口切换
 getWindowHandle()： 获得当前窗口句柄。
 getWindowHandles()： 返回的所有窗口的句柄到当前会话。
 switchTo().window()： 用于切换到相应的窗口，与上一节的switchTo().frame()类似，前者用于不同窗口的切换， 后者用于不同表单之间的切换。
 * https://www.selenium.dev/documentation/zh-cn/webdriver/browser_manipulation/
 *
 * @author qq3434569
 */
public class WindowsSwitchTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");

        //获得当前窗口句柄
        String search_handle = driver.getWindowHandle();

        //打开百度注册窗口
        driver.findElement(By.linkText("登录")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("立即注册")).click();

        //获得所有窗口句柄
        Set<String> handles = driver.getWindowHandles();

        //判断是否为注册窗口， 并操作注册窗口上的元素
        for (String handle : handles) {
            if (!handle.equals(search_handle)) {
                //切换到注册页面
                driver.switchTo().window(handle);
                System.out.println("now register window!");
                Thread.sleep(2000);
                driver.findElement(By.name("userName")).clear();
                driver.findElement(By.name("userName")).sendKeys("user name");
                driver.findElement(By.name("phone")).clear();
                driver.findElement(By.name("phone")).sendKeys("phone number");
                //......
                Thread.sleep(2000);
                //关闭当前窗口
                driver.close();
            }
        }
        Thread.sleep(2000);

        driver.quit();
    }


}
