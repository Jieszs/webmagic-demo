package samples.qiushibaike;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.FileCacheQueueScheduler;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 糗事百科
 * <p>
 * Date: 21-2-24
 * Time: 下午5:31
 *
 * @author qq3434569
 */
public class QiuShiBaiKeProcessor implements PageProcessor {
    @Override
    public void process(Page page) {
        List<String> authors = page.getHtml().xpath("//*[@class=\"author clearfix\"]/a[2]/h2/text()").all();
        List<String> ages = page.getHtml().xpath("//*[@class=\"author clearfix\"]/div/text()").all();
        List<String> contents = page.getHtml().xpath("//*[@class=\"article block untagged mb15 typs_hot\"or @class=\"article block untagged mb15 typs_long\"]/a[1]/div/span[1]/text()").all();
        List<String> likeCount = page.getHtml().xpath("//*[@class=\"article block untagged mb15 typs_hot\"or @class=\"article block untagged mb15 typs_long\"]/div[2]/span[1]/i/text()").all();
        List<String> commentCount = page.getHtml().xpath("//*[@class=\"article block untagged mb15 typs_hot\"or @class=\"article block untagged mb15 typs_long\"]/div[2]/span[2]/a/i/text()").all();
        page.putField("authors",authors);
        page.putField("ages",ages);
        page.putField("contents",contents);
        page.putField("likeCount",likeCount);
        page.putField("commentCount",commentCount);

    }

    @Override
    public Site getSite() {
        return Site.me().setDomain("www.qiushibaike.com").setCharset("utf-8").
                setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Spider.create(new QiuShiBaiKeProcessor()).addUrl("https://www.qiushibaike.com/text/")
                .addPipeline(new QiuShiBaiKePipeline("D:/data/webmagic/qiushibaike")).run();
    }
}
