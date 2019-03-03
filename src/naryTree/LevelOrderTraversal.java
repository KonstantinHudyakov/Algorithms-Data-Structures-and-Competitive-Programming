package naryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>(size);
            for(; size > 0; size--) {
                Node temp = q.poll();
                level.add(temp.val);
                q.addAll(temp.children);
            }
            result.add(level);
        }
        return result;
    }
}
