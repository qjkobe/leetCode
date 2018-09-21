package primary.tree;

import primary.linkedlist.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
public class LeverOrder {
    public List<List<Integer>> LeverOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        List<List<Integer>> res = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new LinkedList<>();
            while (size-- > 0) {
                TreeNode a = q.poll();
                if(a!=null) {
                    list.add(a.val);
                    q.offer(a.left);
                    q.offer(a.right);
                }
            }
            if(!list.isEmpty())
                res.add(list);
        }
        return res;
    }
}
