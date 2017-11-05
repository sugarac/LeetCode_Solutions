import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    /**
     * S = "ADOBECODEBANC"
     * T = "ABC"
     * ADOBEC -> DOBECODEBA -> CODEBA -> ODEBANC -> BANC
     */

    /**
     * Hard (F,L,U,S)
     * follow up:
     * 1.没有String t, 返回包括s中所有不重复字符的最短substring(可以把t想成s的remove duplicate characters以后剩下的)。
     * 基本思路一样, 修改少量代码即可
     * 2.不一样的是T给的是set, 不会有重复, 一样瞬秒， 开始问我时间复杂度，我说O(n)他又开始一顿扯，我说T的size 并不影响，最后他同意
     * 最后要我写test case, 后来当T是空的时候会有问题， 我马上改了bug就结束
     */

    /**
     * map array + Two Pointers O(n);512 Byte
     * 1. Use two pointers: left and right to represent a window.
     * 2. Move right to find a valid window.
     * 3. When a valid window is found, move left to find a smaller window.
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() == 0) {
            return "";
        }

        int[] map = new int[128];
        for (char c : t.toCharArray()) { //if use charAt, will lead to low efficiency, don't know why
            map[c]++;
        }
/*        int count = 0; //follow up 1
        for (char c : s.toCharArray()) {
            if (map[c] == 0) {
                map[c]++;
                count++;
            }
        }*/

        int count = t.length(); //the number of non-included char of t in window, check if current substring is valid
        int left = 0, right = 0; //two pointers, one point to tail and one head
        int minStart = 0, minLen = Integer.MAX_VALUE; //the start index of substring, the length of substring
        while (right < s.length()) {
            if (map[s.charAt(right++)]-- > 0) { //meet existent char of t in s.  If it does not exist in t, the count will be negative.
                count--;
            }
            while (count == 0) { //When we found a valid window, move left pointer to find smaller window.
                if (right - left < minLen) {
                    minStart = left;
                    minLen = right - left;
                }
                if (map[s.charAt(left++)]++ == 0) { //skip one char of t in s, so the counter need increase by one
                    count++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    /**
     * HashMap + Two Pointers O(n);O(n)
     */
    public String minWindowB(String s, String t) {
        if (s == null || t == null) {
            return null;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, 0);
        }
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                return "";
            }
        }

        int low = 0;
        int high = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int count = t.length();
        while (high < s.length()) {
            char c1 = s.charAt(high);
            if (map.get(c1) > 0) {
                count--;
            }
            map.put(c1, map.get(c1) - 1);
            high++;

            while (count == 0) {
                if (minLen > high - low) {
                    minLen = high - low;
                    minStart = low;
                }

                char c2 = s.charAt(low);
                map.put(c2, map.get(c2) + 1);
                if (map.get(c2) > 0) {
                    count++;
                }
                low++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
