package Contest;

import java.util.List;

//给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
//如果有两个中间结点，则返回第二个中间结点。
public class MidNodeOfList {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }

    public static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode left = head;
        ListNode right = head.next;
        if (right == null) {
            return left;
        }
        while (right.next != null) {
            right = right.next;
            right = right.next;
            left = left.next;
            if (right == null) {
                return left;
            }
        }
        //走到这一步说明有两个中间节点。
        return left.next;
    }

}
