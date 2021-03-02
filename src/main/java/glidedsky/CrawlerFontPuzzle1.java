package glidedsky;

import sun.font.TrueTypeFont;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import util.CookieUtil;
import util.DownLoadUtil;

import java.awt.*;
import java.io.IOException;
import java.util.Base64;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 爬虫3-字体反爬（无ttf框架，）
 *
 * @author qq3434569
 */
public class CrawlerFontPuzzle1 implements PageProcessor {
    public volatile int answer = 0;
    public static Pattern pattern = Pattern.compile("data:font;charset=utf-8;base64,.*?\\)");


    @Override
    public void process(Page page) {
        String rawText = page.getRawText();

//        List<String> numbersStr = page.getHtml().xpath("//*[@id=\"app\"]/main/div[1]/div/div/div/div/text()").all();
//        List<Integer> numbers = numbersStr.stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
//        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
//        addAnswer(sum);
        System.out.println(answer);
    }

    public synchronized void addAnswer(int sum) {
        answer += sum;
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
        site.setSleepTime(2000);
        return site;
    }

    public static void main(String[] args) throws IOException, FontFormatException {
        String a = "src: url(data:font;charset=utf-8;base64,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) format(\"truetype\");\n";
        Matcher matcher = pattern.matcher(a);
        String b = "";
        if (matcher.find()) {
            b = matcher.group(0).replace("data:font;charset=utf-8;base64,", "").replace(")", "");
        }
        System.out.println(b);
        byte[] bytes = Base64.getDecoder().decode(b);
        DownLoadUtil.byteToFile(bytes, "D:/zt.ttf");
        System.out.println(1);
        //        Spider spider = Spider.create(new CrawlerBasic2());
//        spider.thread(100);
//        for (int i = 1; i <= 1; i++) {
//            spider.addUrl("http://www.glidedsky.com/level/web/crawler-font-puzzle-1?page=" + i);
//        }
//        spider.run();
    }
}
