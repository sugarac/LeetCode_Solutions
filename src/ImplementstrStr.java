import java.util.HashMap;
import java.util.Map;

public class ImplementstrStr {
    /**
     * Easy (F,Ap,M)
     * follow up:
     * 1.implement function strstrp(String a, String b) returns index where any permutation of b is a substring of a.
     * e.g.strstrp("hello", ''ell") returns 1 strstrp("hello",  "lle") returns 1 strstrp("hello",  "wor") returns -1
     * 我面试的时候是用解决minimum window那道题的思路考虑的，但面试的小哥说虽然work但实现起来太麻烦，
     * 有个简单的方法，也是用hash table，时间复杂度O(n), 不过没想出来，就用minimum window的方法做的，还没写完。。
     */

    /**
     * Two Pointers O(mn);O(1)
     * For i from 0 to m-n:
     * | For j from 0 to n-1:
     * |   If characters are not the same, break
     * | If j reaches the end of needle, return i.
     * Return -1.
     * Special case:
     * If needle is empty, no need to check , just return 0.
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) { //needle.length - 1 + 1
                return i;
            }
        }
        return -1;
    }

    /**
     * Rabin Karp O(n + m);O(1)
     * 187. Repeated DNA Sequences 也可以用这个方法做，但是不是最优解
     * KMP学习有难度，只能解决这么一个问题。Rabin Karp的思路和naive方法的思路很像。
     * 把字符串比较变成整数比较，即让字符串变成整数，用hash函数，一般是用进制转换实现hash函数。
     * 乘以一个magic number，一般用31，经验值，因为实际运行后发现效果最好。然后取模，要模一个比较大的数。
     * 但hash值可能会冲突，即不同的字符串的hash值可能一样，所以要做一次double check，比较字符串是否一样，这样就是肯定正确的。
     */
    public int strStrB(String s, String t) {
        if (s == null || t == null) {
            return -1;
        }
        if (t.length() == 0) {
            return 0;
        }

        int m = t.length();
        int power = 1;
        int BASE = 1000000;
        for (int i = 0; i < m; i++) {
            power = (power * 31) % BASE; //31 ^ m, 幂, cannot use power = Math.pow(31, m)
        }

        int tHash = 0;
        for (int i = 0; i < m; i++) {
            tHash = (tHash * 31 + t.charAt(i)) % BASE; //注意31的位置，别打错了！
        }

        int sHash = 0;
        for (int i = 0; i < s.length(); i++) {
            sHash = (sHash * 31 + s.charAt(i)) % BASE; //abc || abc + d
            if (i < m - 1) {
                continue;
            }
            if (i >= m) {
                sHash -= (power * s.charAt(i - m)) % BASE; //abcd - a
                if (sHash < 0) {
                    sHash += BASE;
                }
            }
            if (sHash == tHash) { //double check the string to avoid hash conflict //if i == m - 1, also execute this "if"
                if (s.substring(i - m + 1, i + 1).equals(t)) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }

    /**
     * follow up 1: implement function strstrp(String a, String b) returns index where any permutation of b is a substring of a.
     * assume only lowercase letters in strings
     * HashMap + counting sort O(mn);O(n)
     */
    public int strStrC(String s, String t) {
        if (t.length() == 0) {
            return 0;
        }

        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        int m = t.length();
        for (int i = 0; i <= n - m; i++) { //O(n)
            String key = createKey(s.substring(i, i + m));
            if (!map.containsKey(key)) {
                map.put(key, i);
            }
        }
        String tKey = createKey(t);
        if (map.containsKey(tKey)) {
            return map.get(tKey);
        }
        return -1;
    }

    private String createKey(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) { //O(m)
            count[s.charAt(i) - 'a']++;
        }

        String key = "";
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                key += String.valueOf(count[i]) + String.valueOf('a' + i); //(char)('a' + i) is not necessary
            }
        }
        return key;
    }
}
