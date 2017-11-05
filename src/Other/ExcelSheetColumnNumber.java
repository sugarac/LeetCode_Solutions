package Other;

public class ExcelSheetColumnNumber {
    /**
     * Iterative O(n); O(1)
     * Calculate from higher bit to lower bit, that is multiply first and then add.
     */
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            res = res * 26 + c - 'A' + 1;
        }
        return res;
    }
}
