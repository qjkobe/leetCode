package middle.sortandsearch;

//搜索旋转排序数组
public class Search {
    public static void main(String[] args) {
        Search a = new Search();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(a.search(nums,3));
    }

    public int search(int[] nums, int target) {
        //二分法，多判断条件
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int lo = 0;
        int hi = nums.length-1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[lo] == target) {
                return lo;
            }
            if (nums[hi] == target) {
                return hi;
            }
            if (nums[lo] < nums[mid]) {//左边是正常的
                if (target > nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }else {
                //右边正常
                if (target < nums[hi] && target > nums[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
