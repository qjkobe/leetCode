package primary.linkedlist;
//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //双指针。快指针比满指针要快n.删除的时候删除slow.next
        ListNode slow = dummy;

        ListNode fast = dummy;
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
