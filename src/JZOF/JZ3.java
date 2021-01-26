package JZOF;

import java.util.ArrayList;

/*输入一个链表，按链表从尾到头的顺序返回一个ArrayList。*/
public class JZ3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null)
            return null;
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int c = 1;
        arr.add(listNode.val);
        while (listNode.next != null) {
            c++;
            arr.add(listNode.next.val);
            listNode = listNode.next;
        }
        for (int i = c - 1; i >= 0; i--) {
            res.add(arr.get(i));
        }
        return res;
    }


}
