package other;

public class NumberOfOneBits {
    public static void main(String[] args) {

    }

    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }
}
