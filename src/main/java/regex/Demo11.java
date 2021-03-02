package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用惰性匹配来查找字符  ?
 *
 * 将正则表达式/t[a-z]*i/应用于字符串"titanic"。这个正则表达式是一个以t开始，以i结束，并且中间有一些字母的匹配模式。
 * 你可以使用?字符来将其变成懒惰匹配。调整后的正则表达式/t[a-z]*?i/匹配字符串"titanic"返回["ti"]
 *
 *
 * 修复正则表达式/<.*>/，让它返回 HTML 标签<h1>，而不是文本"<h1>Winter is coming</h1>"。请记得在正则表达式中使用通配符.来匹配任意字符。
 * @author qq3434569
 */
public class Demo11 {

    public static void main(String[] args) {
        String a = "<h1>Winter is coming</h1>";
        Pattern pattern = Pattern.compile("<.*?>");
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
        Pattern pattern1 = Pattern.compile("<.*>");
        Matcher matcher1 = pattern1.matcher(a);
        while (matcher1.find()) {
            System.out.println(matcher1.group(0));
        }

    }
}
