package Other;

public class ExcelSheetColumnTitle {
    /**
     * Iterative O(n); O(1)
     * Calculate from lower bit to higher bit, that is mod first and then divide.
     */
    public String convertToTitleB(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            res.insert(0, (char) ('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        }
        return res.toString();
    }

    /**
     *
     */
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char) ('A' + (n % 26)); //(char) is necessary!
    }
}
