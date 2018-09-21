package middle.linkedlist;
//编写一个程序，找到两个单链表相交的起始节点。
public class GetIntersectionNode {

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(3);
        headA.next.next = new ListNode(5);
        headA.next.next.next = new ListNode(7);
        headA.next.next.next.next = new ListNode(9);
        headA.next.next.next.next.next = new ListNode(11);
        headA.next.next.next.next.next.next = new ListNode(13);
        ListNode headB = new ListNode(2);
        headB.next = null;
        ListNode res = getIntersectionNode(headA, headB);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //A跑到底转向B，B跑到底转向A，第二个循环的相交处会相遇，因为路程相等。
        ListNode pointA = headA;
        ListNode pointB = headB;
        ListNode tempA = null;
        ListNode tempB = null;
        int count = 0;
        while (true) {
            if (pointA == null) {
                pointA = headB;
            }
            if (pointB == null) {
                pointB = headA;
            }
            if (pointA.next == null) {
                tempA = pointA;
                if (tempB != null && tempA != tempB) {
                    return null;
                }
            }
            if (pointB.next == null) {
                tempB = pointB;
                if (tempA != null && tempA != tempB) {
                    return null;
                }
            }


            if (pointA == pointB) {
                return pointA;
            }
            pointA = pointA.next;
            pointB = pointB.next;
        }
    }
}
