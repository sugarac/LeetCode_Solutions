package Other;

public class AddDigits {
    /**
     * Math O(1);O(1)
     * Return 1 + (num – 1) % 9.
     * If an integer is like 100a+10b+c, then
     * (100a+10b+c)%9=(a+99a+b+9b+c)%9=(a+b+c)%9.
     */
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
//    public int addDigits(int num) {
//        if (num < 10) {
//            return num;
//        }
//
//        int sum = 0;
//        while (num > 0) {
//            sum += num % 10;
//            num /= 10;
//        }
//        return addDigits(sum);
//    }
}
