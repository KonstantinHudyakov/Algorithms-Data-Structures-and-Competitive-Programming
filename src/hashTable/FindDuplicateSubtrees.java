package hashTable;

import java.util.*;

public class FindDuplicateSubtrees {
    public static void main(String[] args) {

    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postorder(root, new HashMap<>(), res);
        return res;
    }

    public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "#";
        String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
        if (map.getOrDefault(serial, 0) == 1)
            res.add(cur);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }

//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        List<TreeNode> result = new ArrayList<>();
//        mapping(root, new HashMap<>(), result);
//        return result;
//    }
//
//    private void mapping(TreeNode root, Map<Integer, List<TreeNode>> map, List<TreeNode> result) {
//        if(root == null)
//            return;
//        if(map.containsKey(root.val)) {
//            for(TreeNode temp : map.get(root.val)) {
//                if(isEqualSubTrees(root, temp) && !listContains(result, temp))
//                    result.add(temp);
//            }
//            map.get(root.val).add(root);
//        }
//        else {
//            List<TreeNode> list = new ArrayList<>();
//            list.add(root);
//            map.put(root.val, list);
//        }
//
//        mapping(root.left, map, result);
//        mapping(root.right, map, result);
//    }
//
//    private boolean isEqualSubTrees(TreeNode root1, TreeNode root2) {
//        if(root1 == null && root2 == null)
//            return true;
//        else if(root1 == null || root2 == null || root1.val != root2.val)
//            return false;
//        return isEqualSubTrees(root1.left, root2.left) && isEqualSubTrees(root1.right, root2.right);
//    }
//
//    private boolean listContains(List<TreeNode> list, TreeNode root) {
//        for(TreeNode temp : list) {
//            if(isEqualSubTrees(root, temp))
//                return true;
//        }
//        return false;
//    }
}
