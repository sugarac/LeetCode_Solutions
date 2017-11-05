public class CountAndSay {
    /**
     * Easy
     * follow up;
     * 1.给你一个数字比如111112222333112，返回每个数字出现的个数和数字本身，这个例子的返回为5142332112. 写完之后问这个返回的result，最短多长，最长多长。
     * 最短(ceiling of log10 n) + 1, 最长2n
     */

    /**
     * O(n);O(n)
     */
    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }

        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j <= s.length(); j++) {
                if (j == s.length() || s.charAt(j - 1) != s.charAt(j)) {
                    sb.append(count);
                    sb.append(s.charAt(j - 1));
                    count = 1;
                } else {
                    count++;
                }
            }
            s = sb.toString();
        }
        return s;
    }
}
