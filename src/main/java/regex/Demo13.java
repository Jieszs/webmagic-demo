package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 匹配字符串的末尾
 *
 * 使用^符号来搜寻字符串开头的匹配模式
 * 使用正则表达式的美元符号$来搜寻字符串的结尾
 *
 * @author qq3434569
 */
public class Demo13 {
    public static void main(String[] args) {
        String a = "The last car on a train is the caboose";
        Pattern pattern = Pattern.compile("(?i)caboose$");
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
