package primary.string;
//给定一个 32 位有符号整数，将整数中的数字进行反转。
public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483412));
    }

    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x%10;
            x /= 10;
            //判断溢出：
            if ((res * 10) / 100 != res / 10) {
                int a1 = res * 10;
                int a = res * 10 / 100;
                int b = res / 10;
                return 0;
            }
            res = res * 10 + temp;

        }
        return res;

    }
}
