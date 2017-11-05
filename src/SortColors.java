public class SortColors {
    /**
     * Medium (F,M)
     * follow up:
     * 1.第一题 类似sort color, 给一个字符串，给一个api int f(int ), 返回值是1，2，3，根据返回值排序。
     * followup，其他一样，返回值是0到k-1。  找小哥要hint小哥告诉我最优解的时间on空间ok。。。
     * 当时捣鼓了半天我也没想出最优解怎么搞，最后写了个空间on的交了。
     * 2.高频变种sortCategory
     */

    /**
     * Two Pointers O(n);O(1)
     * Move red to the front, blue to the end. Keep white in the middle.
     * One pointer to the end of red, redEnd, starting from 0.
     * Another pointer to the start of blue, blueStart, starting from n-1, go backwards.
     * For i = 0 to blueStart:
     * | If nums[i] is RED:
     * |   Swap nums[i] with nums[redEnd].
     * |   Move redEnd.
     * |   Can move i too because the color swapped to i won't be red or blue.
     * | If nums[i] is BLUE:
     * |   Swap nums[i] with nums[blueStart].
     * |   Move blueStart.
     * |   No need to move i since the color swapped to i can be blue or red.
     * | If nums[i] is WHITE:
     * |   i++, just skip.
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int left = 0; //point to the end of red, starting from 0.
        int right = nums.length - 1; //point to the start of blue, starting from n-1
        for (int i = 0; i <= right; i++) { //template, sort start color and end color
            if (nums[i] == 0) {
                swap(nums, i, left++);//i++ cuz we know what we swap from left pointer is either 0 or 1, i's left side are all 0 and 1
            } else if (nums[i] == 2) {
                swap(nums, i--, right--);//can't i++ cuz we don't know what we swapped from right pointer, so we still need to check later
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * follow up 1: sort k colors
     * naive:counting sort, O(n) time, need O(k) space, but can be stable
     * below:each time sort min&max, then sort middle part's min&max, until we sort all min&max, O(k/2 *n) time, O(1) space
     */
    public void sortKColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }

            for (int i = left; i <= right; i++) { //template, sort start color and end color
                if (nums[i] == min) {
                    swap(nums, i, left++);
                } else if (nums[i] == max) {
                    swap(nums, i--, right--);
                }
            }
        }
    }

    /**
     * http://www.1point3acres.com/bbs/thread-209155-1-1.html
     * follow up 2: sort 3 categories
     * 给定一个API getCategory(int n)， return {L| M| H} 三种category
     * 第一问 --- 给定一个Array， [4,2,5,7,8,9], 对于每一个int，有一个category，sort them by category
     */
    public void sortCategories(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (getCategory(nums[i]) == 0) { //0 should be 'L'
                swap(nums, i, left++);
            } else if (getCategory(nums[i]) == 2) { //2 should be 'H'
                swap(nums, i--, right--);
            }
        }
    }

    private int getCategory(int num) {
        return num;
    }

    /**
     * follow up 3: sort k categories
     * 第二问 ---- 如果这个时候有K个category， 应该怎么办？顺着上一题的思路，我的想法是将（0,1，。。。，k-1） category
     * 分成（0）--> L, (1, k-2) -->M, (k-1) --> H， 然后相同的思想继续call之前的function，然后reduce为 （1，k-2）的range，重复之前的事情.
     */
    public void sortKCategories(int[] nums, int k) {
        int start = 0;
        int end = k - 1;
        while (start <= end) {
            sortCategories(nums, start++, end--);
        }
//        while (k % 2 == 1 && start <= end) {
//            sortCategories(nums, start++, end--);
//        }
    }

    private void sortCategories(int[] nums, int start, int end) {
        int left = 0;
        int right = nums.length - 1;
        while (getCategory(nums[left]) < start) { //skip nums that have been sorted
            left++;
        }
        while (getCategory(nums[right]) > end) {
            end--;
        }

        for (int i = left; i <= right; i++) {
            if (getCategory(nums[i]) == start) {
                swap(nums, i, left++);
            } else if (getCategory(nums[i]) == end) {
                swap(nums, i--, right--);
            }
        }
    }
/*    private void sortCategories(int[] nums, int start, int end) {
        int left = 0;
        int right = nums.length - 1;
        while (nums[left] < start) {
            left++;
        }
        while (nums[right] > end) {
            end--;
        }

        for (int i = left; i <= right; i++) {
            if (nums[i] == start) {
                swap(nums, i, left++);
            } else if (nums[i] == end) {
                swap(nums, i--, right--);
            }
        }
    }*/

    public static void main(String[] args) {
        SortColors test = new SortColors();
//        int[] nums = {3, 5, 2, 1, 5, 3, 4, 2, 5};
        int[] nums = {3, 1, 2, 0, 1, 3, 2, 2, 4, 6, 7, 0, 1, 2};
        test.sortKCategories(nums, 8);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
