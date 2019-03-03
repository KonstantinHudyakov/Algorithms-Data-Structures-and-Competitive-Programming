package trie;

public class MaximumXOR {
    public static void main(String[] args) {

    }

    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int a = nums[i] ^ nums[j];
                if(a > max)
                    max = a;
            }
        }
        return max;
    }
}
