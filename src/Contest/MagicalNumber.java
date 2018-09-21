package Contest;
//如果正整数可以被 A 或 B 整除，那么它是神奇的。
//
//返回第 N 个神奇数字。由于答案可能非常大，返回它模 10^9 + 7 的结果。
public class MagicalNumber {
    public static void main(String[] args) {
        System.out.println(nthMagicalNumber(1000000,40000,40000));
    }
    public static int nthMagicalNumber(int N, int A, int B) {
        int count = 0;
        int basemodA = 0;
        int basemodB = 0;
        int timeA = (int)1E9+7 % A;
        for(int i = 1;i<=1E9+7;i++) {
            if((i+basemodA)%A==0||(i+basemodB)%B==0){
                count ++;
            }
            if (N == count) {
                return i;
            }
            if(i>=1E9+7){
                basemodA = (basemodA+(int)1E9+7) % A;
                basemodB = (basemodB+(int)1E9+7)+7 % B;
                i = 0;

                if((i+basemodA)%A==0||(i+basemodB)%B==0){
                    count ++;
                }
                if (N == count) {
                    return i;
                }
            }
        }
        return 0;
    }
}
