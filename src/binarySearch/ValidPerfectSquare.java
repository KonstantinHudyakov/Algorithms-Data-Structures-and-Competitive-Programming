package binarySearch;

import java.util.ArrayList;
import java.util.List;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        ValidPerfectSquare obj = new ValidPerfectSquare();
        boolean res = obj.isPerfectSquare(1);
        System.out.println(res);
    }

    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = 46340;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(mid * mid == num)
                return true;
            if(mid * mid < num)
                left = mid + 1;
            else
                right = mid;
        }
        if(left * left == num)
            return true;
        else
            return false;
    }
}
