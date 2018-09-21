package primary.sortAndSearch;
//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
public class Merge {

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 4, 0, 0, 0};
        int[] nums2 = {1, 3, 5};
        Merge m = new Merge();
        m.merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //先让nums1的都移动到后面去。移动n个距离就可以了。
        int j = nums1.length - m;
        for(int i = m - 1; i >= 0; i--) {
            nums1[i+n] = nums1[i];
        }
        //遍历nums1 2，一个个比对查找。
        int count1 = n;
        int count2 = 0;
        int i = 0;
        while (count1 < nums1.length && count2 < n) {
            if (nums1[count1] > nums2[count2]) {
                nums1[i] = nums2[count2];
                count2++;
                i++;
            } else {
                nums1[i] = nums1[count1];
                count1++;
                i++;
            }
        }
        while (count1 < nums1.length) {
            nums1[i++] = nums1[count1++];
        }
        while (count2 < n) {
            nums1[i++] = nums2[count2++];
        }
    }
}
