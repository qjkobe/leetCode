package primary.others;

import java.util.Stack;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
public class IsValid {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        //入栈出栈
        Stack<Character> stack = new Stack<>();
        char[] a=s.toCharArray();
        for(int i = 0; i<s.length(); i++) {
            if(stack.empty()){
                stack.push(a[i]);
                continue;
            }
            if (stack.peek()+1 == a[i] || stack.peek()+2 == a[i]) {
                stack.pop();
            } else {
                stack.push(a[i]);
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}
