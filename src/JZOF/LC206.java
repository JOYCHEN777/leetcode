package JZOF;

public class LC206 {
    /*反转链表*/
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        ListNode second = null;
        head.next = null;
        while (temp != null) {
            second = temp.next;
            temp.next = head;
            head = temp;
            temp = second;
        }
        return head;
    }
}
