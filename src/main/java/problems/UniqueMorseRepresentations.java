package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * author yg
 * description
 * date 2020/12/10
 */
public class UniqueMorseRepresentations {
    String[] mors = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        char a = 'a';
        Set<String> result = new HashSet<>();
        for (String word : words) {
            String convert = "";
            for (char c : word.toCharArray()) {
                int i = c - a;
                convert += mors[i];
            }
            result.add(convert);
        }
        return result.size();
    }
}
