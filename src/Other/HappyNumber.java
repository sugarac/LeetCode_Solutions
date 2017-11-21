package Other;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    /**
     * Solution1: O(1); O(1)
     * Use the idea of Floyd Cycle detection algorithm.
     * A non-happy number will definitely generate a loop since the sum of the squares of any number’s digits is finite.
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(digitSquareSum(fast));
            // if (fast == 1) {
            //     return true;
            // }
        } while (slow != fast);
        return slow == 1;
    }

    private int digitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    /**
     * Solution2: HashSet O(1); O(1)
     */
    public boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            n = digitSquareSum(n);
        }
        return n == 1;
    }
}
