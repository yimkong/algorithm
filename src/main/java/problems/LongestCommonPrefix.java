package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * author yg
 * description
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * date 2020/12/2
 */
public class LongestCommonPrefix {
    //拿第一个字符串与其他字符串比较并截断，全部遍历一遍
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (commonPrefix.length() == j) {
                    break;
                }
                if (commonPrefix.charAt(j) != chars[j]) {
                    commonPrefix = commonPrefix.substring(0, j);
                    break;
                }
            }
            if (commonPrefix.length() > strs[i].length()) {
                commonPrefix = commonPrefix.substring(0, strs[i].length());
            }
        }
        return commonPrefix;
    }

    //纵向扫描
    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        //拿第一个字符串遍历，每拿一个字母，与所有其他字符串的相对的位置比较一遍
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {//当前位置比其他字符串长或者 字母不相等
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
