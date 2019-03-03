package binarySearch;

public class Sqrt {
    public static void main(String[] args) {
        Sqrt obj = new Sqrt();
        int res = obj.mySqrt(2147483647);
        System.out.println(res);
    }

    public int mySqrt(int x) {
        int left = 0;
        int right = 46341;
        while(left < right) {
            int mid = (left + right) / 2;
            if(x > mid * mid)
                left = mid + 1;
            else
                right = mid;
        }
        if(left * left == x)
            return left;
        else
            return left - 1;
    }
}
