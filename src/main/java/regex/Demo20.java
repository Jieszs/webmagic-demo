package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用捕获组重用模式
 *
 * 使用捕获组搜寻重复的子字符串。括号(和)可以用来匹配重复的子字符串。
 * 你只需要把重复匹配模式的正则表达式放在括号中即可。
 *
 * 要指定重复字符串将出现的位置，可以使用反斜杠（\）后接一个数字。
 * 这个数字从 1 开始，随着你使用的每个捕获组的增加而增加。
 * 这里有一个示例，\1可以匹配第一个组。
 *
 *
 * let repeatStr = "regex regex";
 * let repeatRegex = /(\w+)\s\1/;
 * repeatRegex.test(repeatStr); // Returns true
 * repeatStr.match(repeatRegex); // Returns ["regex regex", "regex"]
 *
 *
 * @author qq3434569
 */
public class Demo20 {
    public static void main(String[] args) {
        String a = "42 42 42";
        Pattern pattern = Pattern.compile("^(\\d+)\\s\\1\\s\\1$");
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
