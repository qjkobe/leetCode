package primary.mathproblem;

//给定一个整数，写一个函数来判断它是否是 3 的幂次方。
public class IsPowerOfThree {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree4(19682));
        System.out.println(1.00000002 % 1);
    }

    public static boolean isPowerOfThree(int n) {
        if(n==0) return false;
        if (n == 1) {
            return true;
        }
        if (n % 3 != 0) {
            return false;
        } else return isPowerOfThree(n / 3);
    }
    public static boolean isPowerOfThree2(int n) {
        if(n == 0){
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (n != 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
    public static boolean isPowerOfThree3(int n) {
        //转换为三进制。
        String baseChange = Integer.toString(n, 3);
        return baseChange.matches("10*$");
    }

    public static boolean isPowerOfThree4(int n) {
        return (Math.log(n) / Math.log(3) + 0.0000000001) % 1 < 2 * 0.0000000001;
    }

    public static boolean isPowerOfThree5(int n) {
        //Integer最大值
        return n > 0 && 1162261467 % n == 0;
    }
}
