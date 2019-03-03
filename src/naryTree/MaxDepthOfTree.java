package naryTree;

import java.util.List;

public class MaxDepthOfTree {
    public static void main(String[] args) {

    }

    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        if(root.children.size() == 0)
            return 1;
        List<Node> leaves = root.children;
        int max = maxDepth(leaves.get(0));
        for(int i = 1; i < leaves.size(); i++) {
            int temp = maxDepth(leaves.get(i));
            if(temp > max)
                max = temp;
        }
        return max + 1;
    }
}
