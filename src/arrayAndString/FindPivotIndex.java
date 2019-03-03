package arrayAndString;

public class FindPivotIndex {
    public static void main(String[] args) {

    }

    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        for(int i = 0; i < nums.length; i++)
            rightSum += nums[i];
        for(int i = 0; i < nums.length; i++) {
            if(leftSum == rightSum - nums[i])
                return i;
            leftSum += nums[i];
            rightSum -= nums[i];
        }
        return -1;
    }
}
