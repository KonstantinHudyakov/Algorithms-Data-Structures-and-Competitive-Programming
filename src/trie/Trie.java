package trie;

import java.util.Map;

public class Trie {
    public static void main(String[] args) {

    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!curr.children.containsKey(ch))
                curr.children.put(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!curr.children.containsKey(ch))
                return false;
            curr = curr.children.get(ch);
        }
        if(curr.isWord)
            return true;
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(!curr.children.containsKey(ch))
                return false;
            curr = curr.children.get(ch);
        }
        return findWord(curr);
    }

    private boolean findWord(TrieNode root) {
        if(root.isWord)
            return true;
        for(TrieNode temp : root.children.values()) {
            if(findWord(temp))
                return true;
        }
        return false;
    }
}
