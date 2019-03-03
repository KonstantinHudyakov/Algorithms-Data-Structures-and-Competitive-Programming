package trie;

import java.util.*;

public class PalindromePairs {
    public static void main(String[] args) {

    }

    private static class TrieNode {
        Map<String, TrieNode> children;
        int index;
        TrieNode() {
            children = new HashMap<>();
            index = -1;
        }
    }

//    private static class Pair {
//        String s;
//        int index;
//        Pair (String s, int index) {
//            this.s = s;
//            this.index = index;
//        }
//    }

    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        for(int i = 0; i < words.length; i++)
            insertToTrie(root, words[i], i);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals("")) {
                for(int j = 0; j < words.length; j++) {
                    if(i != j && isPalindrome(words[j]))
                        list.add(Arrays.asList(i, j));
                }
            }
        }
        list.addAll(findPalindromes(root, words));
        return list;
    }

    private void insertToTrie(TrieNode root, String word, int index) {
        if(word.length() == 0) {
            root.children.put("", new TrieNode());
            root.children.get("").index = index;
        }
        for(int i = 0; i < word.length(); i++) {
            String s = String.valueOf(word.charAt(i));
            if(!root.children.containsKey(s))
                root.children.put(s, new TrieNode());
            root = root.children.get(s);
        }
        root.index = index;
    }

    private List<List<Integer>> findPalindromes(TrieNode root, String words[]) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            TrieNode curr = root;
            StringBuilder leftPart = new StringBuilder();
            if(!words[i].equals("") && curr.children.containsKey(""))
                if (isPalindrome(words[i]))
                    list.add(Arrays.asList(curr.children.get("").index, i));
            for (int j = words[i].length() - 1; j >= 0; j--) {
                String s = String.valueOf(words[i].charAt(j));
                if (!curr.children.containsKey(s))
                    break;
                leftPart.append(s);
                curr = curr.children.get(s);
                if (curr.index != -1 && curr.index != i && isPalindrome(leftPart.toString() + words[i]))
                    list.add(Arrays.asList(curr.index, i));
            }
        }
        return list;
    }

    private boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length() - 1;
        for(;  i < j; i++, j--) {
            if(word.charAt(i) != word.charAt(j))
                return false;
        }
        return true;
    }
}
