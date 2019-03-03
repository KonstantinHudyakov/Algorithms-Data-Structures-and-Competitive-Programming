package arrayAndString;

public class IncreasingTripletSubSequence {
    public static void main(String[] args) {

    }

    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3)
            return false;
        int lower = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        for(int x : nums) {
            if(x <= lower)
                lower = x;
            else if(x <= middle)
                middle = x;
            else
                return true;
        }
        return false;
    }
}
