package Other;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    /**
     * Generate 0, 1 then add 10 from back to get 11, 10
     * same goes for 00, 01, 11, 10, add 100 to get 110, 111, 101, 100
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            int size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                res.add(res.get(j) | 1 << i); //+的优先级在<<前; +, <<, |
            }
        }
        return res;
    }

    /**
     * Math O(n); O(1)
     * G(i) = I ^ i/2
     */
    public List<Integer> grayCodeB(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            res.add(i ^ i >> 1);
        }
        return res;
    }
}
