package middle.sortandsearch;

//寻找峰值
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        FindPeakElement a = new FindPeakElement();
        System.out.println(a.findPeakElement2(nums));
    }

    public int findPeakElement(int[] nums) {
        //写的太麻烦了，其实只要下降，就是峰值，懒得重写了。
        if (nums.length == 1) {
            return 0;
        }
        //上升，只要有一次下降，就是谷值
        int arise = 0;
        if (nums[1] < nums[0]) {
            return 0;
        }
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                arise = 1;
                continue;
            }
            if (arise == 1 && nums[i] < nums[i - 1]) {
                return i - 1;
            }
        }

        //左右两边
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length-1;
        }
        return 0;
    }

    public int findPeakElement2(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[mid + 1]) {
                //下降，峰值在左边
                hi = mid;
            } else {
                //上升，峰值在右边。
                lo = mid+1;
            }
        }
        return lo;
    }
}
