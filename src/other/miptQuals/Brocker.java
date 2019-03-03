package other.miptQuals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Brocker {

    public static boolean find(boolean[][] matrix, boolean[] visited, int[] whoBuy, int client) {
        int houses = visited.length;
        for(int i = 0; i < houses; i++) {
            if(matrix[client][i] && !visited[i]) {
                visited[i] = true;
                if(whoBuy[i] < 0 || find(matrix, visited, whoBuy, whoBuy[i])) {
                    whoBuy[i] = client;
                    return true;
                }
            }
        }
        return false;
    }

    public static int realEstateBroker(int[][] clients, int[][] houses) {
        boolean[][] matrix = new boolean[clients.length][houses.length];
        int n = clients.length;
        int m = houses.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(clients[i][0] <= houses[j][0] &&
                        clients[i][1] >= houses[j][1])
                    matrix[i][j] = true;
            }
        }

        int res = 0;
        int[] whoBuy = new int[m];
        Arrays.fill(whoBuy, -1);
        for(int i = 0; i < n; i++) {
            boolean[] visited = new boolean[m];
            if(find(matrix, visited, whoBuy, i))
                res++;
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[][] clients = new int[n][2];

        for (int clientsRowItr = 0; clientsRowItr < n; clientsRowItr++) {
            String[] clientsRowItems = scanner.nextLine().split(" ");

            for (int clientsColumnItr = 0; clientsColumnItr < 2; clientsColumnItr++) {
                int clientsItem = Integer.parseInt(clientsRowItems[clientsColumnItr].trim());
                clients[clientsRowItr][clientsColumnItr] = clientsItem;
            }
        }

        int[][] houses = new int[m][2];

        for (int housesRowItr = 0; housesRowItr < m; housesRowItr++) {
            String[] housesRowItems = scanner.nextLine().split(" ");

            for (int housesColumnItr = 0; housesColumnItr < 2; housesColumnItr++) {
                int housesItem = Integer.parseInt(housesRowItems[housesColumnItr].trim());
                houses[housesRowItr][housesColumnItr] = housesItem;
            }
        }

        int result = realEstateBroker(clients, houses);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
