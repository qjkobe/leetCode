package primary.others;

import java.util.LinkedList;
import java.util.List;

//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
public class Generate {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new LinkedList<>();
        }
        //List头尾都是1
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        list.add(1);
        res.add(list);

        for(int i = 1;i < numRows; i++) {
            //i 是行。0 到 numRows - 1
            //每列list大小为i+1
            List<Integer> temp = new LinkedList<>();
            temp.add(1);
            for(int j = 1; j < i; j++) {
                //i-1 list里的 j和j+1相加组成j+1
                temp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }
}
