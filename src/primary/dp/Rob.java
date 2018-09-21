package primary.dp;
//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
//给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
public class Rob {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1,4,6,2,10};
        int[] numsnums = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(rob(nums));
        System.out.println(rob3(nums));
    }

    public static int rob(int[] nums) {
        //dp问题一定要记住，边界条件先处理掉
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 0) {
            return 0;
        }
        //dp[i]表示到i为止能偷到的最高金额
        //dp[i]=dp[i-2]+nums[i]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1] > nums[0] ? nums[1] : nums[0];
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i-1]);
        }
        return dp[nums.length - 1];
    }

    public static int rob2(int[] nums) {
        int[] memo = new int[nums.length + 1];
        for (int i = 0; i < memo.length; i++) {

            memo[i] = -1;
        }
        return rob(nums, memo, 0, nums.length-1);
    }

    public static int rob(int[] nums, int[] memo, int i, int n) {
        //i表示当前步，n就是nums的长度
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return nums[i];
        }
        if (memo[i] > -1) {
            return memo[i];
        }
        //不断向后走，走到n或者越过n都会停。
        memo[i] = Math.max(nums[i] + rob(nums, memo, i + 2, n), nums[i + 1] + rob(nums, memo, i + 3, n));
        return memo[i];
    }

    public static int rob3(int[] nums) {
        int pr1 = 0;
        int pr2 = 0;
        //这里的循环，要记住，pr1是temp+i，而这个temp绝不包括i-1时候的值。
        //temp取的是，上上个循环得到的pr1 pr2里面的最大值。
        int temp;
        for (int i : nums) {
            temp = pr2;
            pr2 = Math.max(pr1, pr2);
            pr1 = temp + i;
        }

        return Math.max(pr1, pr2);
    }
}
