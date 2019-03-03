package arrayAndString;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {

    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int temp = 0;
        for(int x : nums) {
            if(x == 1)
                temp++;
            else
                temp = 0;
            if(temp > max)
                max = temp;
        }
        return max;
    }
}
