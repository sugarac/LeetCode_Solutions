package NonFacebookTag;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }

        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        long m = Math.abs((long) dividend);
        long n = Math.abs((long) divisor);

        int res = 0;
        while (m >= n) {
            long temp = n;
            int multiple = 1;
            while (m >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            m -= temp;
            res += multiple;
        }
        return sign * res;
    }
}
