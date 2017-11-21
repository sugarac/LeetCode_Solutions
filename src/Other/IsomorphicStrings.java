package Other;

public class IsomorphicStrings {
    /**
     * Solution1: O(n); O(1)
     * Store the previous seen positions of current (i-th) characters in both strings.
     * If previously stored positions are different then we know that the fact they're occurring
     * in the current i-th position simultaneously is a mistake.
     * We could use a map for storing but as we deal with chars which are basically ints and
     * can be used as indices, so we can do the whole thing with an array.
     */
    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] != map[t.charAt(i) + 256]) {
                return false;
            }
            map[s.charAt(i)] = map[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }
}
