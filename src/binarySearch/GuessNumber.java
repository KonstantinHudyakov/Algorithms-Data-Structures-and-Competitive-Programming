package binarySearch;

public abstract class GuessNumber {
    public static void main(String[] args) {

    }

    abstract int guess(int num);

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(guess(mid) == 0)
                return mid;
            else if(guess(mid) == 1)
                left = mid + 1;
            else
                right = mid;
        }
        return -1;
    }
}
