package middle.backtracking;

import java.util.ArrayList;
import java.util.List;

//全排列
public class Permute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute a = new Permute();
        List<List<Integer>> res = a.permute2(nums);
        for (List<Integer> x : res) {
            for (int xx : x) {
                System.out.print(xx+" ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            //从第一个数字开始，往后添加，到底以后删除回溯。
            for(int i = 0; i < nums.length; i++) {
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size()-1);
            }
        }
    }
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute2(int[] nums) {
        permute2(nums, 0);
        return res;
    }

    public void permute2(int[] nums, int index) {
        if (index == nums.length - 1) {
            List<Integer> temp = new ArrayList<>();
            for (int x : nums) {
                temp.add(x);
            }
            res.add(temp);
        } else {
            for (int i = index; i < nums.length; i++) {
                swap(i, index, nums);
                permute2(nums, index + 1);
                swap(i, index, nums);
            }
        }
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
