package regex;

import java.awt.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 匹配出现一次或多次的字符
 *
 * 你希望在字符串"Mississippi"中匹配到出现一次或多次的字母s的匹配项。编写一个使用+符号的正则表达式。
 * @author qq3434569
 */
public class Demo9 {
    public static void main(String[] args) throws IOException, FontFormatException {
        String a1 = "Mississippi";
        Pattern pattern1 = Pattern.compile("(?i)s+");
        Matcher matcher1 = pattern1.matcher(a1);
        while (matcher1.find()) {
            System.out.println(matcher1.group(0));;
        }
    }
}
