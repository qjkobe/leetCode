package middle.linkedlist;
//给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
//
//请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
public class OddEvenList {
    public static void main(String[] args) {

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        //双指针
        ListNode odd = head;
        ListNode even = head.next;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode evenhead = head.next;
        while (even!= null && even.next!=null) {
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        //even为空，节点为奇数
        odd.next = evenhead;
        //even.next为空，节点是偶数。效果一样。
        return res.next;
    }
}
