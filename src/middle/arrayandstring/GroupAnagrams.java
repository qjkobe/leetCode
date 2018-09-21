package middle.arrayandstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        //可以对每个字符串进行排序。然后判断是否相等。
        //Hashmap法，如下：
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        HashMap<Integer, ArrayList> map = new HashMap<>();
        for (String s : strs) {
//            int[] count = new int[26];
//            for (char a : s.toCharArray()) {
//                count[a-'a']++;
//            }
            //放进hashmap的key里
//            StringBuilder sb = new StringBuilder();
//            for(int i = 0;i<26;i++) {
//                sb.append(count[i]);
//                sb.append("#");
//            }
            //因为字符串操作有点费时，改换成另一种唯一结构。素数相乘；
            int key = 1;
            for (char a : s.toCharArray()) {
                key *= prime[a -'a'];
            }
//          String key = sb.toString();

            if(map.containsKey(key)){
                map.get(key).add(s);
            }else{
                map.put(key, new ArrayList());
                map.get(key).add(s);
            }
        }
        return new ArrayList(map.values());
    }
}
