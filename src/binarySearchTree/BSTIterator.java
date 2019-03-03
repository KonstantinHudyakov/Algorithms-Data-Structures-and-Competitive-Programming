package binarySearchTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BSTIterator {
    public static void main(String[] args) {

    }

    private Iterator<Integer> iterator;

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    public BSTIterator(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        iterator = list.iterator();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return iterator.hasNext();
    }

    /** @return the next smallest number */
    public int next() {
        return iterator.next();
    }
}
