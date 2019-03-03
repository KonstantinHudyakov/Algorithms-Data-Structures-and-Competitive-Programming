package randomArray;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {2, 1};
        FirstMissingPositive obj = new FirstMissingPositive();
        int res = obj.firstMissingPositive(nums);
        System.out.println(res);
    }

    public int firstMissingPositive(int[] nums) {
        int miss = 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == miss) {
                miss = recursion(nums, i, miss);
            }
        }
        return miss;
    }

    public int recursion(int[] nums, int i, int miss) {
        boolean flag = false;
        int j = 0;
        while(!flag && j < i) {
            if(nums[j] == miss + 1)
                flag = true;
            j++;
        }
        if(flag)
            miss = recursion(nums, i, miss + 1) - 1;
        return miss + 1;
    }
}
