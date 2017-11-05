package Other;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) { //cannot use n > 0
            res += n & 1;
            n >>>= 1; //unsigned right shift
        }
        return res;
    }
}
