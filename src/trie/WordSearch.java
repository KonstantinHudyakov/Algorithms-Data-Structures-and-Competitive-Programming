package trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {
    public static void main(String[] args) {
        WordSearch obj = new WordSearch();
        char[][] board = {{'a','b'}, {'c', 'd'}};
        String[] words = {"cdba"};
        List<String> list = obj.findWords(board, words);
        System.out.println(list);
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
    }

    private static class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
//        @Override
//        public boolean equals(Object obj) {
//            if(obj.getClass() != this.getClass())
//                return false;
//            Pair pair = (Pair)obj;
//            if(pair.i == i && pair.j == j)
//                return true;
//            return false;
//        }
    }

    private void findWordsRecursive(char[][] board, TrieNode curr, String toAdd, int i, int j, List<String> list, Set<Pair> visited) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || setContains(visited, new Pair(i, j)))
            return;
        visited.add(new Pair(i, j));
        char ch = board[i][j];
        if(curr.children.containsKey(ch)) {
            curr = curr.children.get(ch);
            findWordsRecursive(board, curr, toAdd + ch, i + 1, j, list, setCopy(visited));
            findWordsRecursive(board, curr, toAdd + ch, i - 1, j, list, setCopy(visited));
            findWordsRecursive(board, curr, toAdd + ch, i, j + 1, list, setCopy(visited));
            findWordsRecursive(board, curr, toAdd + ch, i, j - 1, list, setCopy(visited));
            if(curr.isWord && !list.contains(toAdd + ch))
                list.add(toAdd + ch);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String s : words)
            trie.insert(s);
        List<String> result = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                Set<Pair> visited = new HashSet<>();
                findWordsRecursive(board, trie.root, "", i, j, result, visited);
            }
        }
        return result;
    }

    private boolean setContains(Set<Pair> set, Pair pair) {
        for(Pair x : set)
            if(x.i == pair.i && x.j == pair.j)
                return true;
        return false;
    }

    private Set<Pair> setCopy(Set<Pair> set) {
        Set<Pair> copy = new HashSet<>();
        for(Pair x : set)
            copy.add(new Pair(x.i, x.j));
        return copy;
    }
}
