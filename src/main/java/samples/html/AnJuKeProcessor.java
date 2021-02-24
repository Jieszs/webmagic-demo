package samples.html;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * 安居客
 * 有ip验证码操作，需要自行解决
 * Date: 21-2-24
 * Time: 下午5:31
 *
 * @author qq3434569
 */
public class AnJuKeProcessor implements PageProcessor {
    @Override
    public void process(Page page) {
        List<String> a =page.getHtml().xpath("//*[@id=\"container\"]/div/div/div/p/").all();
        List<String> b =page.getHtml().xpath("//*[@id=\"container\"]/div/div/div/a/@href").all();

        a.stream().forEach(System.out::println);
        b.stream().forEach(System.out::println);

    }

    @Override
    public Site getSite() {
        return Site.me().setDomain("anjuke.com").setCharset("utf-8").
                setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
    }

    public static void main(String[] args) {
        Spider.create(new AnJuKeProcessor()).addUrl("https://fz.fang.anjuke.com/fangjia/minhou/").run();
    }
}
