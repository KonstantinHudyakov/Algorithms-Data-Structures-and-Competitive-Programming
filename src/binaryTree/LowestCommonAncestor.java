package binaryTree;

public class LowestCommonAncestor {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    /*
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLowestCommonAncestor(null, root, p, q);
    }

    public TreeNode findLowestCommonAncestor(TreeNode ancestor, TreeNode curr, TreeNode p, TreeNode q) {
        if(curr == null)
            return null;
        TreeNode left = ancestor;
        TreeNode right = ancestor;
        if(check(curr, p) && check(curr, q)) {
            left = findLowestCommonAncestor(curr, curr.left, p, q);
            right = findLowestCommonAncestor(curr, curr.right, p, q);
        }
        if(left == null)
            return right;
        if(right == null)
            return left;
        return check(left, right) ? right : left;
    }

    public boolean check(TreeNode root, TreeNode x) {
        if(root == null)
            return false;
        if(root.val == x.val)
            return true;
        return check(root.left, x) || check(root.right, x);
    }
    */
}

//preorder:  3 5 6 2 7 4 1 0 8
//inorder:   6 5 7 2 4 3 0 1 8
//postorder: 6 7 4 2 5 0 8 1 3