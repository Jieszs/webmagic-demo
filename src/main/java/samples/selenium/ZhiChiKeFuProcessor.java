package samples.selenium;

import samples.ajax.get.ZhiChiKeFuListProcessor;
import samples.download.ChromeDownloader;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 智齿客服，模拟登录，查询客户列表操作
 *
 * @author qq3434569
 */
public class ZhiChiKeFuProcessor implements PageProcessor {
    private static final String LOGIN_URL = "https://www.sobot.com/console/login";
    private static final String USER_LIST_URL = "https://www.sobot.com/console/customerCenter/customer";

    @Override
    public void process(Page page) {
        String url = page.getUrl().toString();
        if (LOGIN_URL.equals(url)) {
            page.addTargetRequest(USER_LIST_URL);
        } else if (USER_LIST_URL.equals(url)) {
            String user= page.getHtml().xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[2]/div/div[2]/div/div/div[3]/div/table/tbody/tr[1]/td[3]/text()").toString();
            System.out.println(user);
        }

    }

    @Override
    public Site getSite() {
        return Site
                .me()
                .setDomain("www.sobot.com")
                .setCharset("utf-8")
                .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

    }

    public static void main(String[] args) {
        ChromeDownloader downloader = new ChromeDownloader();
        downloader.setDriverProcessor(new ZhiChiKeFuDriverProcessor());
        Spider.create(new ZhiChiKeFuProcessor())
                .addUrl("https://www.sobot.com/console/login")
                .setDownloader(downloader)
                .run();
    }
}
