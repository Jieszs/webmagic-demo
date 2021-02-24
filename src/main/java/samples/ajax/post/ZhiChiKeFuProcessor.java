package samples.ajax.post;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * 删除智齿客服的客户列表中的某个客户
 * <p>
 * 先完成登录，再从f12开发者工具中获取temp-id
 * Date: 21-2-24
 * Time: 下午5:31
 *
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
        Request request = new Request("https://www.sobot.com/basic/deleteUserInfo/4");
        request.setMethod(HttpConstant.Method.POST);
        Map<String, Object> params = new HashMap<>();
        params.put("id","e1eafd6751084442b00eedf31919d4f2");
        request.setRequestBody(HttpRequestBody.form(params,"utf-8"));
        Spider.create(new ZhiChiKeFuProcessor()).addRequest(request).run();
    }
}
