package arrayAndString;

public class MergeSortedArray {
    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        rotate(nums1, n);
        for(int i = n, j = 0, k = 0; j < n || i < n + m; k++) {
            if(i < n + m && j < n) {
                if(nums1[i] < nums2[j])
                    nums1[k] = nums1[i++];
                else
                    nums1[k] = nums2[j++];
            }
            else if(i < n + m)
                nums1[k] = nums1[i++];
            else
                nums1[k] = nums2[j++];
        }
    }

    private void rotate(int[] nums, int k) {
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
