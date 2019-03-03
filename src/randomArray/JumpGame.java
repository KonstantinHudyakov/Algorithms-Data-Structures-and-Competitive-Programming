package randomArray;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        JumpGame obj = new JumpGame();
        boolean res = obj.canJump(nums);
        System.out.println(res);
    }

    public boolean canJump(int[] nums) {
        boolean flag = true;
        for(int i = 0; flag && i < nums.length - 1; i++) {
            if(nums[i] == 0) {
                flag = false;
                for(int j = i - 1; !flag && j >= 0; j--) {
                    if(nums[j] > i - j)
                        flag = true;
                }
            }
        }
        return flag;
    }
}
