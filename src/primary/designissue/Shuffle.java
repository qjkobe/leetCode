package primary.designissue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//打乱一个没有重复元素的数组。
public class Shuffle {
    private int[] array;
    private int[] original;

    private Random rand = new Random();

    private List<Integer> getArrayCopy() {
        List<Integer> res = new ArrayList<>();
        for(int i =0; i < array.length; i++) {
            res.add(array[i]);
        }
        return res;
    }

    public Shuffle(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> aux = getArrayCopy();
        for(int i = 0; i < array.length; i++) {
            int removeIdx = rand.nextInt(aux.size());
            array[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
        }

        return array;
    }
}
