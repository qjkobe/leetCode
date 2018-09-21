package primary.mathproblem;

import java.util.LinkedList;
import java.util.List;

//写一个程序，输出从 1 到 n 数字的字符串表示。
//
//1. 如果 n 是3的倍数，输出“Fizz”；
//
//2. 如果 n 是5的倍数，输出“Buzz”；
//
//3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
public class FizzBuzz {
    public static void main(String[] args) {
        List<String> a = fizzBuzz(15);
        for (String i : a) {
            System.out.println(i);
        }
    }

    public static List<String> fizzBuzz(int n) {
        //暴力法
        List<String> res = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}
