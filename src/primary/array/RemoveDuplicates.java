package primary.array;
//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//
//不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int quick = 1;
        int slow = 0;
        while(quick<nums.length) {
            if (nums[slow] == nums[quick]) {
                quick++;
            }else{
                nums[slow+1] = nums[quick];
                slow++;
            }
        }
        return slow+1;
    }
}
