package primary.dp;
//假设你正在爬楼梯。需要 n 步你才能到达楼顶。
//
//每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs5(11));
        System.out.println(climbStairs5(15));


        int[][] ret = {{1, 0}, {0, 1}};
        System.out.println(multiply(ret, ret)[1][1]);
    }

    public static int climbStairs(int n) {
        //复杂度太高，因为重复计算了很多重复的结果。
        return climbStairs(0,n);
    }

    public static int climbStairs(int i, int n) {
        //i表示当前走的步，n表示目标步
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }

    public static int climbStairs2(int n) {
        //记忆递归。
        int[] memo = new int[n];
        return climbStairs2(0, n, memo);
    }

    public static int climbStairs2(int i, int n, int[] memo) {
        //i表示当前走的步，n表示目标步
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climbStairs2(i + 1, n, memo) + climbStairs2(i + 2, n, memo);
        return memo[i];
    }

    public static int climbStairs3(int n) {
        //动态规划更加容易理解。dp[n]表示到n为止可能的步数
        //dp[n] = dp[n-1]+dp[n-2]
        if(n==1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int climbStairs4(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public static int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                //奇数时会乘以一个倍数。根据当前乘方分解数
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }


    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    public static int climbStairs5(int n) {
        //斐波那契公式，没什么好说的。记住要n+1.因为斐波那契从0 1开始
        double sqrt5=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        System.out.println(fibn/sqrt5);
        return (int)(fibn/sqrt5);
    }
}
