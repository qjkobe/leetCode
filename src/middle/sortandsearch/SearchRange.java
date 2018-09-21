package middle.sortandsearch;
//在排序数组中查找元素的第一个和最后一个位置
public class SearchRange {
    public static void main(String[] args) {
        SearchRange a = new SearchRange();
        int[] nums = new int[]{2,2};
        int[] res = a.searchRange(nums, 2);
        for (int x : res) {
            System.out.println(x);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        //二分查找。一旦找到，就左右延伸
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (lo == hi && nums[lo]!=target) {
                return new int[]{-1, -1};
            }
            if (nums[mid] > target) {
                hi = mid;
            } else if (nums[mid] < target) {
                lo = mid+1;
            } else {
                hi = mid;
                lo = mid;
                break;
            }
        }
        //延伸
        int flag = 0;
        while (true) {
            flag = 0;
            if (lo>0&&nums[lo-1] == target) {
                flag = 1;
                lo--;
            }
            if (hi + 1 < nums.length && nums[hi + 1] == target) {
                flag = 1;
                hi++;
            }
            if (flag == 0) {
                break;
            }

        }
        return new int[]{lo, hi};
    }
}
