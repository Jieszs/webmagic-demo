package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 匹配字母表中的数字和字母
 * <p>
 * 创建一个正则表达式，使其可以匹配h和s之间的一系列字母，以及2和6之间的一系列数字
 *
 * @author qq3434569
 */
public class Demo7 {
    public static void main(String[] args) {
        String a = "Blueberry 3.141592653s are delicious.";
        Pattern pattern = Pattern.compile("(?i)[h-s]|[2-6]");
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
