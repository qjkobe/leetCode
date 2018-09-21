package middle.backtracking;

import java.util.ArrayList;
import java.util.List;

//生成括号
public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis a = new GenerateParenthesis();
        a.generateParenthesis(3);
        for(String x: a.res) {
            System.out.println(x);
        }
    }

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper("", n, 0, 0);
        return res;
    }

    public void helper(String cur, int n, int left, int right) {
        //只有right小于left，right才能添加。left数量要小于n才能添加
        if (left + right == 2 * n) {
            res.add(cur);
            return;
        }
        if (left < n) {
            helper(cur + '(', n, left + 1, right);
        }
        if (right < left) {
            helper(cur + ')', n, left, right + 1);
        }
    }
}
