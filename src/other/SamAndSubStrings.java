package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class SamAndSubStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        reader.close();
        int res = substrings(line);
        System.out.println(res);
    }

    static int substrings(String n) {
        long sum = 0;
        int mod = 1000000007;
        long ones = 1;
        char[] nums = n.toCharArray();
        for(int i = n.length() - 1; i >= 0; i--) {
            sum = (sum + Character.digit(nums[i], 10) * (i + 1) * ones) % mod;
            ones = (ones * 10 + 1) % mod;
        }
        return (int)sum;
    }
}

//123456

//1     2     3    4    5   6
//12    23    34   45   56
//123   234   345  456
//1234  2345  3456
//12345 23456
//123456
