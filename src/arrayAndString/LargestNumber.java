package arrayAndString;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {

    }

    public String largestNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++)
            arr[i] = nums[i];
        Arrays.sort(arr, (a, b) -> {
            String sa = String.valueOf(a);
            String sb = String.valueOf(b);
            String s1 = sa + sb;
            String s2 = sb + sa;
            return s2.compareTo(s1);
        });
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            if(i == 0 || arr[i] != 0 || str.toString().charAt(0) != '0')
                str.append(String.valueOf(arr[i]));
        }
        return str.toString();
    }
}

//[4704,6306,9385,7536,3462,4798,5422,5529,8070,6241,9094,7846,663,6221,216,6758,8353,3650,3836,8183,3516,5909,6744,1548,5712,2281,3664,7100,6698,7321,4980,8937,3163,5784,3298,9890,1090,7605,1380,1147,1495,3699,9448,5208,9456,3846,3567,6856,2000,3575,7205,2697,5972,7471,1763,1143,1417,6038,2313,6554,9026,8107,9827,7982,9685,3905,8939,1048,282,7423,6327,2970,4453,5460,3399,9533,914,3932,192,3084,6806,273,4283,2060,5682,2,2362,4812,7032,810,2465,6511,213,2362,3021,2745,3636,6265,1518,8398]


//[5,6,9,12,5,2,7,14,65,23,8,9,14,87,23,8898,231,1,0,87,2,5124,74,889,98,234,7563,13,130,131,132,133,134,13]