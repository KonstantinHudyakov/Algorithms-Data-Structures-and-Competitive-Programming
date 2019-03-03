package binarySearchTree;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        ValidateBinarySearchTree obj = new ValidateBinarySearchTree();
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(1);
//        root.left.left = new TreeNode(0);
//        root.right = new TreeNode(5);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(6);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        boolean res = obj.isValidBST(root);
        System.out.println(res);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, new long[] {Long.MIN_VALUE});
    }

    public boolean isValidBSTHelper(TreeNode root, long[] lastValue) {
        if(root == null)
            return true;
        boolean left = isValidBSTHelper(root.left, lastValue);
        if(left && root.val > lastValue[0])
            lastValue[0] = root.val;
        else
            return false;
        boolean right = isValidBSTHelper(root.right, lastValue);
        return left && right;
    }

}
