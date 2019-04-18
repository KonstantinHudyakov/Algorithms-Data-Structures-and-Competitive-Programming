package arrayAndString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ArrayToDiapason {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        if(n <= 0)
            return;
        int[] arr = new int[n];
        String[] line = reader.readLine().split(" ");
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(line[i]);

        StringBuilder builder = new StringBuilder();
        int i = 1;
        int startIndex = 0;
        int endIndex = 0;
        while(i <= arr.length) {
            while(i < arr.length && arr[i] == arr[i - 1] + 1) {
                i++;
            }
            endIndex = i - 1;
            if(startIndex != endIndex)
                builder.append(arr[startIndex])
                        .append('-')
                        .append(arr[endIndex])
                        .append(',');
            else
                builder.append(arr[startIndex])
                        .append(',');
            startIndex = i;
            i++;
        }

        builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder.toString());
    }
}