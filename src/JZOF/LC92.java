package JZOF;

import java.util.List;

/**
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class LC92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head==null||head.next==null) {
            return head;
        }
        ListNode dumb=new ListNode(-1);
        dumb.next=head;
        ListNode pre=dumb;
        for(int i=0;i<m-1;i++){
            pre=pre.next;
        }
        ListNode cur=pre.next;
        ListNode temp;
        for(int i=0;i<m-n;i++){
            temp=cur.next;
            cur.next=temp.next;
            temp.next=pre.next;
            pre.next=temp;
        }
        return dumb.next;
    }
}
