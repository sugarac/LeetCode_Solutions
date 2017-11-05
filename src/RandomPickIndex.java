import java.util.Arrays;
import java.util.Random;

public class RandomPickIndex {
    /**
     * Medium
     * follow up:
     * 1.只返回最大值的index(只考这个变种）
     * 2.问为啥能保证probability相同，第一次写了two pass（先找到最⼤大值，再random pick），让改写one pass
     */

    int[] nums;
    Random rand;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    public int pick(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            } else if (rand.nextInt(++count) == 0) {
                res = i;
            }
        }
        return res;
    }
}
