package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 将单个字符与多种可能性匹配
 * <p>
 * 同时匹配大小写元音。
 *
 * @author qq3434569
 */
public class Demo5 {
    public static void main(String[] args) {
        String a = "Beware of bugs in the above code; I have only proved it correct, not tried it.";
        Pattern pattern = Pattern.compile("(?i)[aoieu]");
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
