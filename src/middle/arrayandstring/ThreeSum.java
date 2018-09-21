package middle.arrayandstring;
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(fastThreeSum(nums));
        System.out.println(10>>>1);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            //skip duplicate
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int sum2 = -nums[i];
            //find 2 element added sum2.
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int tempsum = nums[lo] + nums[hi];
                if (tempsum > sum2) hi--;
                if (tempsum < sum2) lo++;
                if (tempsum == sum2) {
                    List<Integer> tempres = new ArrayList<>();
                    tempres.add(nums[i]);
                    tempres.add(nums[lo]);
                    tempres.add(nums[hi]);
                    result.add(tempres);
                    // skip duplicate
                    while (lo + 1 < nums.length && nums[lo] == nums[lo + 1]) lo++;
                    while (hi - 1 > i && nums[hi] == nums[hi - 1]) hi--;
                    lo++;
                    hi--;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> fastThreeSum(int[] nums) {
        //超快速解法
        if (nums.length < 3)
            return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int negSize = 0;
        int posSize = 0;
        int zeroSize = 0;
        //统计正数负数的个数，记录了最大最小值。
        for (int v : nums) {
            if (v < minValue)
                minValue = v;
            if (v > maxValue)
                maxValue = v;
            if (v > 0)
                posSize++;
            else if (v < 0)
                negSize++;
            else
                zeroSize++;
        }
        if (zeroSize >= 3)
            res.add(Arrays.asList(0, 0, 0));
        if (negSize == 0 || posSize == 0)
            return res;
        //其实可以换个变量。因为大于这个最大值的数字，都是不可能成立的。
        if (minValue * 2 + maxValue > 0)
            maxValue = -minValue * 2;
        else if (maxValue * 2 + minValue < 0)
            minValue = -maxValue * 2;

        int[] map = new int[maxValue - minValue + 1];
        int[] negs = new int[negSize];
        int[] poses = new int[posSize];
        negSize = 0;
        posSize = 0;
        for (int v : nums) {
            //在可能成立的范围里挑选。用map记录。不会重复记录，但会记录出现次数。
            if (v >= minValue && v <= maxValue) {
                if (map[v - minValue]++ == 0) {
                    if (v > 0)
                        poses[posSize++] = v;
                    else if (v < 0)
                        negs[negSize++] = v;
                }
            }
        }
        //正数负数各进行排序。
        Arrays.sort(poses, 0, posSize);
        Arrays.sort(negs, 0, negSize);
        int basej = 0;
        //遍历负数，从大到小。
//        for (int i = negSize - 1; i >= 0; i--) {
        for(int i = 0;i<negSize;i++){
            basej = 0;
            int nv = negs[i];
            //除以2.最小的正数也必须比他一半要大。对应后面我们搜寻的方式。
            int minp = (-nv) >>> 1;
            while (basej < posSize && poses[basej] < minp)
                basej++;
            for (int j = basej; j < posSize; j++) {
                int pv = poses[j];
                //需要找到的数字。
                int cv = 0 - nv - pv;
                //由于我们前面说了，找的都是比负数绝对值一半还要大的，所以第二个正数肯定小于等于第一个正数。
                //每次只往更大的负数找。防止重复。也就是说每次找的都是二者之间的数
                if (cv >= nv && cv <= pv) {
                    if (cv == nv) {
                        //如果第三个数字和负数相等(-1,-1,2)，那么就是两个负数一个正数。
                        if (map[nv - minValue] > 1)
                            res.add(Arrays.asList(nv, nv, pv));
                    } else if (cv == pv) {
                        //如果第三个数字和正数相等。(-2,1,1)，那么就是两个正数一个负数。
                        if (map[pv - minValue] > 1)
                            res.add(Arrays.asList(nv, pv, pv));
                    } else {
                        //如果第三个数字都不一样。那就直接添加。(-1,0,1)
                        if (map[cv - minValue] > 0)
                            res.add(Arrays.asList(nv, cv, pv));
                    }
                } else if (cv < nv)
                    break;
            }
        }
        return res;

    }
}
