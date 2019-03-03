package arrayAndString;

public class RotateArray {
    public static void main(String[] args) {

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

