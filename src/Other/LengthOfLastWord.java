package Other;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = 0;
        int tail = s.length() - 1;
        while (tail >= 0 && s.charAt(tail) == ' ') {
            tail--;
        }

        while (tail >= 0 && s.charAt(tail) != ' ') {
            tail--;
            len++;
        }

        // for (int i = tail; i >= 0; i--) {
        //     if (s.charAt(i) == ' ') {
        //         return len;
        //     }
        //     len++;
        // }
        return len;
    }
}
