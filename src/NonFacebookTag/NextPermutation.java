package NonFacebookTag;

public class NextPermutation {
    /**
     *
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
//            for (int j = i + 1; j <= nums.length; j++) {
//                if (j == nums.length || nums[j] <= nums[i]) {
//                    swap(nums, i, j - 1);
//                    break;
//                }
//            }
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int low) {
        int high = nums.length - 1;
        while (low < high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }
}
