package randomArray;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray obj = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        obj.rotate(nums, 3);

//        for(int x : nums)
//            System.out.print(x + " ");
//        System.out.println();
    }

    public void rotate(int[] nums, int k) {
        if(k == 0 || nums.length == k)
            return;
        k = k % nums.length;
        int count = 0;
        for(int i = 0; count < nums.length; i++) {
            int curr = i;
            int prev = nums[i];
            do {
                int next = (curr + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                curr = next;
                count++;
            } while(i != curr);
        }
        return;
    }
}
