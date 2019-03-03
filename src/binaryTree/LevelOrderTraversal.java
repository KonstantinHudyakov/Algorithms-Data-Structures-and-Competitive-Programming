package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        LevelOrderTraversal obj = new LevelOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(3);

        List<List<Integer>> res = obj.levelOrder(root);
        for(List<Integer> list : res) {
            for (int x : list)
                System.out.print(x + " ");
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root)  {
        List<List<Integer>> result = new ArrayList<>();
        if(root != null) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            for(int levelSize = 1; !q.isEmpty();) {
                List<Integer> level = new ArrayList<>();
                int currLevelSize = levelSize;
                levelSize = 0;
                for(int i = 0; i < currLevelSize; i++) {
                    TreeNode temp = q.poll();
                    level.add(temp.val);

                    if(temp.left != null) {
                        q.add(temp.left);
                        levelSize++;
                    }
                    if(temp.right != null) {
                        q.add(temp.right);
                        levelSize++;
                    }
                }
                result.add(level);
            }
        }
        return result;
    }
}
