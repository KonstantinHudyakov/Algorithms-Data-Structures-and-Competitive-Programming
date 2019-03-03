package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BePositive {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        String[] line = reader.readLine().split(" ");
        reader.close();
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(line[i]);
        int mid = n / 2 + n % 2;
        if(numOfPositive(arr) >= mid)
            System.out.println(findFirstPositive(arr));
        else
            System.out.println(0);
    }

    public static int numOfPositive(int[] arr) {
        int count = 0;
        for(int x : arr)
            count += x > 0 ? 1 : 0;
        return count;
    }

    public static int findFirstPositive(int[] arr) {
        for(int x : arr)
            if(x > 0) return x;
        return -1;
    }
}
