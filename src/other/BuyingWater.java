package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuyingWater {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(reader.readLine());
        for(int i = 0; i < q; i++) {
            String[] line = reader.readLine().split(" ");
            long n = Long.parseLong(line[0]);
            int a = Integer.parseInt(line[1]);
            int b = Integer.parseInt(line[2]);
            System.out.println(solution(n, a, b));
        }
        reader.close();
    }

    public static long solution(long n, int a, int b) {
        if(n == 1)
            return a;
        if(2 * a <= b)
            return n * a;
        else
            return (n / 2) * b + a * (n % 2);
    }
}
