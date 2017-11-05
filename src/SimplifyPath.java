import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
    /**
     * Medium (F,M,G,Y,A) 这题要问清楚要做什么
     * follow up:
     * 1.加了一条不可以开任何数组 or 栈 or Any extra memory，只能直接在原数组上修改。 http://www.1point3acres.com/bbs/thread-250144-1-1.html
     * 这道题其实还有一种做法，不需要维护栈，也就是不用额外空间，但是要对字符位置进行比较好的记录或者回溯，可能会多扫描一次，但是不会增加时间复杂度的量级。
     * 不过那个方法虽然对于空间上有提高，但是有很多细节的操作，并且没有什么算法思想，属于纯字符串操作，
     * 个人觉得意义不是很大，而且在面试中也很难正确写出来，还是比较推荐上述解法。http://cfanz.cn/?c=article&a=read&id=143873
     */

    /**
     * ArrayList + StringBuilder O(n);O(n)
     * insert和delete操作都要在尾端进行，但是如果要用StringBuilder，则最后连接时要从头开始遍历数据结构，所以不能用Stack.
     * 可以用ArrayList, 甚至LinkedList，但LinkedList效率低些，因为delete操作要遍历整个链表。
     * 当然也可以用Deque，但是没有必要。
     * Use ArrayList to store the temporary result.
     * Split the path with slash.
     * For each string s:
     *   If s equals two points, then if list is not empty, remove last one in list.
     *   Otherwise, if s is not empty or does not equal one point, add s to list.
     * Use StringBuilder to generate the result string.
     */
    public String simplifyPathB(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }

        List<String> list = new ArrayList<>(); //List<String> list = new LinkedList<>();
        for (String s : path.split("/")) { // "/home/" -> "", home
            System.out.println(s);
            if (s.equals("..")) {
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
            } else if (!s.equals("") && !s.equals(".")) {
                list.add(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append("/" + s);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    /**
     * Stack + String O(n^2);O(n^2)
     */
    public String simplifyPath(String path) {
        if (path == null) {
            return "";
        }

        Stack<String> stack = new Stack<>();
        for (String s : path.split("/")) {
            if (s.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else if (!s.equals("") && !s.equals(".")) {
                stack.push(s);
            }
        }

/*        String res = "";
        while (!stack.empty()) {
            res = "/" + stack.pop() + res;
        }
        return res.length() == 0 ? "/" : res;*/
        return "/" + String.join("/", stack);
    }

}
