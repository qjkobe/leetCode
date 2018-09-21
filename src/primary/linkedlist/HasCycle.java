package primary.linkedlist;

//给定一个链表，判断链表中是否有环。
public class HasCycle {
    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head) {
        //HashSet比较简单易懂，但是浪费空间，这里使用双指针。
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
