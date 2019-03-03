package binaryTree;

import java.util.*;

public class SymmetricTree {
    public static void main(String[] args) {
        SymmetricTree obj = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean res = obj.isSymmetricRecursive(root.left, root.right);
        System.out.println(res);
    }

    public boolean isSymmetricRecursive(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;
        else if(left == null || right == null)
            return false;
        return left.val == right.val && isSymmetricRecursive(left.left, right.right) && isSymmetricRecursive(left.right, right.left);
    }
}
