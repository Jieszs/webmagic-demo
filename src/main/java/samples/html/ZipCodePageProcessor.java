package samples.html;

import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.PriorityScheduler;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static us.codecraft.webmagic.selector.Selectors.xpath;


/**
 * 获取全国各地区邮编
 *
 * 正则表达式从字符串中提取元素
 * 进行垂直爬虫
 * 使用scheduler
 *
 * @author qq3434569
 */
public class ZipCodePageProcessor implements PageProcessor {

    private Site site = Site.me().setCharset("gb2312")
            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31")
            .setSleepTime(100);

    @Override
    public void process(Page page) {
        if (page.getUrl().toString().equals("http://www.ip138.com/post/")) {
            processCountry(page);
        } else {
            processProvince(page);
        }

    }

    private void processCountry(Page page) {
        List<String> provinces = page.getHtml().xpath("//*[@id=\"quanguo\"]/tbody/tr/td/a").all();
        for (String province : provinces) {
            String link = "http://www.ip138.com" + xpath("a/@href").select(province);
            String title = xpath("a/text()").select(province);
            Request request = new Request(link).setPriority(0).putExtra("province", title);
            page.addTargetRequest(request);
        }
    }

    private void processProvince(Page page) {
        //这里仅靠xpath没法精准定位，所以使用正则作为筛选，不符合正则的会被过滤掉
        String province = page.getRequest().getExtra("province").toString();
        List<String> districts = page.getHtml().xpath("/html/body/div/div/div/div/table/tbody/tr[@bgcolor=\"#ffffff\"]").all();
        Pattern pattern = Pattern.compile("<td>([^<>]+)</td>.*?href=\"(.*?)\"", Pattern.DOTALL);

        for (String district : districts) {
            Matcher matcher = pattern.matcher(district);
            while (matcher.find()) {
                String title = matcher.group(1);
                String zipCode = matcher.group(2);
                zipCode = StringUtils.isEmpty(zipCode) ? "" : zipCode.replace("/", "");
                System.out.println(StringUtils.join(new String[]{province, title,
                        zipCode}, "\t"));
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        Spider spider = Spider.create(new ZipCodePageProcessor()).scheduler(new PriorityScheduler()).addUrl("http://www.ip138.com/post/");

        spider.run();
    }
}
