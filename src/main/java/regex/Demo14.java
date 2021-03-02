package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 匹配所有的字母和数字
 *
 * \w，这个缩写等同于[A-Za-z0-9_]
 * \d,这个缩写等同于[0-9]
 * 匹配空白字符(\s),匹配非空白字符(\S)
 * 注意，它还会匹配下划线字符（_）
 *
 * @author qq3434569
 */
public class Demo14 {
    public static void main(String[] args) {
        String a = "The five boxing wizards jump quickly.___";
        Pattern pattern = Pattern.compile("\\w");
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
