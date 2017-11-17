public class ReadNCharactersGivenRead4II_CallMultipleTimes {
    /**
     * Hard (F,G,B)
     * follow up:
     * 1.4变成了4K，一个能够调用一次，一个能够调用多次，还有怎么减少copy次 http://www.1point3acres.com/bbs/thread-292326-1-1.html
     * 原来的方法是用一个for loop来copy，我说可以用memcpy，就可以不用for loop
     * read4k那题，对于减少copy，java的话，我觉得要用native 函数 System.arraycopy 来做。
     */

    /**
     * Solution1: Iterative O(n); O(1)
     * Use 3 global variables, a temp buffer to store the result buffer of read4,
     * a variable to store the size of temp buffer, a variable to store the end position of temp buffer in previous calls.
     * If temp buffer is used up, use read4 again. If temp buffer still has characters, keep them for next time.
     */
    private char[] temp = new char[4];
    private int tempLen = 0;
    private int tempPtr = 0;

    public int read(char[] buf, int n) {
        int res = 0;
        while (res < n) {
            if (tempPtr == 0) {
                tempLen = read4(temp);
            }
            if (tempLen == 0) {
                break;
            }
            while (res < n && tempPtr < tempLen) {
                buf[res++] = temp[tempPtr++];
            }
//优化，用arraycopy减少copy次数，只需一次。而且速度快，因为是直接复制内存。但是报数组越界错误
//            int len = Math.min(tempLen, n - res);
//            System.out.println(len);
//            System.arraycopy(temp, tempPtr, buf, res, len);
//            tempPtr += len;
//            res += len;

            if (tempPtr == tempLen) {
                tempPtr = 0;
            }
//            if (tempLen < 4) {
//                break;
//            }
        }
        return res;
    }

    int read4(char[] buf) {
        return 4;
    }
}
