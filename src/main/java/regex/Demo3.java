package regex;

import java.awt.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 多次搜寻或提取匹配模式
 *
 * @author qq3434569
 */
public class Demo3 {
    public static void main(String[] args)  {
        String a = "Twinkle, twinkle, little star";
        Pattern pattern = Pattern.compile("(?i)twinkle");
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
