package Other;

public class ReverseWordsInAString {
    /**
     * O(n); O(n)
     * Trim input string and split it with a space. Use StringBuilder to store result.
     * Traversal backwards and add each non-empty word to result.
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        s = s.trim();
        StringBuilder res = new StringBuilder();
        String[] words = s.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].equals("")) {
                res.append(words[i]);
                if (i != 0) {
                    res.append(" ");
                }
            }
        }
        return res.toString();
    }
}
