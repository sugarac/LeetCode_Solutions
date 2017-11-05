package MianJin;

public class DotProductOfSparseVector {
    /**
     * http://yuanhsh.iteye.com/blog/2186422
     * What is a memory-efficient way to store a vector of integers?
     * Follow-up question: using your proposed data structure, find an algorithm with constant memory usage
     * to calculate the dot product of two vectors.
     * 有两个很大的稀疏向量，问怎么存储和算他们的dot product. 只存储非零元素和他的index，
     * 如果压缩后的向量大小为m,n, O(m+n)和O(mlogn)方法都不难想到。他问有没有更好，
     * 提示divide and conquer，我就说先取一个向量的中间元素，然后搜索他在另一个向量中对应元素的位置，
     * 这样就把两个矩阵都分别分为两半。他问复杂度，我说我要算一下才知道，然后他说他也不知道，不过平均情况应该比前面的好。
     */

    /**
     * 一开始说连个hashmap，小哥说hashmap会浪费掉多余空间，我说那如果一个特别大的话就扫小一点的那个array，然后在特别大的array中用binary search，
     * 他说写代码。写完代码接着说，那如果差不多大，我说那就两个指针按照merge sort那么扫。然后我觉得基本都行了，他最后说那有没有O(Math.min(m, n))的方法。
     * 我鼓捣半天，最后说了个那就输入直接是一个tuple，第一个elem是位置（这个位置在两个array中必须都不是0），然后扫一遍就行了。其实我感觉他的意思是再用HashMap。
     * 不过他忘了之前和我说太浪费空间了。。。
     */

    /**
     * 算松散向量的点乘，原题有一道算松散矩阵，完全的不同。最后要求是写一个O(n+m)的和一个O(n * log m)的算法，从自己定数据结构开始，面试官看代码真的超仔细....
     * for(int idx1=0, idx2=0; idx1<size1 && idx2<size2;) { if(xxx) idx1++ else idx2++ }，类似这样的代码，还要求优化成
     * for(int idx1=1, idx=0; ; ) { if(xxx) { idx1++; if(idx1 > size1) break; } else { idx2++; if( idx2 > size2) break; }
     */

}
