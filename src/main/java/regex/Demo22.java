package regex;

/**
 * 删除开头和结尾的空白
 *
 * @author qq3434569
 */
public class Demo22 {
    public static void main(String[] args) {
        String a = "   Hello,    World!  ";
        a = a.replaceAll("^\\s+|\\s+$", "");
        System.out.println(a);
    }
}
