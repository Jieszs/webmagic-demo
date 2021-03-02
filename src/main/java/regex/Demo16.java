package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 限制可能的用户名
 *
 * 1) 用户名中的数字必须在最后，且数字可以有零个或多个。
 *
 * 2) 用户名字母可以是小写字母和大写字母。
 *
 * 3) 用户名长度必须至少为两个字符。两位用户名只能使用字母。
 *
 * @author qq3434569
 */
public class Demo16 {
    public static void main(String[] args) {
        String a = "JackOfAllTrades";
        Pattern pattern = Pattern.compile("[a-zA-Z]{2,}[0-9]{0,}");
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
