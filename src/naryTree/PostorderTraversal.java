package naryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> postorderRecursive(Node root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(Node x : root.children)
            result.addAll(postorderRecursive(x));
        result.add(root.val);
        return result;
    }

    public List<Integer> postorderIterative(Node root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Stack<Node> toVisit = new Stack<>();
        Stack<Integer> st = new Stack<>();
        toVisit.push(root);
        while(!toVisit.isEmpty()) {
            Node temp = toVisit.pop();
            st.push(temp.val);
            for(Node x : temp.children)
                toVisit.push(x);
        }
        while(!st.isEmpty())
            result.add(st.pop());
        return result;
    }
}
