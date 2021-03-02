package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 匹配除了字母和数字的所有符号
 *
 * \W搜寻和\w相反的匹配模式。注意，相反匹配模式使用大写字母。此缩写与[^A-Za-z0-9_]是一样的。
 * \D同理
 * 匹配空白字符(\s),匹配非空白字符(\S)
 * 注意，它还会匹配下划线字符（_）
 *
 * @author qq3434569
 */
public class Demo15 {
    public static void main(String[] args) {
        String a = "The five boxing wizards jump quickly.";
        Pattern pattern = Pattern.compile("\\W");
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
