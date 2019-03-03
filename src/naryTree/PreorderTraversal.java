package naryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> preorderRecursive(Node root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        for(Node x : root.children)
            result.addAll(preorderRecursive(x));
        return result;
    }

    public List<Integer> preorderIterative(Node root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            Node temp = st.pop();
            result.add(temp.val);
            for(int i = temp.children.size() - 1; i >= 0; i--) {
                if(temp.children.get(i) != null)
                    st.push(temp.children.get(i));
            }
        }
        return result;
    }

}
