package middle.tree;

import java.util.HashMap;

//二叉搜索树中第K小的元素
public class KthSmallest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(kthSmallest(root, 3));

    }

    private static int count = 0;
    private static int res = 0;
    private static int flag = 0;

    public static int kthSmallest(TreeNode root, int k) {
        //向左遍历并计数
        helper(root ,k);

        return res;
    }

    public static void helper(TreeNode root,int k) {
        if (root == null) {
            return;
        }
        helper(root.left, k);
        if (++count == k) {
            res = root.val;
            flag = 1;
            return;
        }
        if (flag == 1) {
            return;
        }
        helper(root.right, k);

    }
}
