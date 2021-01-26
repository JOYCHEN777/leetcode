package JZOF;

/*输入一个链表，反转链表后，输出新链表的表头。
 */
public class JZ15 {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        ListNode second = null;
        head.next = null;
        while (temp != null) {
            second =temp.next;
            temp.next = head;
            head = temp;
            temp = second;

        }
        return head;
    }
}
