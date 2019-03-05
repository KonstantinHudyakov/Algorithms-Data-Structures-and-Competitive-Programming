package other;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sales {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Integer> list = new ArrayList<>();
        String[] line1 = reader.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(line1[i]));
        }

        int m = Integer.parseInt(reader.readLine());
        List<Integer> cupon = new ArrayList<>();
        String[] line2 = reader.readLine().split(" ");
        for(int i = 0; i < m; i++) {
            cupon.add(Integer.parseInt(line2[i]));
        }


        list.sort((a, b) -> a - b);
        long sum = 0;
        for(int x : list) {
            sum += x;
        }

        for(int i = 0; i < m; i++)
            System.out.println(sum - list.get(list.size() - cupon.get(i)));
    }
}
