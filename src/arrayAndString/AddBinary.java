package arrayAndString;

public class AddBinary {
    public static void main(String[] args) {
        AddBinary obj = new AddBinary();
        String res = obj.addBinary("1010", "1011");
        System.out.println(res);
    }

    public String addBinary(String a, String b) {
        int n = Math.max(a.length(), b.length());
        int m = Math.min(a.length(), b.length());
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        String max;
        if(a.length() > b.length())
            max = a;
        else
            max = b;

        StringBuilder str = new StringBuilder();
        int addition = 0;
        for(int i = 0; i < m; i++) {
            int temp = Character.digit(a.charAt(i), 10) + Character.digit(b.charAt(i), 10) + addition;
            str.append(temp % 2);
            addition = temp / 2;
        }
        for(int i = m; i < n; i++) {
            int temp = Character.digit(max.charAt(i), 10) + addition;
            str.append(temp % 2);
            addition = temp / 2;
        }
        if(addition == 1)
            str.append(1);
        str.reverse();
        return str.toString();
    }
}

//11111
//10111