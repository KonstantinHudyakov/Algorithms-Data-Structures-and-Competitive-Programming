package binaryTree;

public class FriendCircles {
    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] M) {
        int circles = 0;
        for(int i = 0; i < M.length; i++)
            circles += check(M, i);
        return circles;
    }

    private int check(int[][] M, int i) {
        if(M[i][i] == 0)
            return 0;
        M[i][i] = 0;
        for(int j = 0; j < M[i].length; j++) {
            if(M[i][j] == 1 && M[j][j] != 0)
                check(M, j);
        }
        return 1;
    }
}
