package primary.dp;
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        //dp[i]表示到i为止最大的子数组和。
        //dp[i] = max(dp[i], dp[i-1]+nums[i])
        //不过这也可以称作one pass而不是动态规划。
        //原理是一旦当前是负数，就从下一位开始重新数
        int max = nums[0];
        int dp = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if (dp > 0) {
                dp += nums[i];
            } else {
                dp = nums[i];
            }
            max = Math.max(max, dp);
        }
        return max;
    }
}
