package NonFacebookTag;

public class IntegerToRoman {
    /**
     * O(n);O(1)
     * 整数到罗马数：从左往右遍历，两个dict array
     * 罗马数到整数：从右往左遍历，switch-case
     */
    public String intToRoman(int num) {
        int[] intDict = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romaDict = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intDict.length; i++) {
            while (num >= intDict[i]) {
                num -= intDict[i];
                sb.append(romaDict[i]);
            }
        }
        return sb.toString();
    }
}
