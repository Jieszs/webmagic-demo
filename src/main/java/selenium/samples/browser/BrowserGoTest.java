package selenium.samples.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 模拟浏览器点击、刷新、后退、前进
 * https://www.selenium.dev/documentation/zh-cn/webdriver/browser_manipulation/
 * @author qq3434569
 */
public class BrowserGoTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //get 到百度首页
        driver.get("https://www.baidu.com/");
        System.out.printf("now accesss %s \n", driver.getCurrentUrl());
        Thread.sleep(2000);

        //点击“新闻” 链接
        driver.findElement(By.linkText("新闻")).click();
        System.out.printf("now accesss %s \n", driver.getCurrentUrl());
        Thread.sleep(2000);
        //刷新页面
        driver.navigate().refresh();
        Thread.sleep(2000);
        //执行浏览器后退
        driver.navigate().back();
        System.out.printf("back to %s \n", driver.getCurrentUrl());
        Thread.sleep(2000);

        //执行浏览器前面
        driver.navigate().forward();
        System.out.printf("forward to %s \n", driver.getCurrentUrl());
        Thread.sleep(2000);

        //当你完成了浏览器会话，你应该调用 quit 退出，而不是 close 关闭:
        driver.quit();


    }
}
