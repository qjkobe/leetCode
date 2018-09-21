package primary.linkedlist;

//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
public class MergeTwoLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        //遍历两个链表，然后比大小组合。
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while(l1!=null && l2!= null){
            if(l1.val < l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }else{
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if(l1 != null){
            dummy.next = l1;
        }else{
            dummy.next = l2;
        }
        return res.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        //递归。拆解成小问题。每次合并只比较当前一个元素。下一个节点递归求解。
        //递归出口是有一边为空。
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = null;
        if (l1.val < l2.val) {
            res = l1;
            res.next = mergeTwoLists2(l1.next, l2);
        }else{
            res = l2;
            res.next = mergeTwoLists2(l1, l2.next);
        }
        return res;
    }
}
