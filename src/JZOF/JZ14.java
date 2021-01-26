package JZOF;
/*输入一个链表，输出该链表中倒数第k个结点。
*/
public class JZ14 {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode pre = head;
        ListNode p = head;
        if(head == null ){
            return null;
        }
        if(k == 0){
            return null;
        }
        for(int i=1;i<=k-1;i++){

            pre=pre.next;
            if (pre == null) {
                return null;
            }
        }
        while(pre.next!=null){
            pre=pre.next;
            p=p.next;
        }
        return p;
    }
}
