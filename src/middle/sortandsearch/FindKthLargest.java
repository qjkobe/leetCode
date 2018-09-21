package middle.sortandsearch;

import java.util.Arrays;

//数组中的第K个最大元素
public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        FindKthLargest a = new FindKthLargest();
        System.out.println(a.findKthLargest2(nums,4));
    }

    public int findKthLargest(int[] nums, int k) {
        //排序。
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest2(int[] nums, int k) {
        //数组下标是nums。内容是元素个数。
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x : nums) {
            if (x < min) {
                min = x;
            }
            if (x > max) {
                max = x;
            }
        }
        int[] fre = new int[max - min + 1];
        for (int x : nums) {
            fre[x - min]++;
        }
        int i = max-min;
        while (true) {
            k -= fre[i--];
            if (k <= 0) {
                break;
            }
        }
        return min+i+1;
    }
}
