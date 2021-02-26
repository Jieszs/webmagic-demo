package samples.ajax.get;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.proxy.Proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取ip连接池
 * <p>
 * Date: 21-2-24
 * Time: 下午5:31
 *
 * @author qq3434569
 */
public class IpProxyProcessor implements PageProcessor {
    private Proxy proxy;


    @Override
    public void process(Page page) {
        String resp = page.getRawText();
        JSONObject object =JSON.parseObject(resp);
        String ip = object.getString("proxy");
        String s[] = ip.split(":");
        proxy = new Proxy(s[0], Integer.parseInt(s[1]));
    }


    @Override
    public Site getSite() {
        return Site
                .me()
                .setCharset("utf-8")
                .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    public Proxy getProxy() {
        return proxy;
    }

    public static void main(String[] args) {

    }
}
