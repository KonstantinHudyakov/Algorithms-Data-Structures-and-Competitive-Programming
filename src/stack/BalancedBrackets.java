package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for(int i = 0; i < n; i++) {
            String line = reader.readLine();
            System.out.println(isBalanced(line));
        }
        reader.close();
    }

    static String isBalanced(String s) {
        if(s.length() % 2 != 0)
            return "NO";
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch == '(')
                st.push(')');
            else if(ch == '[')
                st.push(']');
            else if(ch == '{')
                st.push('}');
            else if(st.isEmpty())
                return "NO";
            else if(ch == st.peek()) {
                st.pop();
            }
            else
                return "NO";
        }
        if(st.isEmpty())
            return "YES";
        return "NO";
    }
}
