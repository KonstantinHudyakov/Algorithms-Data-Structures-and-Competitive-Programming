package binaryTree;

public class PathSum {
    public static void main(String[] args) {
        PathSum obj = new PathSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean res = obj.hasPathSum(root, 22, 0);
        System.out.println(res);
    }

    public boolean hasPathSum(TreeNode root, int sum, int currSum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null) {
            if(currSum + root.val == sum)
                return true;
            else
                return false;
        }
        return hasPathSum(root.left, sum, currSum + root.val) || hasPathSum(root.right, sum, currSum + root.val);
    }
}
