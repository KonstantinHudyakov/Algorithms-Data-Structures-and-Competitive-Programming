package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeTwo {
    public static void main(String[] args) {

    }

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        if(root != null) {
            Queue<TreeLinkNode> q = new LinkedList<>();
            q.add(root);
            for(int levelSize = 1; !q.isEmpty();) {
                List<TreeLinkNode> level = new ArrayList<>();
                int currLevelSize = levelSize;
                levelSize = 0;
                for(int i = 0; i < currLevelSize; i++) {
                    TreeLinkNode temp = q.poll();
                    level.add(temp);

                    if(temp.left != null) {
                        q.add(temp.left);
                        levelSize++;
                    }
                    if(temp.right != null) {
                        q.add(temp.right);
                        levelSize++;
                    }
                }
                for(int i = 1; i < level.size(); i++)
                    level.get(i - 1).next = level.get(i);
            }
        }
    }

    /*
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null && root.right == null)
            return;
        if(root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = findNext(root);
        }
        else if(root.left == null)
            root.right.next = findNext(root);
        else if(root.right == null)
            root.left.next = findNext(root);

        connect(root.left);
        connect(root.right);
    }

    public TreeLinkNode findNext(TreeLinkNode root) {
        boolean flag = false;
        TreeLinkNode temp = root;
        while(!flag && temp.next != null) {
            temp = temp.next;
            if(temp.left != null) {
                temp = temp.left;
                flag = true;
            }
            else if(temp.right != null) {
                temp = temp.right;
                flag = true;
            }
        }
        if(!flag)
            temp = null;
        return temp;
    }
    */
}
