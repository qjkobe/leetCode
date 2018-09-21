package middle.arrayandstring;
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome3("aaaaba"));
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }
        //正常DP
        int max = 1;
        int start = 0;
        int end = 0;
        //dp表示i到j之间的字串是不是回文。
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i =0; i < s.length();i++) {
            dp[i][i] = true;
        }
        for(int i =0; i < s.length() - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if(dp[i][i+1]){
                max = 2;
                start = i;
                end = i+1;
            }
        }
        //上面找到了1字母和2字母的回文。接下来按照顺序填入应有的回文结果。
        for(int j = 2; j < s.length();j++) {
            for(int i = 0; i <s.length()-j;i++){
                dp[i][i + j] = dp[i + 1][i + j - 1] && s.charAt(i) == s.charAt(i + j);
                if(dp[i][i+j]){
                    max = j+1;
                    start = i;
                    end = i + j;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static String longestPalindrome2(String s) {
        if (s.isEmpty()) {
            return "";
        }
        //DP简短版
        int max = 1;
        int start = 0;
        int end = 0;
        //dp表示i到j之间的字串是不是回文。
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < s.length() - i ;j++) {
                if(i == 0||(i==1 && s.charAt(j)==s.charAt(j+1))||
                        (dp[j+1][j+i-1] && s.charAt(j) == s.charAt(j+i))){
                    dp[j][j+i] = true;
                    max = i;
                    start = j;
                    end = j+i;
                }
            }
        }
        return s.substring(start, end+1);
    }
    //思考，这里的max是多余的，正常算出来的结果就已经是最长的回文了。
    // 因为每次算的子字符串都是会越来越长的，所以最后一个成立的就是最长的。

    public static String longestPalindrome3(String s) {
        //中心拓展法.每个字符进行中心拓展。n*n复杂度。
        if (s.isEmpty()) {
            return "";
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;//这里要注意一下start位置，自己举个简单例子就能明白
                end = i + len/2;//这里同理，注意一下即可。
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R-L-1;//这里R和L都多加了一次，所以要-2.然后真实长度+1；
    }

    //最后一种方法以后再做。
}
