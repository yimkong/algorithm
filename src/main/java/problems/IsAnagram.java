package problems;

import dataStructure.HashMap;

import java.util.Arrays;
import java.util.Map;

/**
 * author yg
 * description
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * date 2020/11/22
 */
public class IsAnagram {
    //时间复杂度 O(nlogn+n)=O(nlogn)    +n是比较俩字符串的时间
    //空间复杂度 O(logn)
    public boolean isAnagram1(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);

    }
//时间复杂度 O(n)
    //空间复杂度 O(S) s为字符集大小 此处为26
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = t.charAt(i);
            Integer integer = map.get(c);
            if (integer == null) {
                return false;
            }
            if (integer == 1) {
                map.remove(c);
            }else {
                map.put(c, integer - 1);
            }
        }
        return map.isEmpty();
    }}
