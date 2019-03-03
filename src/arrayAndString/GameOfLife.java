package arrayAndString;

public class GameOfLife {
    public static void main(String[] args) {

    }

    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0)
            return;
        helper(board, 0, 0);
    }

    private void helper(int[][] board, int i, int j) {
        int live = findLiveNeighbors(board, i, j);
        if(j + 1 < board[0].length)
            helper(board, i, j + 1);
        else if(i + 1 < board.length)
            helper(board, i + 1, 0);

        if(board[i][j] == 0 && live == 3)
            board[i][j] = 1;
        else if(board[i][j] == 1 && (live < 2 || live > 3))
            board[i][j] = 0;
    }

    private int findLiveNeighbors(int[][] board, int i, int j) {
        int live = board[i][j] == 1 ? -1 : 0;
        for(int k = Math.min(0, i - 1); k <= Math.min(i + 1, board.length - 1); k++) {
            for(int l = Math.min(0, j - 1); l <= Math.min(j + 1, board[0].length - 1); l++) {
                live += board[k][l];
            }
        }
        return live;
    }
}
