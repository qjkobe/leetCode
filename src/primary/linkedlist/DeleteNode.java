package primary.linkedlist;

//请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
public class DeleteNode {

    public static void deleteNode(ListNode node) {
        //把后面几个节点遍历过来
        while(node.next.next!=null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }

    public static void deleteNode2(ListNode node) {
        //我真笨
        node.val = node.next.val;
        node = node.next.next;
    }
}
