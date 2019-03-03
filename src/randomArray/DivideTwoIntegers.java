package randomArray;

public class DivideTwoIntegers {
    public static void main(String[] args) {

    }

    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int sum = 0;
        int division = 0;
        while((Math.abs(sum += divisor)) <= Math.abs(dividend))
            division++;

        if(dividend < 0 && divisor < 0 || dividend > 0 && divisor > 0)
            return division;
        else
            return -division;
    }
}
