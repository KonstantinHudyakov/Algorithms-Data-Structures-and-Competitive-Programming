package binarySearchTree;

public class KthLargest {
    public static void main(String[] args) {

    }

    public static class TreeNode {
        int val;
        int cnt;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            cnt = 1;
        }
    }

    private TreeNode root;
    private int k;
    private int size;

    public KthLargest(int k, int[] nums) {
        for(int x : nums)
            root = addNodeToBST(root, x);
        size = nums.length;
        this.k = k;
    }

    private TreeNode addNodeToBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        if(val < root.val)
            root.left = addNodeToBST(root.left, val);
        else
            root.right = addNodeToBST(root.right, val);
        root.cnt++;
        return root;
    }

    private int findKthLargest(TreeNode root, int k) {
        int val = root.val;
        if(root.left != null && root.cnt - k == root.left.cnt)
            return root.val;

        if(root.right != null) {
            if(k - root.right.cnt == 1)
                return root.val;
            else if(k <= root.right.cnt)
                val = findKthLargest(root.right, k);
            else if(root.left != null)
                val = findKthLargest(root.left, k - root.right.cnt - 1);
        }
        else if(root.left != null)
                val = findKthLargest(root.left,k - 1);
        return val;
    }

    public int add(int val) {
        root = addNodeToBST(root, val);
        size++;
        if(k > size)
            return -1;
        return findKthLargest(root, k);
    }
}
