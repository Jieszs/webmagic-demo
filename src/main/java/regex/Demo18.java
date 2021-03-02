package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 检查全部或无
 *
 * 可以使用问号?指定可能存在的元素。这将检查前面的零个或一个元素
 *
 * 修改正则表达式favRegex以匹配美式英语（favorite）和英式英语（favourite）的单词版本。
 * @author qq3434569
 */
public class Demo18 {
    public static void main(String[] args) {
        String a = "favorite";
        Pattern pattern = Pattern.compile("favou?rite");
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
