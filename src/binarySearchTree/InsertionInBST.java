package binarySearchTree;

public class InsertionInBST {
    public static void main(String[] args) {

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        insertIntoBSTRecursive(root, val);
        return root;
    }

    public void insertIntoBSTRecursive(TreeNode root, int val) {
        if(val < root.val) {
            if(root.left != null)
                insertIntoBSTRecursive(root.left, val);
            else
                root.left = new TreeNode(val);
        }
        else if(root.right != null)
            insertIntoBSTRecursive(root.right, val);
        else
            root.right = new TreeNode(val);
    }

    public void insertIntoBSTIterative(TreeNode root, int val) {
        boolean flag = false;
        while(!flag) {
            if(val < root.val) {
                if(root.left != null)
                    root = root.left;
                else {
                    root.left = new TreeNode(val);
                    flag = true;
                }
            }
            else if(root.right != null)
                root = root.right;
            else {
                root.right = new TreeNode(val);
                flag = true;
            }
        }
    }
}
