package arrayAndString;

public class CountAndSay {
    public static void main(String[] args) {

    }

    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++) {
            StringBuilder str = new StringBuilder();
            char val = s.charAt(0);
            int count = 0;
            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == val)
                    count++;
                else {
                    str.append(count);
                    str.append(val);
                    val = s.charAt(j);
                    count = 1;
                }
            }
            str.append(count);
            str.append(val);
            s = str.toString();
        }
        return s;
    }
}

//1 - 1
//2 - 11
//3 - 21
//4 - 1211
//5 - 111221
//6 - 312211
//7 - 13112221
//8 - 1113213211
//9 - 31131211131221
//10- 13211311133113112211