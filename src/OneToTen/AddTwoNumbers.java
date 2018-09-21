package OneToTen;

public class AddTwoNumbers {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        System.out.println(addTwoNumbers(new ListNode(0), new ListNode(1)).val);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 从第一位开始加，设置一个进位标志。
        ListNode preResult = new ListNode(0);
        ListNode resulttemp = preResult;
        int flag = 0;
        while(l1!=null || l2!=null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 ==null?0:l2.val;
            int thisbit = a+b + flag;
            flag = thisbit/10;
            thisbit = thisbit%10;
            resulttemp.next = new ListNode(thisbit);
            if (l1 != null) {
                l1 = l1.next;
            }
            if(l2 !=null){
                l2=l2.next;
            }
            resulttemp = resulttemp.next;
        }
        //多余进位
        if(flag>0){
            resulttemp.next = new ListNode(flag);
        }
        return preResult.next;

    }
}
