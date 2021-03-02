package regex;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 指定匹配的上限和下限
 *
 * 你使用加号+查找一个或多个字符，使用星号*查找零个或多个字符
 *
 * 数量说明符指定匹配模式的上下限。数量说明符与花括号（{和}）一起使用。
 * 你可以在花括号之间放两个数字，这两个数字代表匹配模式的上限和下限。
 *
 * 修改正则表达式ohRegex以匹配在"Oh no"中仅出现3到6次的字母h。
 *
 * @author qq3434569
 */
public class Demo17 {
    public static void main(String[] args) {
        String a = "Ohhh no";
        String b = "Ohhhhhhhh no";
        Pattern pattern = Pattern.compile("Oh{3,6}\\s");
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
        System.out.println(pattern.matcher(b).find());

    }
}
