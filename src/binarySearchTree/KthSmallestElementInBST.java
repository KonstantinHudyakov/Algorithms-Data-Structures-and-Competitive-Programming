package binarySearchTree;

import java.util.Stack;

public class KthSmallestElementInBST {
    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return -1;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        int count = 0;
        while(curr != null || !st.isEmpty()) {
            while(curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            TreeNode temp = st.pop();
            count++;
            if(count == k)
                return temp.val;
            curr = temp.right;
        }
        return -1;
    }
}
