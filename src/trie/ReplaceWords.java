package trie;

import java.util.List;
import java.util.Scanner;

public class ReplaceWords {
    public static void main(String[] args) {

    }

    private static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

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

        public String getPrefix(String word) {
            TrieNode curr = root;
            StringBuilder res = new StringBuilder();
            for(int i = 0; i < word.length(); i++) {
                if(curr.isWord)
                    return res.toString();
                char ch = word.charAt(i);
                if(!curr.children.containsKey(ch))
                    return word;
                res.append(ch);
                curr = curr.children.get(ch);
            }
            return curr.isWord ? res.toString() : word;
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for(String s : dict)
            trie.insert(s);
        String[] arr = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        res.append(trie.getPrefix(arr[0]));
        for(int i = 1; i < arr.length; i++) {
            res.append(" ");
            res.append(trie.getPrefix(arr[i]));
        }
        return res.toString();
    }
}
