package arrayAndString;

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger obj = new ReverseInteger();
        int res = obj.reverse(-1643847412);
        System.out.println(res);
    }

    public int reverse(int x) {
        StringBuilder num = new StringBuilder();
        if (x < 0) {
            num.append('-');
            x = -x;
        }
        while (x > 0) {
            num.append(x % 10);
            x /= 10;
        }
        int res;
        try {
            res = Integer.parseInt(num.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        return res;
    }
}
