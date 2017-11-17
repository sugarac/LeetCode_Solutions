public class ReadNCharactersGivenRead4 {
    /**
     * Solution1: Iterative O(n); O(1)
     * Use a for loop, each time use a temp buffer to store the result of read4.
     * Copy from temp buffer to the parameter “buf”.
     * Check if it's the end of the file, if yse, return the smaller between current read char numbers and n.
     */
    public int read(char[] buf, int n) {
        for (int i = 0; i < n; i += 4) {
            char[] temp = new char[4];
            int len = read4(temp); //use a temp buffer to store the result of read4

            for (int j = 0; j < len; j++) { // copy from temp buffer to buf
                buf[i + j] = temp[j];
            }

            if (len < 4) { //check if it's the end of the file
                return Math.min(i + len, n); //cannot return i + len, since n may be less than i + len.
            }
        }
        return n;
    }

    int read4(char[] buf) {
        return 4;
    }
}
