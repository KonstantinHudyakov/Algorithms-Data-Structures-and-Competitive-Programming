package queue;

import java.util.Stack;

public class ImplementQueueUsingStack {
    public static void main(String[] args) {

    }

    public static class MyQueue {
        private Stack<Integer> st;

        /** Initialize your data structure here. */
        public MyQueue() {
            st = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            Stack<Integer> dop = new Stack<>();
            while(!st.isEmpty())
                dop.push(st.pop());
            st.push(x);
            while(!dop.isEmpty())
                st.push(dop.pop());
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return st.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return st.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return st.isEmpty();
        }
    }
}
