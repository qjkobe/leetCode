package middle.tree;
//根据一棵树的前序遍历与中序遍历构造二叉树。
public class BuildTree {
    public static void main(String[] args) {
        int[] preorder = {3, 1, 2};
        int[] inorder = {1, 3, 2};
        TreeNode a = buildTree(preorder, inorder);
        System.out.println(a.val);
        System.out.println(a.left.val);
        System.out.println(a.right.val);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        //递归，前序第一个是根。中序找到这个根，之前的是左子树。
        return buildTreeUtil(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public static TreeNode buildTreeUtil(int[] preorder, int[] inorder, int preStart, int left, int right) {
        //preStart是前序遍历的根。left和right是中序遍历的下标。
        if (left == right) {
            return new TreeNode(inorder[left]);
        }
        if (left > right || preStart > preorder.length - 1) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int index = search(inorder, preorder[preStart]);//找根在中序遍历的位置
        //左子树，根就是prestart+1。
        root.left = buildTreeUtil(preorder, inorder, preStart + 1, left, index - 1);
        //右子树根的位置为一prestart加上中序遍历找到的根的左边的长度。之所以要减去left，是因为left之前的包括了左边子树的长度。
        root.right = buildTreeUtil(preorder, inorder, preStart + 1 + index - left, index + 1, right);
        return root;
    }

    public static int search(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (target == a[i]) {
                return i;
            }
        }
        return -1;
    }
}
