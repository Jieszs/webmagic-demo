package glidedsky;

import samples.html.AnJuKeProcessor;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import util.CookieUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 爬虫-基础1
 *
 * @author qq3434569
 */
public class CrawlerBasic1 implements PageProcessor {
    @Override
    public void process(Page page) {
        List<String> numbersStr = page.getHtml().xpath("//*[@id=\"app\"]/main/div[1]/div/div/div/div/text()").all();
        List<Integer> numbers = numbersStr.stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        System.out.println(numbers.stream().mapToInt(Integer::intValue).sum());
    }

    @Override
    public Site getSite() {
        Site site = Site.me().setDomain("glidedsky.com").setCharset("utf-8")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("Referer", "http://www.glidedsky.com/login")
                .addHeader("Host", "www.glidedsky.com")
                .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
        Map<String, String> map = CookieUtil.getCookieMap("_ga=GA1.2.488335748.1614319478; _gid=GA1.2.1566336471.1614319478; _gat_gtag_UA_75859356_3=1; Hm_lvt_020fbaad6104bcddd1db12d6b78812f6=1614319478; footprints=eyJpdiI6IjNrTkloRkMwUHNkU0FvRXEwU3c3QUE9PSIsInZhbHVlIjoiRWlBcVNWckd1cGRHdCtabzFKMFBOeVppdzhVRWY2Y2tZNDFYcURtelpnUXdYQ2pTeTR6Tm1MN1FjYUlRM1E3dCIsIm1hYyI6ImQ3YWVjMjYyODE4NzVlZDRkZDBiMjNmNjZkOTg4N2ZhMDk1NzkzNjY4MTcxYWE4YWRmYjhjNTJjZjIyNDI4ODkifQ%3D%3D; XSRF-TOKEN=eyJpdiI6InFXc2VCcnRtXC96VkdQM1NDaERcL0VBUT09IiwidmFsdWUiOiJRdit2b3grNHdRNEMrSHRST1I2MlZBengrcjlHRTNZN2ZWcVZiMVozdHNvWlwvc3psUXNOYXdQbE9vaTIxOTR2dyIsIm1hYyI6ImE4YjdmOGU4OWYzMzhmNjU2ZWZmNjFlYzA2NWY4YWQxMzRlZjljNmY3NjE1NjNjYmVjNjkxZmE3M2Y0MDM1MWQifQ%3D%3D; glidedsky_session=eyJpdiI6InQ1NmdrWnh4aHFEQ2ZPQUtoM0RxRGc9PSIsInZhbHVlIjoicm1jaFhSUThLN0xVK0RIRTRkQUFBcTBVQjQzU0pweU10b3l6MWtQMDhZMlY3UFliVHc2MmV5elV5ck14Y3Z5aCIsIm1hYyI6ImE0NTgyODEwODg1ZTNiOTE2NWZkNjhkOWFiZjhkMDUyMzNhOWZiYmMyMDI5ZTQ2NjNkOTk2YzRlOGY3YWJjZGMifQ%3D%3D; Hm_lpvt_020fbaad6104bcddd1db12d6b78812f6=1614319490");
        for (Map.Entry<String, String> a : map.entrySet()) {
            site.addCookie("www.glidedsky.com", a.getKey(), a.getValue());
        }
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new CrawlerBasic1()).addUrl("http://www.glidedsky.com/level/web/crawler-basic-1").run();
    }
}
