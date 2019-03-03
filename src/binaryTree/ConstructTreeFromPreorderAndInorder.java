package binaryTree;

public class ConstructTreeFromPreorderAndInorder {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null || preorder == null || inorder.length == 0 || preorder.length == 0)
            return null;
        int val = preorder[0];
        TreeNode root = new TreeNode(val);

        int rootIndex = -1;
        for(int i = 0; rootIndex == -1 && i < inorder.length; i++) {
            if(inorder[i] == val)
                rootIndex = i;
        }
        root.left = buildTree(arrayCut(preorder, 1, rootIndex),
                arrayCut(inorder, 0, rootIndex - 1));
        root.right = buildTree(arrayCut(preorder, rootIndex + 1, preorder.length - 1),
                arrayCut(inorder, rootIndex + 1, inorder.length - 1));
        return root;
    }

    public int[] arrayCut(int[] oldArr, int i, int j) {
        if(i > j)
            return null;
        int[] arr = new int[j - i + 1];
        for(int k = i; k <= j; k++)
            arr[k - i] = oldArr[k];
        return arr;
    }
}
