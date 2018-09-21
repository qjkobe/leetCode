package primary.string;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix2(new String[]{"aaac", "aab", "aas"}));
        String test = null;
        String test2 = "";
        System.out.println(test2.isEmpty());
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        //横向搜索。（竖着搜索也差不多）
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                //当找不到时，缩小区间
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        //分治法
        if (strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    public static String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            //相同的话前缀是本身。
            return strs[l];
        }
        int mid = (l + r) / 2;
        String lcpLeft = longestCommonPrefix(strs, l, mid);
        String lcpRight = longestCommonPrefix(strs, mid+1, r);
        return commonPrefix(lcpLeft, lcpRight);
    }

    public static String commonPrefix(String left, String right) {
        // 寻找两个字符串的最长共有前缀
        int min = Math.min(left.length(), right.length());
        for(int i = 0; i<min;i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }
}
