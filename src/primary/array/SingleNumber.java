package primary.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SingleNumber {
    public static void main(String[] args) {

    }

    public static int[] singleNumber(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : nums1) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            }else{
                map.put(a, 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int a : nums2) {
            if (map.containsKey(a) && map.get(a)>0) {
                res.add(a);
                map.put(a, map.get(a) - 1);
            }
        }
        int[] result = new int[res.size()];
        int i = 0;
        for (int a : res) {
            result[i++] = a;
        }
        return result;
    }
}
