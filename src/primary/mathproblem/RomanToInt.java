package primary.mathproblem;

import java.util.HashMap;
import java.util.Map;

//罗马数字转整数
public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        //根据规则转换就行
        //一次判定当前字符和后面字符，如果变大了，说明是特例4或者9
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] a = s.toCharArray();
        int res = 0;
        for(int i =0; i < s.length();i++) {
            if (i+1 < s.length() && map.get(a[i + 1]) > map.get(a[i])) {
                res = res + map.get(a[i + 1]) - map.get(a[i]);
                i++;
            } else {
                res = res + map.get(a[i]);
            }
        }
        return res;
    }
}
