package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用通配符.匹配任何内容
 *
 * @author qq3434569
 */
public class Demo4 {
    public static void main(String[] args) {
        String a = "Let's have fun with regular expressions!";
        Pattern pattern = Pattern.compile(".un");
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
