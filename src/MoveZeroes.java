public class MoveZeroes {
    /**
     * Easy
     * follow up: see below
     */

    /**
     * 同向Two Pointers O(n);O(1) 从左往右
     * left point to zero's start(遇到0不动，遇到非0先换后动), right point to zero's end(遇到0动，遇到非0先换后动)
     * All elements between the left and right pointer are zeroes.
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
//                int temp = nums[left];
//                nums[left] = nums[right];
//                nums[right] = temp;
                nums[left] = nums[right]; //swap the nonzero number to left
                nums[right] = 0;
                left++;
            }
        }
    }

    /**
     * follow up 1.moveZero到前面，moveOne到后面，不改变顺序
     * 同向Two Pointers O(n);O(1) 从右往左
     */
    public void moveZeroesB(int[] nums) {
        int right = nums.length - 1;
        for (int left = nums.length - 1; left >= 0; left--) {
            if (nums[left] != 0) {
                nums[right] = nums[left]; //swap the nonzero number to right
                nums[left] = 0;
                right--;
            }
        }
    }

    /**
     * follow up 2.将所有的非零元素移动到数组最前面，返回零的个数(有时也会要求返回非0的个数)，比如[1,0,3,0,4,5,0,1] => [1,3,4,5,1, X,X,X] 顺序不要紧，
     * 移动之后数组后面几个元素可以是任意值, 要求最小化写入次数。
     * 区别：Move zeros要求把所有的0移动到数组的后面，这题不需要，只需要把非零元素移动到数组前面，而且不要求保持顺序
     */
    public int moveZeroesC(int[] nums) {
        int left  = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] != 0) {
                left++;
            }
            while (left < right && nums[right] == 0) {
                right--;
            }
            if (left < right) {
                nums[left++] = nums[right--];
            }
        }
        return left; //非0的个数
//        return nums.length - left; //0的个数
    }
}
