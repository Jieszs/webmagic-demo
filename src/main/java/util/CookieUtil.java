package util;

import java.util.HashMap;
import java.util.Map;

public class CookieUtil {
    public static Map<String, String> getCookieMap(String cookieStr) {
        Map<String, String> map = new HashMap<>(16);
        String[] s = cookieStr.split("; ");
        for (int i = 0; i < s.length; i++) {
            int index = s[i].indexOf("=");
            String key = s[i].substring(0, index);
            String value = index == s[i].length() ? "" : s[i].substring(index + 1);
            map.put(key, value);
        }
        return map;
    }

    public static void main(String[] args) {
        String cookieStr = "Hm_lvt_020fbaad6104bcddd1db12d6b78812f6=1614310288; _ga=GA1.2.121921997.1614310288; _gid=GA1.2.1901849992.1614310288; footprints=eyJpdiI6IkRQK3hMN2hOXC9nT1d1QWpRRGVEVmFBPT0iLCJ2YWx1ZSI6IjhpOVFkQjNQejdZeGZRdk0zZ0VnM2hDZWJpSGR3c29OTHJRa1VHNUI1SEFUQkdJcEswbGMyWndQSlh1ejhSQjgiLCJtYWMiOiJhMWQ0MDk1NGQ2MzQwYzQ2YjBiNTBkYjg0MWNmYzM5YmFkOGFhOTgzNzYzMGY4ODZhOWQ4MjU2ZWQ1MDI1MzdlIn0%3D; _gat_gtag_UA_75859356_3=1; XSRF-TOKEN=eyJpdiI6IktnVTRmRmdxSnlRbWNPWW1NRnU3ZEE9PSIsInZhbHVlIjoiR2xjM2tsWTRTSHlXQkNXd1dJcVNSODdwTUVaaHF2eHdtemdNTjJ6eUhKNXNSVWR2SXNwM2F3XC9iN1YyYjJyK08iLCJtYWMiOiIxOGExMGQxOGRmOTExYTJmZjBmMjI5NDQ0NGZhZjhlY2UxNzMzNzViNTkyZmYzODA4MTc2NWMyNGY3OTYzM2ZiIn0%3D; glidedsky_session=eyJpdiI6IituOUdyNGpGanExMkt4OTVQdXBhV2c9PSIsInZhbHVlIjoiZFhVMjdLZ3pQUFpUTUI1OEVzeVNzaVN3NE5VNVpzOFU2UlVzelwvejFUeW5ZaEYxN0kzMVhLNXY5WlJobll0XC83IiwibWFjIjoiMjhkODNmNjRmOTk5Nzc2N2E2MmQ2ZmZjOTExMjUzY2ZlZmU1ZjVhM2JkZWU4NWNiNTJjYWEyMjdkOWEyMDdjOSJ9; Hm_lpvt_020fbaad6104bcddd1db12d6b78812f6=1614318691";
        getCookieMap(cookieStr).entrySet().stream().forEach(System.out::println);
    }
}
