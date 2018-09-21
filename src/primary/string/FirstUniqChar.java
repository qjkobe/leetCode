package primary.string;

import java.util.HashMap;
import java.util.Map;

//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
public class FirstUniqChar {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        //n*n复杂度明显不可取。使用hashmap。遍历一遍找不重复且下标最小
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        int res = -1;
        int min = s.length();
        for (Character key : map.keySet()) {
            if(map.get(key)!=-1){
                if(map.get(key)<min){
                    min = map.get(key);
                    res = min;
                }
            }
        }
        return res;
    }
}
