package other;

public class ConstructTheArray {
    public static void main(String[] args) {

    }

    static long countArray(int n, int k, int x) {
        long sum = 1;
        int mod = 1000000007;
        for (int i = 2; i <= k; i++) {
            for (int j = 0; j < n - 4; j++)
                sum = (sum * (k - 1)) % mod;
            sum = (sum * (k - 2)) % mod;
        }
        return sum;
    }
}

/*
n = 6, k = 4, x = 3
1 2    1 3    - 7     12 13 14 32 34 42 43
1 2    2 3    - 4     13 14 34 43
1 2    4 3    - 7     12 13 31 32 41 42 43

*/
