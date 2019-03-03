package randomArray;

public class StringToInteger {

    public static void main(String[] args) {
        StringToInteger obj = new StringToInteger();
        int num = obj.myAtoi("-6147483648");
        System.out.println(num);
    }

    public int myAtoi(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ')
            i++;

        if(i >= str.length())
            return 0;

        int multiplier = 1;
        if (str.charAt(i) == '-') {
            multiplier = -1;
            i++;
        } else if(str.charAt(i) == '+')
            i++;

        int j = i;
        while (j < str.length() && str.charAt(j) >= '0' && str.charAt(j) <= '9')
            j++;
        j--;

        int num = 0;
        try {
            for (int k = 0; j >= i; j--, k++) {
                int num1 = Math.addExact(num, Character.getNumericValue(str.charAt(j)) * (int) Math.pow(10, k));
                if(k != 0 && num1 % 10 != num % 10)
                    throw new ArithmeticException();
                num = num1;
                //    num = Character.getNumericValue(str.charAt(j)) * (int) Math.pow(10, k);
            }
        } catch (ArithmeticException e) {
            if (multiplier == 1)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }
        return multiplier * num;
    }
}
