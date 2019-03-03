package randomArray;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 6};
        int a = searchInsert(nums, 7);
        System.out.println(a);
    }

    public static int searchInsert(int[] nums, int target) {
        int i = 0, index = 0;
        boolean found = false;
        while(!found && i < nums.length) {
            if(nums[i] == target) {
                index = i;
                found = true;
            }
            i++;
        }
        if(!found) {
            int j = 0;
            while(j < nums.length && nums[j] < target)
                j++;
            index = j;
        }
        return index;
    }
}
