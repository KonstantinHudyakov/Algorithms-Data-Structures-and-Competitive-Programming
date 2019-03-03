package trie;

import binarySearchTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    public static void main(String[] args) {

    }

    private static class TrieNode {
        int val;
        Map<Character, TrieNode> children;
        TrieNode() {
            children = new HashMap<>();
            val = 0;
        }
    }

    private TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode curr = root;
        for(int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if(!curr.children.containsKey(ch))
                curr.children.put(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
        curr.val = val;
    }

    private TrieNode getPrefixNode(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(!curr.children.containsKey(ch))
                return null;
            curr = curr.children.get(ch);
        }
        return curr;
    }

    private int getSunOfValues(TrieNode root) {
        if(root == null)
            return 0;
        int sum = root.val;
        for(TrieNode temp : root.children.values())
            sum += getSunOfValues(temp);
        return sum;
    }

    public int sum(String prefix) {
        return getSunOfValues(getPrefixNode(prefix));
    }
}
