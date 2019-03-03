package other;

public class ReverseBits {
    public static void main(String[] args) {
        ReverseBits obj = new ReverseBits();
        int res = obj.reverseBits(Integer.MAX_VALUE);
        System.out.println(res);
    }

    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
}