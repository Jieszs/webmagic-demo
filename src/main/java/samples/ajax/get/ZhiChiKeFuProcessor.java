package samples.ajax.get;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 获取智齿客服的客户列表
 *
 * 先完成登录，再从f12开发者工具中获取temp-id
 * Date: 21-2-24
 * Time: 下午5:31
 * @author qq3434569
 */
public class ZhiChiKeFuProcessor implements PageProcessor {
    @Override
    public void process(Page page) {
        System.out.println(page.getRawText());
    }

    @Override
    public Site getSite() {
        return Site
                .me()
                .addHeader("temp-id", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiI2MDExMTY4NDdAcXEuY29tIiwiZXhwIjoxNjE0MjIyNzI5fQ.0kWohS0G68pbwHGWv7rMnDigoUXBlwam1S4koJFsJGk")
                .setDomain("www.sobot.com")
                .setCharset("utf-8")
                .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
    }

    public static void main(String[] args) {
        Spider.create(new ZhiChiKeFuProcessor()).addUrl("https://www.sobot.com/basic/getUserList/4?pageNo=1&pageSize=15&queryContent=&queryType=5&userStatus=0").run();
    }
}
