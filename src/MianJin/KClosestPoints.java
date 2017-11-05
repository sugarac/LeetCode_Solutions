package MianJin;

public class KClosestPoints {
    /**
     * http://www.1point3acres.com/bbs/thread-268942-1-1.html
     * 问了那道k closest points to (0,0)，楼主用了priority queue，问了时间和空间复杂度。
     * 然后小哥继续问能不能把时间复杂度继续降低，思路跟LC215一样。小哥说不用写了，继续下一题。
     * pq的复杂度是nlogk。用quick sort的helper function而不是quick sort，因为这里不需要sort所有的点，所以average可以做到n，worst case是n^2。
     *
     * priorityqueue解 improve：用map或者建一个class，避免重复计算distance
     */

    /**
     * http://www.lintcode.com/en/problem/k-closest-points/
     * Given some points and a point origin in two dimensional space, find k points out of the some points which are nearest to origin.
     Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.
     Example
     Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
     return [[1,1],[2,5],[4,4]]
     */


}
