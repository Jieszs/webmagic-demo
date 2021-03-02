package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 匹配出现零次或多次的字符
 * <p>
 * 加号+来查找出现一次或多次的字符。还有一个选项可以匹配出现零次或多次的字符。
 * <p>
 * 执行该操作的字符叫做asterisk或star，即*
 * <p>
 * 使用*符号在chewieQuote中匹配"A"及其之后出现的零个或多个"a"
 *
 * @author qq3434569
 */
public class Demo10 {

    public static void main(String[] args) {
        String a = "Aaaaaaaaaaaaaaaarrrgh!";
        Pattern pattern = Pattern.compile("Aa*");
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
