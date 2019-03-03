package other.miptQuals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {

    // Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {
        int count = 0;
        int curPage = 1;
        for(int i = 0; i < n; i++) {
            int task = 1;
            while(task <= arr[i]) {
                for(int j = 0; task <= arr[i] && j < k; j++) {
                    if(task == curPage)
                        count++;
                    task++;
                }
                curPage++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);
        System.out.println(result);

        scanner.close();
    }
}
