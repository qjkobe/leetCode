package Review;

import java.util.Arrays;
import java.util.Scanner;

public class teampoint {
    public static boolean search(int[] groups, int row, int[] nums, int target) {
        if (row < 0) return true;
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, row, nums, target)) return true;
                groups[i] -= v;
            }
            if (groups[i] == 0) break;
        }
        return false;
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;
        int target = sum / k;

        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) return false;
        while (row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return search(new int[k], row, nums, target);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
        }
        //从大到小，减去b[i]中的数字。
        while (true) {
            if(canPartitionKSubsets(a, 2)){
                int count = 0;
                for (int x : b) {
                    count += x;
                }
                System.out.println(count);
                break;
            }else{
                int min = Integer.MAX_VALUE;
                int minindex = -1;
                for(int i = 0; i<b.length;i++) {
                    if (b[i] < min) {
                        min = b[i];
                        minindex = i;
                    }
                }
                b[minindex] = 0;
                a[minindex] = 0;
            }
        }
    }
}
