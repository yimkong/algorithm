package regex;

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
}
