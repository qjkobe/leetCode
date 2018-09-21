package primary.linkedlist;
//请判断一个链表是否为回文链表。
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(1);
        a.next.next.next = new ListNode(1);
        a.next.next.next.next = new ListNode(2);
        a.next.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(a));
    }

    public static boolean isPalindrome(ListNode head){
        //快慢指针遍历。慢指针到中间，快指针到底。
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode fast = new ListNode(0);
        fast.next = head;
        while(fast != null && fast.next != null){
            //循环结束后。slow.next就是后半部分。
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        slow = slow.next;
        slow = ReverseList.reverseList(slow);
        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

}
