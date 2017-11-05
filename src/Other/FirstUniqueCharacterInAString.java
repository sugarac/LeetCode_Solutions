package Other;

public class FirstUniqueCharacterInAString {
    /**
     * O(n); O(1)
     * In first pass, record frequency of each character in given string.
     * In second pass, find first character that has a frequency of one.
     */
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * O(n^2); O(1)
     */
    public int firstUniqCharB(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j < n; j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    break;
                }
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }
}
