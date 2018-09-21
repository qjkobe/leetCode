package primary.others;
//颠倒给定的 32 位无符号整数的二进制位。
public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(reverseBits(Integer.MAX_VALUE));
        System.out.println(Integer.toString(Integer.MAX_VALUE, 2).length());

    }

    public static int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32 ;i ++) {
            res += n & 1;
            n >>= 1;
            if (i < 31) {
                res <<= 1;
            }
        }
        return res;
    }
}
