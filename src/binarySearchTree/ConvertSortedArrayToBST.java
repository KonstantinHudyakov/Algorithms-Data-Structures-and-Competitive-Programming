package binarySearchTree;

public class ConvertSortedArrayToBST {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTRecursive(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBSTRecursive(int[] nums, int left, int right) {
        if(left > right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTRecursive(nums, left, mid - 1);
        root.right = sortedArrayToBSTRecursive(nums, mid + 1, right);
        return root;
    }
}


// 0 1 2 3 4 5 6 7 8 9