package Other;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums,0, k - 1);
        reverse(nums,k, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

//    public void rotateB(int[] nums, int k) { //TLE
//        int n = nums.length;
//        for (int i = 0; i < k % n; i++) {
//            int temp = nums[n - 1];
//            for (int j = n - 1; j > 0; j--) {
//                nums[j] = nums[j - 1];
//            }
//            nums[0] = temp;
//        }
//    }
}
