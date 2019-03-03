package stack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        if(s.isEmpty())
            return true;
        if(s.length() % 2 != 0)
            return false;
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()) {
            st.push(ch);
        }
        Stack<Character> dop = new Stack<>();
        while(!st.isEmpty()) {
            while(!st.isEmpty() && (st.peek() == ')' || st.peek() == ']' || st.peek() == '}'))
                dop.push(st.pop());
            while(!st.isEmpty() && (st.peek() == '(' || st.peek() == '[' || st.peek() == '{')) {
                if(st.peek() == '(' && !dop.isEmpty() && dop.peek() == ')'
                        || st.peek() == '[' && !dop.isEmpty() && dop.peek() == ']'
                        || st.peek() == '{' && !dop.isEmpty() && dop.peek() == '}') {
                    st.pop();
                    dop.pop();
                }
                else
                    return false;
            }
        }
        return true;
    }
}
// (()()]
//
//
//
//