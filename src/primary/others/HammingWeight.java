package primary.others;
//编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(hammingWeight(15));
    }

    public static int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int mask = 1;
        int count = 0;
        for(int i = 0;i<32;i++) {
            int a = mask & n;
            if ((mask & n) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }

    public static int hammingWeight2(int n) {
        //n 和 n-1 做与运算，直到0为止
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;

    }
}
