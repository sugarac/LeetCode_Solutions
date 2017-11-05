import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    /**
     * Easy (Many)
     * follow up:
     * 1.(L,A,U,B)有很多个不同的parentheses的表达怎么办？
     * 直接dictionary（hashmap）预存啊！
     * 2.(U)如果中间有别的字符怎么办
     * 直接跳过？
     */

    /**
     * Stack O(n);O(n)
     * push the right parentheses ')', ']', or '}' into the stack each time when we encounter left ones.
     * And if a right bracket appears in the string, we need check if the stack is empty
     * and also whether the top element is the same with that right bracket.
     * If not, the string is not a valid one.
     * At last, we also need check if the stack is empty.
     */
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
//        for (char c : s.toCharArray()) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (stack.empty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    /**
     * follow up 1:(L,A,U,B)要是有500个不同的parentheses的表达怎么办？直接dictionary（hashmap）预存啊！
     */
    public boolean isValidB(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
//        HashSet<Character> set = new HashSet<>(map.values());
        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) { //replace set.contains(c)
                stack.push(c);
            } else if (map.containsKey(c)) {
                if (stack.peek() == map.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * stack array O(n);O(n)
     */
    public boolean isValidC(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }

        char[] stack = new char[s.length()];
        int top = -1;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{' || top == -1) {
                top++;
                stack[top] = c;
                continue;
            }
            if (c == ')' && stack[top] == '(') {
                top--;
                continue;
            }
            if (c == ']' && stack[top] == '[') {
                top--;
                continue;
            }
            if (c == '}' && stack[top] == '{') {
                top--;
                continue;
            }
            return false;
        }
        if (top == -1) return true;
        else return false;
    }
}
