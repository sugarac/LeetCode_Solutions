public class AddBinary {
    /**
     *
     * follow up:
     * 1.问了我为啥不用string做，用string做的时间复杂度是多少。
     * 我说n+(n-1)+...+1 = O(n^2)
     * 2.用了string相加的方法，被问到这么想加时间复杂度是多少。怎么更好，我说可以用StringBuilder，不过要return的时候要reverse先。
     * 3.为什么不用String而是StringBuilder？我说String需要每次拼接到最前面，复杂度是On。又问有没有比StringBuilder更好的？
     * 想了想说char数组，因为返回时可以不用reverse了。
     * 小哥接着问还有没有其他好处，这块卡住了，要hints，小哥说没事，告诉我因为StringBuilder需要扩容。
     * 4.改成5进制再加的结果
     */

    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return "";
        }

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            res.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
