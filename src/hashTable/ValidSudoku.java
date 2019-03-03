package hashTable;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        for(int k = 0; k < 3; k++) {
            for(int l = 0; l < 3; l++) {
                Set<Character> set = new HashSet<>();
                for(int i = 3 * k; i < 3 * (k + 1); i++) {
                    for(int j = 3 * l; j < 3 * (l + 1); j++) {
                        if(Character.isDigit(board[i][j]) && !set.add(board[i][j]))
                            return false;
                    }
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for(int j = 0; j < board[0].length; j++) {
                if(Character.isDigit(board[i][j]) && !set.add(board[i][j]))
                    return false;
            }
        }

        for(int j = 0; j < board[0].length; j++) {
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < board.length; i++) {
                if(Character.isDigit(board[i][j]) && !set.add(board[i][j]))
                    return false;
            }
        }
        return true;
    }
}
