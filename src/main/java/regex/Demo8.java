package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 匹配单个未指定的字符
 * <p>
 * 创建一个匹配所有非数字或元音字符的正则表达式。请记得在正则表达式中包含恰当的标志。
 *
 * @author qq3434569
 */
public class Demo8 {
    public static void main(String[] args) {
        String a = "3 blind mice.";
        Pattern pattern = Pattern.compile("(?i)[^aeiou0-9]");
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
