package primary.array;
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
public class RetoteArray {
    public static void main(String[] args) {

    }

    public static void rotate(int[] nums, int k) {
        reverse(nums, 0, k);
        reverse(nums, k, nums.length-1);
        reverse(nums,0, nums.length-1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
