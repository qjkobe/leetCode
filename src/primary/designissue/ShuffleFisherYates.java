package primary.designissue;

import java.util.Random;

//打乱一个没有重复元素的数组。这里使用FisherYates算法。
public class ShuffleFisherYates {
    private int[] array;
    private int[] original;
    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public ShuffleFisherYates(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = array.clone();
        return original;
    }

    public int[] shuffle() {
        for(int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
}
