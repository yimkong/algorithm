package problems;

/**
 * author yg
 * description
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 * <p>
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= k < s.length <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * date 2020/10/19
 */
public class ReverseString {
    //字符串切片
    public String reverseLeftWords(String s, int n) {
        String sb = s.substring(n) +
                s.substring(0, n);
        return sb;
    }

    //列表拼接
    public String reverseLeftWords2(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();
    }

    //字符串拼接
    public String reverseLeftWords3(String s, int n) {
        String result = "";
        for (int i = n; i < n + s.length(); i++) {
            result += s.charAt(i % s.length());
        }
        return result;
    }
}
