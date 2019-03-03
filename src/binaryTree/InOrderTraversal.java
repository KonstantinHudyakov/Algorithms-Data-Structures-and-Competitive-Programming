package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public static void main(String[] args) {
        InOrderTraversal obj = new InOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(3);

        List<Integer> list = obj.inorderIterativeTraversal(root);
        for(int x : list)
            System.out.println(x);
    }

    public List<Integer> inorderRecursiveTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            if (root.left != null)
                list.addAll(inorderRecursiveTraversal(root.left));
            list.add(root.val);
            if (root.right != null)
                list.addAll(inorderRecursiveTraversal(root.right));
        }
        return list;
    }

    public List<Integer> inorderIterativeTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root != null) {
            Stack<TreeNode> st = new Stack();
            TreeNode curr = root;
            while (curr != null || !st.isEmpty()) {
                while(curr != null) {
                    st.push(curr);
                    curr = curr.left;
                }
                TreeNode temp = st.pop();
                result.add(temp.val);
                curr = temp.right;
            }
        }
        return result;
    }
}
