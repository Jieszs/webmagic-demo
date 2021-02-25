package samples.html;

import entity.FileInfo;
import org.apache.commons.collections.CollectionUtils;
import samples.pipeline.FileDownLoadPipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.io.FilenameUtils.getExtension;
import static us.codecraft.webmagic.selector.Selectors.xpath;

/**
 * 典尚视频
 * <p>
 * Date: 21-2-24
 * Time: 下午5:31
 *
 * @author qq3434569
 */
public class DianShanShiPinProcessor implements PageProcessor {

    @Override
    public void process(Page page) {
        if (page.getUrl().toString().startsWith("http://sp.jzsc.net/search")) {
            List<String> links = page.getHtml().xpath("//*[@class=\"Wimg\"]/a/@href").all();
            if (CollectionUtils.isEmpty(links)) {
                return;
            }
            for (String link : links) {
                page.addTargetRequest(new Request("http://sp.jzsc.net" + link));
            }
        } else {
            List<FileInfo> fileInfos = new ArrayList<>();
            String video = page.getHtml().xpath("//*[@id=\"id\"]/@src").toString();
            String title = page.getHtml().xpath("//*[@class=\"Simg\"]/@title").toString();
            String url = "http://sp.jzsc.net" + video;
            String extension = getExtension(url);
            FileInfo fileInfo = new FileInfo(url, title, extension);
            fileInfos.add(fileInfo);
            page.putField("fileInfos", fileInfos);
        }

    }

    @Override
    public Site getSite() {
        return Site.me().setDomain("sp.jzsc.net").setCharset("utf-8").
                setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        Spider spider = Spider.create(new DianShanShiPinProcessor())
                .addUrl("http://sp.jzsc.net/search?b=1&wtid=2722&attr=320&order=time")
                .thread(5)
                .addPipeline(new FileDownLoadPipeline("D:/data/webmagic/dianshan"));
        for (int i = 2; i < 6; i++) {
            spider.addUrl("http://sp.jzsc.net/search?b=1&wtid=2722&attr=320&dowtype=0&order=time&Page=" + i);
        }
        spider.run();
    }
}
