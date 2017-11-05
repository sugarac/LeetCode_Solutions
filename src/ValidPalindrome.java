public class ValidPalindrome {
    /**
     * Easy (F,U,M)
     * follow up:
     * 1.大小写不同也算错。比如'A'和'a'是不一样的。
     * 2.数字被归为其他字符，忽略其他字符，大小写不敏感。
     * 双指针判断。问了一下时间复杂度。然后问了下test case，常规的“”， general过的和不过的给两个，再给特殊字符大写和数字
     */

    /**
     * Two Pointers O(n);O(1)
     */
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //not recommended, have more indentation than the algorithm above
/*    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }

        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (!Character.isLetterOrDigit(s.charAt(low))) {
                low++;
            } else if (!Character.isLetterOrDigit(s.charAt(high))) {
                high--;
            } else {
                if (Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high))) {
                    return false;
                }
                low++;
                high--;
            }
        }
        return true;
    }*/
}
