package middle.sortandsearch;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        TopKFrequent a = new TopKFrequent();
        int[] nums = {1};
        List<Integer> res = a.topKFrequent(nums, 1);
        for (int x : res) {
            System.out.println(x);
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        //HashMap,然后用一个list，频率存数组。
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] list = new List[nums.length+1];
        for (int x : map.keySet()) {
            int fre = map.get(x);
            if (list[fre] == null) {
                list[fre] = new ArrayList<>();
            }
            list[fre].add(x);

        }
        List<Integer> res = new LinkedList<>();
        int count = 0;
        for (int i = list.length - 1; k>0; i--) {
            if(list[i]!=null) {
                k -= list[i].size();
                res.addAll(list[i]);
            }
        }
        return res;
    }
}
