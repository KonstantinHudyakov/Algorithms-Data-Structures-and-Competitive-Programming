package hashTable;

public class MyHashSet {
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.contains(1);    // returns true
        hashSet.contains(3);    // returns false (not found)
        hashSet.add(2);
        hashSet.contains(2);    // returns true
        hashSet.remove(2);
        hashSet.contains(2);    // returns false (already removed)
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode insertToTree(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        if(val < root.val)
            root.left = insertToTree(root.left, val);
        else if(val > root.val)
            root.right = insertToTree(root.right, val);
        return root;
    }

    private boolean searchInTree(TreeNode root, int val) {
        if(root == null)
            return false;
        if(val < root.val)
            return searchInTree(root.left, val);
        else if(val > root.val)
            return searchInTree(root.right, val);
        return true;
    }

    private TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    private TreeNode[] buckets;

    public MyHashSet() {
        buckets = new TreeNode[10000];
    }

    private int hashFunction(int x) {
        return x % 10000;
    }

    public void add(int key) {
        buckets[hashFunction(key)] = insertToTree(buckets[hashFunction(key)], key);
    }

    public void remove(int key) {
        if(contains(key))
            buckets[hashFunction(key)] = deleteNode(buckets[hashFunction(key)], key);
    }

    public boolean contains(int key) {
        return searchInTree(buckets[hashFunction(key)], key);
    }
}
