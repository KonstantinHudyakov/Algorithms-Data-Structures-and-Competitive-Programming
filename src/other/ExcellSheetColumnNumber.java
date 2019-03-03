package other;

public class ExcellSheetColumnNumber {
    public static void main(String[] args) {

    }

    public int titleToNumber(String s) {
        int num = 0;
        int n = s.length();
        for(int i = 0; i < n; i++)
            num += (s.charAt(i) - 'A' + 1) * Math.pow(26, n - i - 1);
        return num;
    }
}
