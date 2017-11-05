import java.util.ArrayList;
import java.util.List;

public class PreviousPermutation {
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
        if (nums == null || nums.size() <= 1) {
            return nums;
        }

        int i = nums.size() - 2;
        while (i >= 0 && nums.get(i + 1) >= nums.get(i)) {
            i--;
        }

        if (i >= 0) {
            int j = nums.size() - 1;
            while (j >= 0 && nums.get(j) >= nums.get(i)) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1);
        return nums;
    }

    private void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    private void reverse(List<Integer> nums, int low) {
        int high = nums.size() - 1;
        while (low < high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }
}
