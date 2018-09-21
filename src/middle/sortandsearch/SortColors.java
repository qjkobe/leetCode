package middle.sortandsearch;
//颜色分类
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 0, 1, 1, 2};
        SortColors a = new SortColors();
        a.sortColors(nums);
        for (int x : nums) {
            System.out.println(x);
        }
    }

    public void sortColors(int[] nums) {
        //0全去左边，1全去右边
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        for(int i = 0; i <= right; i++) {
            while (nums[i] == 2 && i<right) {
                count++;
                swap(i, right--, nums);
            }
            while (nums[i] == 0 && i > left) {
                count++;
                swap(left++, i, nums);
            }
        }
        System.out.println("操作次数"+count);
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors2(int[] nums) {
        //0个数，1个数。2个数。
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int x : nums) {
            if (x == 0) {
                count0++;
            }
            if (x == 1) {
                count1++;
            }
            if (x == 2) {
                count2++;
            }
        }
        for(int i = 0; i<count0;i++) {
            nums[i] = 0;
        }
        for(int i = count0; i<count0+count1;i++) {
            nums[i] = 1;
        }
        for(int i = count0+count1; i<nums.length;i++) {
            nums[i] = 2;
        }
    }
}
