package Other;

public class CompareVersionNumbers {
    /**
     * Solution1: O(n); O(n)
     * Split each string with dot. Compare each level.
     */
    public int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");
        int m = levels1.length;
        int n = levels2.length;
        int len = Math.max(m, n);
        for (int i = 0; i < len; i++) {
            int a = i < m ? Integer.valueOf(levels1[i]) : 0;
            int b = i < n ? Integer.valueOf(levels2[i]) : 0;
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
        }
        return 0;
    }
}
