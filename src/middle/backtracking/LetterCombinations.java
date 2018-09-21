package middle.backtracking;

import java.util.ArrayList;
import java.util.List;

//电话号码的字母组合
public class LetterCombinations {
    public static void main(String[] args) {
        LetterCombinations a = new LetterCombinations();
        List<String> res = a.letterCombinations("23");
        for (String x : res) {
            System.out.println(x);
        }
    }

    public List<String> letterCombinations(String digits) {
        String[] number = {"0", "0", "abc", "def", "ghi", "jkl",
                "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i)-48;
            res = combine(res, number[num]);
        }
        return res;
    }

    public List<String> combine(List<String> a, String s) {
        List<String> res = new ArrayList<>();
        //把字符添加进a
        for (String x : a) {
            for (int i = 0; i < s.length(); i++) {
                res.add(x+s.charAt(i));
            }
        }
        return res;
    }
}
