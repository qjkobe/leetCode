package primary.linkedlist;
//反转一个单链表。
public class ReverseList {

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        a.next = new ListNode(1);
        ListNode res = reverseList(a);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        //迭代
        ListNode prev = null;
        ListNode nextTemp = head;
        while (nextTemp!=null){
            nextTemp = head.next;
            head.next = prev;
            prev = head;
            head = nextTemp;
        }
        return prev;
    }

    public static ListNode reverseList2(ListNode head) {
        //递归。非常有技巧性
        if (head == null) {
            return null;//没有内容
        }
        if (head.next == null) {
            //最后一个点，递归出口
            return head;
        }
        ListNode p = reverseList2(head.next);//不断传进下一个
        head.next.next = head;//一旦返回，那么下一个节点指向当前这个节点。
        head.next = null;//这一步是为了让最前面一个元素指向空
        return p;
    }
}
