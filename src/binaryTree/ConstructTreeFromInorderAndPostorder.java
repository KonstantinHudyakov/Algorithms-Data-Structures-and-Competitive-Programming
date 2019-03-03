package binaryTree;

public class ConstructTreeFromInorderAndPostorder {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
            return null;
        int val = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(val);

        int rootIndex = -1;
        for(int i = 0; rootIndex == -1 && i < inorder.length; i++) {
            if(inorder[i] == val)
                rootIndex = i;
        }

        root.left = buildTree(arrayCut(inorder, 0, rootIndex - 1),
                arrayCut(postorder, 0, rootIndex - 1));
        root.right = buildTree(arrayCut(inorder, rootIndex + 1, inorder.length - 1),
                arrayCut(postorder, rootIndex, inorder.length - 2));
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