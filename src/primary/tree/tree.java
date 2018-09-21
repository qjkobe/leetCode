package primary.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//给定一个二叉树，找出其最大深度。
//
//二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
public class tree {
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        //DFS
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = value.pop();
            max = Math.max(temp, max);
            if (node.left != null) {
                stack.push(node.left);
                value.push(temp + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                value.push(temp + 1);
            }
        }
        return max;
    }

    public static int maxDepth2(TreeNode root) {
        //BFS
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }

    public static int maxDepth3(TreeNode root) {
        //分解成小问题。
        if (root == null) {
            return 0;
        }
        int leftdepth = maxDepth3(root.left);
        int rightdepth = maxDepth3(root.right);
        return Math.max(leftdepth, rightdepth) + 1;
    }
}
