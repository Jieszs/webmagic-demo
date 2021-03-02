package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用捕获组搜索和替换
 * <p>
 * <p>
 * 你还可以使用美元符号（$）访问替换字符串中的捕获组。
 * <p>
 * "Code Camp".replace(/(\w+)\s(\w+)/, '$2 $1');
 * // Returns "Camp Code"
 *
 * @author qq3434569
 */
public class Demo21 {
    public static void main(String[] args) {
        String a = "Code Camp";
        a = a.replaceAll("(\\w+)\\s(\\w+)", "$2 $1");
        System.out.println(a);

        String phone = "18310005432";
        phone = phone.replaceAll("(\\d{3})\\d+(\\d{4})", "$1****$2");
        System.out.println(phone);// 183****5432
    }
}
