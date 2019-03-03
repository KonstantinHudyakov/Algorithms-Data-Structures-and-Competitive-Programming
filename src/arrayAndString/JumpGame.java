package arrayAndString;

public class JumpGame {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        if(nums.length == 0)
            return true;
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if(max >= nums.length - 1)
                return true;
            else if(max <= i)
                return false;
        }
        return false;
    }
}
