package regex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 同时用多种模式匹配文字字符串
 *
 * @author qq3434569
 */
public class Demo1 {
    public static void main(String[] args) {
        String a = "James has a pet cat.";
        Pattern pattern = Pattern.compile("cat|dog|bird");
        Matcher matcher = pattern.matcher(a);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
