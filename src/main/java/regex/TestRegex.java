package regex;

import java.util.regex.Pattern;

/**
 * author yg
 * description
 * date 2020/6/20
 */
public class TestRegex {
    public static void main(String[] args) {
        //所有以圆点开头并且第二个字符不包含圆点
        Pattern compile = Pattern.compile("\\.[^.]?");
        boolean matches = compile.matcher("..").matches();
        System.err.println(matches);
        matches = compile.matcher(".a").matches();
        System.err.println(matches);
        matches = compile.matcher("a").matches();
        System.err.println(matches);
        matches = compile.matcher(".").matches();
        System.err.println(matches);
    }
}
