package Other;

public class LongestPalindromicSubstring {
    /**
     * Brute-Force O(n^2);O(1) 实际运行时间还不错，循环中没用substring，省空间
     * Create two integers, one to store the start index of palindrome, the other to store the max length.
     * Expand from center character and center of two chars
     * Update start index and max length according to the returned palindrome’s length
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0;
//        int max = 1;
//        for (int i = 0; i < s.length() - 1; i++) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = extendPalindrome(s, i , i);
            int len2 = extendPalindrome(s, i , i + 1);
            if (max < Math.max(len1, len2)) {
                start = len1 > len2 ? (i - len1 / 2) : (i - len2 / 2 + 1);
                max = Math.max(len1, len2);
            }
        }
        return s.substring(start, start + max);
    }

    private int extendPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    /**
     * Manacher's Algorithm, O(n);O(1) 实际运行时间是上个算法的3倍
     * Insert a special character between each character in a string, and also both at the start and the end.
     * S = “abba” => T = “#a#b#b#a#”.
     * Expand from center
     */
    public String longestPalindromeB(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int len = s.length();
        int start = 0;
        int max = 0;
        for (int i = 1; i <= 2 * len - 1; i++) {
            int count = 1;
            while (i - count >= 0 && i + count <= 2 * len && get(s, i - count) == get(s, i + count)) {
                count++;
            }
            count--;
            if (count > max) {
                start = (i - count) / 2;
                max = count;
            }
        }
        return s.substring(start, start + max);
    }

    private char get(String s, int i) {
        if (i % 2 == 0) {
            return '#';
        } else {
            return s.charAt(i / 2);
        }
    }
}
