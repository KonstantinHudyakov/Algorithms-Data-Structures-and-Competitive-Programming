package randomArray;

public class SortColors {
    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;
        for(int x : nums) {
            if(x == 0)
                zero++;
            else if(x == 1)
                one++;
            else
                two++;
        }

        int k = 0;
        for(; zero > 0; zero--)
            nums[k++] = 0;
        for(; one > 0; one--)
            nums[k++] = 1;
        for(; two > 0; two--)
            nums[k++] = 2;
    }
}
