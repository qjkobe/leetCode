package middle.arrayandstring;
//给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列

public class IncreasingTriplet {
    public static void main(String[] args) {
        int[] nums = {5,1,5,5,2,5,4};
        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {
        //找最小，次小，和次次小。
        int hi = Integer.MAX_VALUE;
        int shi = Integer.MAX_VALUE;
        for (int a : nums) {
            if (a <= hi) {//等号是为了防止556这样的情况。
                hi = a;//当前发现的最小
            } else if (a <= shi) {
                shi = a;//当前发现的第二小
            }else{
                return true;//成立
            }
        }
        return false;
    }
}
