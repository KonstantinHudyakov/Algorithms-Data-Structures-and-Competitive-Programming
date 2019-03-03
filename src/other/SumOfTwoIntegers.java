package other;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        SumOfTwoIntegers obj = new SumOfTwoIntegers();
        int res = obj.getSum(187, 245);
        System.out.println(res);
    }

    public int getSum(int a, int b) {
        if(a == -b)
            return 0;
        int res = a ^ b;
        for(int i = 1; i < 32; i++) {
            if((a & 1) == 1 && (b & 1) == 1) {
                int copy = res >>> i;
                int k = 0;
                while((copy & 1) == 1) {
                    k++;
                    copy >>>= 1;
                }
                for(int j = i; j < i + k; j++)
                    res &= ~(1 << j);
                res |= 1 << (i + k);
            }
            a >>>= 1;
            b >>>= 1;
        }
        return res;
    }

//    int getSum(int a, int b) {
//        return b==0? a : getSum(a ^ b, (a & b) << 1);
//    }
}
