package binaryTree;

public class MaximumBinaryTree {
    public static void main(String[] args) {
        int[] a = new int[] {3,2,1,6,0,5};
        System.out.println(constructMaximumBinaryTree(a));
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        return helper(nums, 0, nums.length - 1);
    }

    public static TreeNode helper(int[] nums, int left, int right) {
        if(left > right)
            return null;
        int maxIndex = ternaryMaximumSearch(nums, left, right);
        TreeNode cur = new TreeNode(nums[maxIndex]);
        cur.left = helper(nums, left, maxIndex - 1);
        cur.right = helper(nums, maxIndex + 1, right);
        return cur;
    }

    public static int ternaryMaximumSearch(int[] a, int left, int right) {
        if(right == left)
            return left;
        if(right - left == 1)
            return a[left] >= a[right] ? left : right;
        while(right - left > 2) {
            int m1 = left + (right - left) / 3;
            int m2 = right - (right - left) / 3;

            if(a[m1] < a[m2])
                left = m1;
            else
                right = m2;
        }

        if(a[left] >= a[left + 1] && a[left] >= a[right])
            return left;
        if(a[left + 1] >= a[left] && a[left + 1] >= a[right])
            return left + 1;
        return right;
    }
}
