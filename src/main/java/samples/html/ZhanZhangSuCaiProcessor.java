package samples.html;

import entity.FileInfo;
import org.apache.commons.collections.CollectionUtils;
import samples.pipeline.FileDownLoadPipeline;
import samples.pipeline.QiuShiBaiKePipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.apache.commons.io.FilenameUtils.getExtension;
import static us.codecraft.webmagic.selector.Selectors.xpath;

/**
 * 站长素材
 * <p>
 * Date: 21-2-24
 * Time: 下午5:31
 *
 * @author qq3434569
 */
public class ZhanZhangSuCaiProcessor implements PageProcessor {

    @Override
    public void process(Page page) {
        List<String> images = page.getHtml().xpath("//*[@id=\"container\"]/div/div/a").all();
        List<FileInfo> fileInfos = getFileInfos(images);
        page.putField("fileInfos", fileInfos);
    }

    private List<FileInfo> getFileInfos(List<String> images) {
        if (CollectionUtils.isEmpty(images)) {
            return null;
        }
        List<FileInfo> fileInfos = new ArrayList<>();
        for (String image : images) {
            String url = "https:" + xpath("//img/@src2").select(image);
            String fileName = xpath("//img/@alt").select(image);
            String extension = getExtension(url);
            FileInfo fileInfo = new FileInfo(url, fileName, extension);
            fileInfos.add(fileInfo);
        }
        return fileInfos;
    }


    @Override
    public Site getSite() {
        return Site.me().setDomain("sc.chinaz.com").setCharset("utf-8").
                setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Spider spider = Spider.create(new ZhanZhangSuCaiProcessor())
                .addUrl("https://sc.chinaz.com/tag_tupian/HeiBai.html")
                .thread(5)
                .addPipeline(new FileDownLoadPipeline("D:/data/webmagic/zhanzhangsucai"));
        for (int i = 2; i < 11; i++) {
            spider.addUrl("https://sc.chinaz.com/tag_tupian/HeiBai_" + i + ".html");
        }
        spider.run();
    }
}
