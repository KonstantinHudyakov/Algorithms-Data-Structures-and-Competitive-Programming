package trie;

public class WordDictionary {
    public static void main(String[] args) {

    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!curr.children.containsKey(ch))
                curr.children.put(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return findWord(root, word, 0);
    }

    private boolean findWord(TrieNode root, String word, int index) {
        if(index >= word.length())
            return root.isWord;
        char ch = word.charAt(index);
        if(root.children.containsKey(ch))
            return findWord(root.children.get(ch), word, index + 1);
        if(ch == '.') {
            for(TrieNode temp : root.children.values()) {
                if(findWord(temp, word, index + 1))
                    return true;
            }
        }
        return false;
    }
}

//at
//and
//an
//add