package middle.backtracking;

import java.util.ArrayList;
import java.util.List;

//子集
public class SubSets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        SubSets a = new SubSets();
        List<List<Integer>> res = a.subsets(nums);
        for (List<Integer> x : res) {
            for (int xx : x) {
                System.out.print(xx+" ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        //回溯法
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }
    public void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums, int start){
        list.add(new ArrayList<>(templist));
        for(int i = start; i < nums.length; i++) {
            templist.add(nums[i]);
            backtrack(list, templist, nums, i + 1);
            templist.remove(templist.size() - 1);
        }
    }
}
