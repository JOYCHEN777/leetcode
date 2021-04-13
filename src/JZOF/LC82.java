package JZOF;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，
 * 请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
 * 返回同样按升序排列的结果链表。
 */
public class LC82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        if(head.next.val==head.val){
            while(head.next!=null&&head.next.val==head.val){
                head.next=head.next.next;
            }
            return deleteDuplicates(head.next);
        }else{
            head.next=deleteDuplicates(head.next);
            return head;
        }
    }

}
/**
 * if (head == null || head.next == null) {
 *             return head;
 *         }
 *         ListNode dummy = new ListNode(-101);
 *         dummy.next = head;
 *         ListNode cur = dummy;
 *         while (cur.next != null && cur.next.next != null) {
 *
 *             if (cur.next.next.val == cur.next.val) {
 *                 int t = cur.next.val;
 *
 *                 while (cur.next != null && cur.next.val == t) {
 *                     cur.next = cur.next.next;
 *                 }
 *             } else {
 *                 cur = cur.next;
 *             }
 *         }
 *         return dummy.next;
 */