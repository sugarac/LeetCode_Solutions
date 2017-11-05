package Other;

public class StringtoInteger {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int i = 0;
        int sign = 1;
        int total = 0;
        while (str.charAt(i) == ' ' && i < str.length()) { //remove whitespaces
            i++;
        }

        if (str.charAt(i) == '+' || str.charAt(i) == '-') { //handle the sign
            sign = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        for (; i < str.length(); i++) { //calculate the total
            int digit = str.charAt(i) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }

            if (total > Integer.MAX_VALUE / 10 || total == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + digit;
        }
        return sign * total;
    }
}
