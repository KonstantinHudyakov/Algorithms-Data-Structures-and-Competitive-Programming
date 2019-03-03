package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class FibonacciModified {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        reader.close();
        BigInteger t1 = new BigInteger(line[0]);
        BigInteger t2 = new BigInteger(line[1]);
        int n = Integer.parseInt(line[2]);
        BigInteger result = fibonacciModified(t1, t2, n);
        System.out.println(result.toString());
    }

    static BigInteger fibonacciModified(BigInteger t1, BigInteger t2, int n) {
        if(n == 2)
            return t2;
        return fibonacciModified(t2, t1.add(t2.multiply(t2)), n - 1);
    }
}
