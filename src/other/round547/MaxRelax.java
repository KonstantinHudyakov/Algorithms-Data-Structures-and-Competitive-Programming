package other.round547;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MaxRelax {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       // List<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        String[] mas = reader.readLine().split(" ");
        int max = 0;
        int curMax = 0;
        for(int i = 0; i < n ;i++) {
            int cur = Integer.parseInt(mas[i]);
            if(cur == 1) {
                curMax++;
                max = Math.max(max, curMax);
            }
            else {
                curMax = 0;
            }

        }
        int k = 0;
        while(Integer.parseInt(mas[k]) == 1) {
            curMax++;
            k++;
        }
        max = Math.max(max, curMax);
        System.out.println(max);

    }
}
