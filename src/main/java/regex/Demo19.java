package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正向先行断言和负向先行断言
 *
 * 有两种先行断言：正向先行断言和负向先行断言。
 *
 * 正向先行断言会查看并确保搜索匹配模式中的元素存在，但实际上并不匹配。
 * 正向先行断言的用法是(?=...)，其中...就是需要存在但不会被匹配的部分。
 * 负向先行断言会查看并确保搜索匹配模式中的元素不存在。负向先行断言的用法是(?!...)，
 * 其中...是你希望不存在的匹配模式。如果负向先行断言部分不存在，将返回匹配模式的其余部分。
 *
 *
 * let quit = "qu";
 * let noquit = "qt";
 * let quRegex= /q(?=u)/;
 * let qRegex = /q(?!u)/;
 * quit.match(quRegex); // Returns ["q"]
 * noquit.match(qRegex); // Returns ["q"]
 *
 *
 * 使用先行断言以匹配至少5个字符且有两个连续数字的密码。
 * @author qq3434569
 */
public class Demo19 {
    public static void main(String[] args) {
        String a = "bana12";
        //在\d{2}之前不使用.* ，检查的是最初出现的两位数，本人也不知道原因。
        Pattern pattern = Pattern.compile("(?=\\w{5,})(?=\\d{2,})");
        Matcher matcher = pattern.matcher(a);
        System.out.println(matcher.find());
        //在\d{2}之前使用.* ，因为连续的数字可能出现在字符串中的任何位置。
        System.out.println(Pattern.compile("(?=\\w{5,})(?=.*\\d{2,})").matcher(a).find());
        //因为这个又是true,令人困惑
        System.out.println(Pattern.compile("(?=\\d{2,})").matcher(a).find());
        System.out.println(Pattern.compile("(?=.*\\d{2,})(?=\\w{5,})").matcher(a).find());
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
