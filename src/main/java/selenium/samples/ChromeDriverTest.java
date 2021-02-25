package selenium.samples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *测试ChromeDriver是否成功
 *
 * 1.下载ChromeDriver后，配置环境变量path
 * 2.下载的版本，需要和浏览器版本兼容
 *
 * https://www.selenium.dev/documentation/zh-cn/webdriver/browser_manipulation/
 * @author qq3434569
 */
public class ChromeDriverTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //get 到百度首页
        driver.get("https://www.baidu.com/");
        String title = driver.getTitle();
        System.out.printf(title);
        driver.close();
    }
}
