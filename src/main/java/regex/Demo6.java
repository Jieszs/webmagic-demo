package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 匹配字母表中的字母
 * <p>
 * 将单个字符与多种可能性匹配[ ] 连字符（-）来定义要匹配的字符范围
 * 要匹配小写字母a到e，你可以使用[a-e]。
 *
 * @author qq3434569
 */
public class Demo6 {
    public static void main(String[] args) {
        String a = "The quick brown fox jumps over the lazy dog.";
        Pattern pattern = Pattern.compile("(?i)[a-e]");
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
