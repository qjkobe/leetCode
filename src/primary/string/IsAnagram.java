package primary.string;

import java.util.HashMap;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram",
                "nagaram"
        ));
    }
    public static boolean isAnagram(String s, String t) {
//        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
// 样例中字符串太长。不能用这个方法了
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        for(int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }else{
                return false;
            }
        }
        int flag = 0;
        for (Character key : map.keySet()) {
            if(map.get(key)!=0){
                return false;
            }
        }
        return true;

    }
}
