package randomArray;

public class PowerOfThree {
    public static void main(String[] args) {

    }

    public boolean isPowerOfThree(int n) {
        if(n < 1)
            return false;
        while(n > 1) {
            if(n % 3 != 0)
                return false;
            n /= 3;
        }
        return true;
    }
}
