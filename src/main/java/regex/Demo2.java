package regex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 忽略大小写
 *
 * @author qq3434569
 */
public class Demo2 {
    public static void main(String[] args) {
        String a = "James has a pet cat.";
        Pattern pattern = Pattern.compile("(?i)james");
        Matcher matcher = pattern.matcher(a);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
