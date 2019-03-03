package binaryTree;

import java.util.*;

public class ZigzagLevelOrderTraversal {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean direction = true;
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(; size > 0; size--) {
                TreeNode temp = q.poll();
                level.add(temp.val);
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            res.add(direction ? level : reverseList(level));
            direction = !direction;
        }
        return res;
    }

    private List<Integer> reverseList(List<Integer> list) {
        for(int i = 0, j = list.size() - 1; i < j; i++, j--) {
            int a = list.get(i);
            list.set(i, list.get(j));
            list.set(j, a);
        }
        return list;
    }
}
//                if(temp.left != null && temp.right != null) {
//                    if(direction) {
//                        q.add(temp.left);
//                        q.add(temp.right);
//                    }
//                    else {
//                        q.add(temp.right);
//                        q.add(temp.left);
//                    }
//                }
//                else if(temp.left != null)
//                    q.add(temp.left);
//                else if(temp.right != null)
//                    q.add(temp.right);