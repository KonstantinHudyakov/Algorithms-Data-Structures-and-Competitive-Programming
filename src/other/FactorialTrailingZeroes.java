package other;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {

    }

    public int trailingZeroes(int n) {
        int base = n / 25 * 6;
        long k = 125;
        while(n / k > 0) {
            base += n / k;
            k *= 5;
        }
        return base + n % 25 / 5;
    }
}
//каждые 25  - +2
//каждые 125 -