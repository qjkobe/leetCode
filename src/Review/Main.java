package Review;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] a = s.toCharArray();
        int[] nums = new int[s.length()];
        int index = 0;
        for (char x : a) {
            nums[index++] = x - '0';
        }
        int left = nums[0] + nums[1] + nums[2];
        int right = nums[3] + nums[4] + nums[5];
        if (left == right) {
            System.out.println(0);
            return;
        }
        int cha = left - right > 0 ? left - right : right - left;
        //每一位去找，如果都小于差，那就，减去然后再找。
        int max = Integer.MIN_VALUE;
        int maxindex = -1;
        int flag = 1;
        int caozuo = 1;
        while(true) {
            for (int i = 0; i < nums.length; i++) {

                if (nums[i] >= cha || 9 - nums[i] >= cha) {
                    System.out.println(caozuo);
                    return;
                }
                if (nums[i] > max) {
                    maxindex = i;
                    max = nums[i];
                    flag = 1;
                }
                if (9 - nums[i] > max) {
                    max = 9 - nums[i];
                    maxindex = i;
                    flag = -1;
                }
            }
            //都没有的话，就用最大的去减
            cha -= max;
            nums[maxindex] = flag == 1 ? 0 : 9;
            caozuo++;
        }
    }
}
