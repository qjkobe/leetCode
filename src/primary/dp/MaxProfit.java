package primary.dp;

//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
//如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
//
//注意你不能在买入股票前卖出股票。
public class MaxProfit {

    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        //一遍遍历。判断最小值，和当前值和最小值的差
        int min = Integer.MAX_VALUE;
        int maxpro = 0;
        for(int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > maxpro) {
                //max只会向后找。
                maxpro = prices[i] - min;
            }
        }
        return maxpro;
    }
}
