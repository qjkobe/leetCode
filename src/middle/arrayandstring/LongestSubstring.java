package middle.arrayandstring;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s3));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        // 使用滑动窗口+Hashmap来解决。
        Map<Character, Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        int max = j-i+1;
        while(j<s.length()){
            if(map.containsKey(s.charAt(j))) {
                //直接跳到重复那个元素的后面
                i = Math.max(i,map.get(s.charAt(j))+1);
                //为什么要和原来的i对比，因为hashmap里还有之前的值可能会重复，那些值肯定在i前面。
                //因为每当重复，i就会变动到j+1,j+1之前的那些值如果再重复应该不能被计入内。
            }
            //不管有没有重复，都put进map里，但是比较的时候，只处理在下标i后面的。
            //如果有新的之前出现过的元素进来，map里的value自然会更新。
            map.put(s.charAt(j), j);
            //j继续往右划，max不断增加。
            if(j-i+1>max){
                max=j-i+1;
            }

            j++;
        }
        return max;
    }
}
