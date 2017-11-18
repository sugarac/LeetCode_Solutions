public class OneEditDistance {
    /**
     * Solution1: Iterative O(n); O(1)
     * Compare the lengths of two strings, always put the shorter string as the first parameter.
     * If the difference of their lengths are larger than 1, return false.
     * Traverse the shorter string to find a different char.
     * If found and they are of same length, the rest of them should be the same.
     * If found and they are of different length, the rest of shorter string, including that char,
     * should be the same as the rest of longer string, excluding that char.
     * If all chars are the same, it can only be the last character in longer string.
     * Return true iff longer string is one character longer.
     */
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }

        if (m > n) {
            return isOneEditDistance(t, s);
        }
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                continue;
            }

            if (m == n) {
                return s.substring(i + 1).equals(t.substring(i + 1));
            }
            return s.substring(i).equals(t.substring(i + 1));
        }
        return m != n; //cannot return false since the corner case can be only the last char is different. a, ab
    }
}
