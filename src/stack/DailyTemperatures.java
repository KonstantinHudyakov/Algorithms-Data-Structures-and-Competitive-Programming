package stack;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures obj = new DailyTemperatures();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = obj.dailyTemperatures(T);
        for(int x : res)
            System.out.print(x + " ");
    }

    public static class TElem {
        int val;
        int index;
        TElem(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int[] dailyTemperatures(int[] T) {
        Stack<TElem> st = new Stack<>();
        int[] res = new int[T.length];
        st.push(new TElem(T[0], 0));
        for(int i = 1; i < T.length; i++) {
            while(!st.isEmpty() && T[i] > st.peek().val) {
                TElem elem = st.pop();
                res[elem.index] = i - elem.index;
            }
            st.push(new TElem(T[i], i));
        }
        return res;
    }
}