package primary.others;
//给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        //高斯等差数列。
        int n = nums.length;
        //0 1 2 3四个数，但是其实就是1到3，又因为缺失只剩下三个。所以这么赋值,这样就从1开始
        int sum1 = n * (1 + n) / 2;
        for (int a : nums) {
            sum1 -= a;
        }
        return sum1;

    }
}
