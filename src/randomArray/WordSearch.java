package randomArray;

public class WordSearch {
    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(rec(board, i, j, word.toCharArray(), 0))
                    return true;
            }
        }
        return false;
    }

    public boolean rec(char[][] board, int x, int y, char[] word, int i) {
        if(i == word.length)
            return true;
        if(x < 0 || y < 0 || x == board.length || y == board[0].length)
            return false;
        if(board[x][y] != word[i])
            return false;
        char ch = board[x][y];
        board[x][y] = '\0';
        boolean exist = rec(board, x - 1, y, word, i + 1)
                || rec(board, x + 1, y, word, i + 1)
                || rec(board, x, y - 1, word, i + 1)
                || rec(board, x, y + 1, word, i + 1);
        board[x][y] = ch;
        return exist;
    }
}