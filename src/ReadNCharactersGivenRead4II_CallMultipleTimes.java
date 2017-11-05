public class ReadNCharactersGivenRead4II_CallMultipleTimes {
    /**
     * Hard (F,G,B)
     * follow up:
     * 1.4变成了4K，一个能够调用一次，一个能够调用多次，还有怎么减少copy次 http://www.1point3acres.com/bbs/thread-292326-1-1.html
     * 原来的方法是用一个for loop来copy，我说可以用memcpy，就可以不用for loop
     * read4k那题，对于减少copy，java的话，我觉得要用native 函数 System.arraycopy 来做。
     */
}
