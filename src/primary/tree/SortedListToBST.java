package primary.tree;

import primary.linkedlist.ListNode;

//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//
//本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
public class SortedListToBST {
    public static ListNode node;
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        SortedListToBST ss = new SortedListToBST();
        TreeNode res = ss.sortedListToBST(head);
        System.out.println(res.val);
        System.out.println(res.left.val);
        System.out.println(res.right.val);

    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int size = 0;
        node = head;
        while (head != null) {
            head = head.next;
            size++;
        }
        return sortedListToBST(0, size);
    }

    public static TreeNode sortedListToBST(int start, int end) {
        if(start == end){
            return null;
        }
        //只有一个节点
        if (start == end - 1) {
            TreeNode treeNode = new TreeNode(node.val);
            node = node.next;
            return treeNode;
        }
        int mid = (start + end) / 2;
        //先向左遍历到底，因为node在最左边
        TreeNode left = sortedListToBST(start, mid);

        TreeNode treeNode = new TreeNode(node.val);
        treeNode.left = left;
        node = node.next;
        TreeNode right = sortedListToBST(mid + 1, end);
        treeNode.right = right;

        return treeNode;
    }
}
