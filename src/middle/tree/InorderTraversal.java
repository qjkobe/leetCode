package middle.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//中序遍历二叉树
//给定一个二叉树，返回它的中序 遍历
public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = inorderTraversal2(root);
        for (int a : result) {
            System.out.println(a);
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        //递归
        List<Integer> res = new LinkedList<>();

        inorderTraversalUtil(res, root);
        return res;
    }

    public static void inorderTraversalUtil(List<Integer> res, TreeNode root) {
        if(root.left!=null)
            inorderTraversalUtil(res, root.left);
        res.add(root.val);
        if(root.right!=null)
            inorderTraversalUtil(res, root.right);
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        //迭代，用栈保存
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            res.add(temp.val);
            temp = temp.right;

        }
        return res;
    }
}
