package Other;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    /**
     * Convert to long to avoid overflow.
     * Divide into three parts, sign, before dot and after dot.
     * Before dot = numerator / denominator. After dot = remainder * 10 / denominator.
     * If a reminder already showed up, insert parentheses and return result.
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return "";
        }
        if (numerator == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        res.append((numerator > 0) ^ (denominator > 0) ? "-" : "");

        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        res.append(n / d);
        long r = n % d;
        if (r == 0) {
            return res.toString();
        }

        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(r, res.length());
        while (r != 0) {
            r *= 10;
            res.append(r / d);
            r %= d;
            if (map.containsKey(r)) {
                res.insert(map.get(r), "(");
                res.append(")");
                break;
            }
            map.put(r, res.length());
        }
        return res.toString();
    }
}
