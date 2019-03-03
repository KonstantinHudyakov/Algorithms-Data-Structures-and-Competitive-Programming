package arrayAndString;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n < 1)
            return res;
        generateRecursive(res, "", 0, 0, n);
        return res;
    }

    private void generateRecursive(List<String> res, String s, int opened, int closed, int n) {
        if(opened == n && closed == n) {
            res.add(s);
            return;
        }
        if(opened < n)
            generateRecursive(res, s + '(', opened + 1, closed, n);
        if(opened > closed)
            generateRecursive(res, s + ')', opened, closed + 1, n);
    }
}
