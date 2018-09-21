package primary.array;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 3, 12};
        moveZeroes2(nums);
        for (int i : nums) {
            System.out.println(i);

        }
    }

    public static void moveZeroes(int[] nums) {
        //一快一慢两个指针
        int lo = 0;
        int hi = lo+1;
        while (hi<nums.length) {
            if (nums[lo] == 0 && nums[hi] != 0) {
                nums[lo] = nums[hi];
                nums[hi] = 0;
                lo++;
                hi++;
            }else if(nums[lo] != 0 && nums[hi] != 0){
                lo = hi+1;
                hi = lo+1;
            }else if(nums[lo] == 0 && nums[hi] == 0){
                hi++;
            }else{
                lo++;
                hi++;
            }

        }
    }

    public static void moveZeroes2(int[] nums){
        //没必要做那么多判断，直接去后面找非0，和前面的0对换
        int lo = 0;
        int noZero = 0;
        int temp;
        while (noZero < nums.length) {
            if (nums[noZero] != 0) {
                temp = nums[lo];
                nums[lo++] = nums[noZero];
                nums[noZero] = temp;
            }
            noZero++;
        }
    }
}
