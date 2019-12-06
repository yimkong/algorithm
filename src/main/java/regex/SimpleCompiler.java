package regex;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * author yg
 * description 对于聊天里面的关键字的特殊符号的过滤
 * date 2019/3/21
 */
public class SimpleCompiler {
    private static final String[] fbsArr = {"\\", "$", "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", "|"};

    public static Pattern getLikePattern(String str) {
        String str1 = replaceIllegalStr(str);
        Pattern compile = Pattern.compile(".*(" + str1 + ").*");
        return compile;
    }

    private static String replaceIllegalStr(String str) {
        for (String key : fbsArr) {
            if (str.contains(key)) {
                str = str.replace(key, "\\" + key);
            }
        }
        return str;
    }

    public static void main(String[] args) {
        while (true) {
            InputStream in = System.in;
            Scanner scanner=new Scanner(in);
            String next = scanner.next();
            Pattern abc = getLikePattern(next);
//            Pattern abc = Pattern.compile(next);
            boolean asdf = abc.matcher("asdf").matches();
            System.err.println(asdf);
        }
    }
}
