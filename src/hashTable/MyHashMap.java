package hashTable;

public class MyHashMap {
    public static void main(String[] args) {

    }

    private static class TreeNode {
        int key;
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private TreeNode insertToTree(TreeNode root, int key, int val) {
        if(root == null)
            return new TreeNode(key, val);
        if(key < root.key)
            root.left = insertToTree(root.left, key, val);
        else if(key > root.key)
            root.right = insertToTree(root.right, key, val);
        else
            root.val = val;
        return root;
    }

    private int searchInTree(TreeNode root, int key) {
        if(root == null)
            return -1;
        if(key < root.key)
            return searchInTree(root.left, key);
        else if(key > root.key)
            return searchInTree(root.right, key);
        return root.val;
    }

    private TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.key){
            root.left = deleteNode(root.left, key);
        }else if(key > root.key){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            TreeNode minNode = findMin(root.right);
            root.key = minNode.key;
            root.right = deleteNode(root.right, root.key);
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

    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new TreeNode[10000];
    }

    private int hashFunction(int x) {
        return x % 10000;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int pos = hashFunction(key);
        buckets[pos] = insertToTree(buckets[pos], key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return searchInTree(buckets[hashFunction(key)], key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int pos = hashFunction(key);
        if(get(key) != -1)
            buckets[pos] = deleteNode(buckets[pos], key);
    }
}
