package primary.array;
//给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
//
//最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
//
//你可以假设除了整数 0 之外，这个整数不会以零开头。
public class PlusOne {
    public static void main(String[] args) {
        int[] nums = {9};
        System.out.println(plusOne(nums)[0]);
    }

    public static int[] plusOne(int[] digits) {
        int carry = 0;
        int len = digits.length;
        int tempsum = digits[len - 1] + 1;
        digits[len-1] = tempsum%10;
        carry = tempsum/10;
        for(int i = len-2; i>=0; i--) {
            if (carry == 0) {
                return digits;
            } else {
                tempsum = digits[i] + 1;
                digits[i] = (tempsum)%10;
                carry = (tempsum)/10;
            }
        }
        if (carry == 0) {
            return digits;
        } else {
            int[] result = new int[len + 1];
            result[0] = 1;
            return result;
        }
    }
}
