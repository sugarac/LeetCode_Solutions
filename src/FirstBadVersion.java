public class FirstBadVersion {
    /**
     * Easy, (F)
     * follow up:
     * 1.是多加了一个 转化时间到产品代号的api, 具体我也说不清楚，反正核心算法就是binary search。
     * bad version 那道题他变种的面目全非了，直接导致我做这道题用了20分钟。。。。
     * http://www.1point3acres.com/bbs/thread-224011-1-1.html
     * 2.如果有k台机器，如何parallel
     * 这个题没让写代码，就说了一下思路，我回答的大概就是把区间分成k+1份，然后这样就要K个分割点让K台机器并行的调用isBad()函数，然后遍历得到的结果，
     * 会有一个点i和其相邻点(i+1)的结果不一样，这样就把区间范围缩小到(i, i+1)，重复之前的过程知道找到为止。小哥说ok也没再继续问
     */

    /**
     * Binary Search O(logn), O(1)
     * The Binary Search template is not recommended here since the requirement is to minimize the number of calls of to the API.
     */
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (isBadVersion(start)) {
            return start;
        }
        return -1;
    }

    /**
     * O(logn), O(1)
     */
    public int firstBadVersionB(int n) {
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (isBadVersion(start)) {
            return start;
        }
        if (isBadVersion(end)) {
            return end;
        }
        return -1;
    }

    public boolean isBadVersion(int i) {
        return false;
    }
}
