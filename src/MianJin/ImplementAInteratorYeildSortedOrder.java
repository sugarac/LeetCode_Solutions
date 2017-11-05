package MianJin;

public class ImplementAInteratorYeildSortedOrder {
    /**
     * http://www.1point3acres.com/bbs/thread-190778-1-1.html
     * 题目我认为是之前merge matrix的变种，Given k sorted lists of O(n) integers each, implement an iterator that will yield all elements in sorted order。
     * 大体讨论了几种思路。转换为 linkedlist 做正常的merge，但较好的思路是直接用iterator来实现大类的next,hasnext和constructor。
     * 希望大家可以贡献想法看看这种思路怎么继续做下去。面完我所想到的还是新建一个wrapper class, 类似于代替了linklist里面每次指向下一个node。
     * 由于是要sort order，肯定需要维护一个k size 的queue。
     */
}
