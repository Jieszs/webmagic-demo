package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 匹配字符串的开头
 *
 * 使用字符集[]中的插入符号（^）来创建一个否定字符集，形如[^thingsThatWillNotBeMatched]。
 * 在字符集之外，插入符号用于字符串的开头搜寻匹配模式
 *
 * @author qq3434569
 */
public class Demo12 {
    public static void main(String[] args) {
        String a = "Cal and Ricky both like racing.";
        Pattern pattern = Pattern.compile("(?i)^Cal");
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
