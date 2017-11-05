public class MultiplyStrings {
    /**
     * Medium (F,Tw)
     */

    /**
     * Math O(m + n)
     * Start from right to left, multiply each pair of digits, and add them together.
     * The result of num1[i] * num2[j] will be placed at i + j and i + j + 1.
     */
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        }
        if (num1.length() == 0 || num2.length() == 0 || num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] product = new int[m + n];
        for (int i = m - 1; i >= 0; i--) { //num2 * num1
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + product[p2];
                product[p1] += sum / 10; //原来的+现在的，i=m-1时，num[p1] = 0;
                product[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : product) {
            if (p != 0 || sb.length() != 0) {
                sb.append(p);
            }
        }
        return sb.toString();
    }
}
