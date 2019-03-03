package other;

import java.math.BigDecimal;

public class ChocolateFiesta {
    public static void main(String[] args) {

    }

    static int solve(int[] a) {
        BigDecimal sum = new BigDecimal(2);
        if(containsOdd(a))
            sum = sum.pow(a.length - 1);
        else
            sum = sum.pow(a.length);
        sum = sum.subtract(new BigDecimal(1));
        return sum.remainder(new BigDecimal(1000000007)).intValue();
    }

    private static boolean containsOdd(int[] a) {
        for(int x : a) {
            if(x % 2 != 0)
                return true;
        }
        return false;
    }
}
