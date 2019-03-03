package binarySearch;

public class Pow {
    public static void main(String[] args) {
        Pow obj = new Pow();
        System.out.println(obj.myPow(2.0, -2));
    }

    public double myPow(double x, int n) {
        if(x == 0.0)
            return 0.0;
        if(x == -1.0) {
            if (n % 2 == 0)
                return 1.0;
            else
                return -1.0;
        }
        if(x == 1.0 || n == 0)
            return 1.0;
        if(n < 0)
            return 1 / powHelper(x, (-1) * n);
        else
            return powHelper(x, n);
    }

//    public double powRecursive(double x, int n) {
//        if(n == 0)
//            return 1.0;
//        if(n == 1)
//            return x;
//        return myPow(x, n - n / 2) * myPow(x,  n / 2);
//    }

    public double powHelper(double x, int n) {
        if(n == 1)
            return x;
        int curr = 1;
        double res = x;
        while(2 * curr <= n) {
            res = res * res;
            if(2 * curr == Integer.MIN_VALUE) {
                curr = Integer.MAX_VALUE;
                break;
            }
            curr = 2 * curr;
        }
        if(curr == n)
            return res;
        return res * powHelper(x, n - curr);
    }
}
