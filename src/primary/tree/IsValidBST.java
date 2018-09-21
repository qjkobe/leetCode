package primary.tree;

//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
public class IsValidBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        System.out.println(isValidBST2(root));
    }
    static TreeNode pre = null;
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        //每个点都有最小值最大值之间的区间
        if(node.val >= min && node.val <= max)
            //递归，左边节点最小值是min，最大值是当前节点减一。右边相反。
            return isValidBST(node.left, min, (long) node.val - 1)
                    && isValidBST(node.right, (long) node.val + 1, max);
        else return false;
    }

    public static boolean isValidBST2(TreeNode node) {
        if (node == null) {
            return true;
        }
        //遍历节点（要从左到右遍历），使用递归，利用全局变量pre表示上一个遍历的元素
        boolean f1 = isValidBST2(node.left);//向左遍历
        boolean f2 = pre == null || pre.val < node.val;//最左边不用管，接下来的pre要小于当前节点
        pre = node;
        return f1 && f2 && isValidBST2(node.right);//左边遍历完继续右边。

    }
}
