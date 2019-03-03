package binaryTree;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PreOrderTraversal {
    public static void main(String[] args) {
        PreOrderTraversal obj = new PreOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(3);

        List<Integer> list = obj.preorderIterativeTraversal(root);
        for(int x : list)
            System.out.println(x);
    }

    public List<Integer> preorderRecursiveTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.add(root.val);

            if (root.left != null)
                list.addAll(preorderRecursiveTraversal(root.left));
            if (root.right != null)
                list.addAll(preorderRecursiveTraversal(root.right));
        }
        return list;
    }

    public List<Integer> preorderIterativeTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root != null) {
            Stack<TreeNode> st = new Stack();
            st.push(root);
            while (!st.isEmpty()) {
                TreeNode temp = st.pop();
                result.add(temp.val);
                if (temp.right != null)
                    st.push(temp.right);
                if (temp.left != null)
                    st.push(temp.left);
            }
        }
        return result;
    }
}
