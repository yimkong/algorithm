package problems;

/**
 * 2025/4/25
 * desc
 */
public class Num58 {
    public static int lengthOfLastWord(String s) {
        s = s.trim();

        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            }
            else if (length > 0) {
                break;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        lengthOfLastWord("day");
    }
}
