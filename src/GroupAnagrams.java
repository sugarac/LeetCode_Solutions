import java.util.*;

public class GroupAnagrams {
    /**
     * Medium (F,A,U,B,Y)
     * follow up:
     * 1.用counting sort优化
     */

    /**
     * HashMap + counting sort O(nL);O(n)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return null;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] keyChar = new char[26]; //cannot use int to replace char
            for (int i = 0; i < str.length(); i++) {
                keyChar[str.charAt(i) - 'a']++;
            }
            String keyStr = String.valueOf(keyChar);

/*          int[] count = new int[26]; //cuz inputs are lowercase letters, we only need 26
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            String keyStr = "";//build a string key, eg."aabcccdd" -> 2a1b3c2d
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    keyStr += String.valueOf(count[i]) + String.valueOf((char) ('a' + i));
                }
            }*/

            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * HashMap O(nLlogL);O(n)
     */
    public List<List<String>> groupAnagramsB(String[] strs) {
        if (strs == null) {
            return null;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String keyStr = String.valueOf(c);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(str);
        }
//        res = (List)map.values(); // will lead to java.lang.ClassCastException
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        char[] keyChar = new char[26];
        keyChar[3]++;
        System.out.println(keyChar[3]);
    }
}
