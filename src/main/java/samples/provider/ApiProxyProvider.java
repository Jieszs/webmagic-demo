package samples.provider;

import samples.ajax.get.IpProxyProcessor;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.ProxyProvider;

/**
 * 通过api获取代理ip
 * @author qq3434569
 */
public class ApiProxyProvider implements ProxyProvider {
    @Override
    public void returnProxy(Proxy proxy, Page page, Task task) {

    }

    @Override
    public Proxy getProxy(Task task) {
        IpProxyProcessor proxyProcessor = new IpProxyProcessor();
        Spider.create(proxyProcessor).addUrl("http://127.0.0.1:5010/get/").run();
        return proxyProcessor.getProxy();
    }
}
