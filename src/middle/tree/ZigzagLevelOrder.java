package middle.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
public class ZigzagLevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(7);

        List<List<Integer>> list = zigzagLevelOrder(root);

        for (List<Integer> a : list) {
            for (int b : a) {
                System.out.println(b);
            }
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        int flag=-1;//0左往右，1右往左
        deque.offer(root);
        flag = 1;
        while (!deque.isEmpty()) {
            //先获得大小
            int size = deque.size();
            List<Integer> subres = new LinkedList<>();
            while (size-- > 0) {

                if(flag == 1) {
                    TreeNode t = deque.poll();
                    subres.add(t.val);
                    if(t.left!=null)
                        deque.offer(t.left);
                    if(t.right!=null)
                        deque.offer(t.right);
                }
                if (flag == -1) {
                    TreeNode t = deque.poll();
                    subres.add(0, t.val);
                    if(t.left!=null)
                        deque.offer(t.left);
                    if(t.right!=null)
                        deque.offer(t.right);
                }
            }
            flag = -flag;
            res.add(subres);
        }
        return res;
    }
}
