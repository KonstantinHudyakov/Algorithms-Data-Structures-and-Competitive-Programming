package randomArray;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne obj = new PlusOne();
        int[] digits = {8, 9, 9, 9};
        digits = obj.plusOne(digits);
        for(int a : digits)
            System.out.println(a);
    }

    public int[] plusOne(int[] digits) {
        if(digits[digits.length - 1] != 9)
            digits[digits.length - 1]++;
        else {
            int notNine = -1;
            for(int i = digits.length - 2; i >= 0 && notNine == -1; i--) {
                if (digits[i] != 9)
                    notNine = i;
            }
            if(notNine >= 0) {
                digits[notNine]++;
                for (int i = notNine + 1; i < digits.length; i++)
                    digits[i] = 0;
            }
            else {
                int[] temp = new int[digits.length + 1];
                temp[0] = 1;
                for (int i = 1; i < digits.length + 1; i++)
                    temp[i] = 0;
                digits = temp;
            }
        }
        return digits;
    }
}
