package primary.tree;
//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//
//本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        //递归，很容易想到可以分治处理。
        return sortedArrayToBST(nums, 0, nums.length);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int begin, int end) {
        if (begin == end) {
            return null;
        }
        //只有一个数字了
        if (begin == end-1) {
            return new TreeNode(nums[begin]);
        }
        int mid = (begin + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, begin, mid);
        node.right = sortedArrayToBST(nums, mid+1, end);
        return node;
    }
}
