package primary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {
    public static void main(String[] args) {
        IsSymmetric is = new IsSymmetric();

    }

    public boolean isSymmetric(TreeNode root) {
        //拆分成左右两边，对应元素相等。
        return isSymmetric(root, root);
    }

    public static boolean isSymmetric(TreeNode r1, TreeNode r2) {
        if (r1 == r2 && r1!=null) {
            //如果是root
            return isSymmetric(r1.left, r2.right);
        }
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        return r1.val == r2.val &&
                isSymmetric(r1.left, r2.right) &&
                isSymmetric(r1.right, r2.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        //深度遍历按层对比
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode r1 = root;
        TreeNode r2 = root;
        q.offer(r1);
        q.offer(r2);
        while (!q.isEmpty()) {
            r1 = q.poll();
            r2 = q.poll();
            if (r1 == null && r2 == null) {
                continue;
            }
            if (r1 == null || r2 == null) {
                return false;
            }
            if (r1.val != r2.val) {
                return false;
            }
            q.offer(r1.left);
            q.offer(r2.right);
            q.offer(r2.left);
            q.offer(r1.right);
        }
        return true;
    }
}
