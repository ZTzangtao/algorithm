package learn.class009;

import listNode.ListNode;

public class ListReverse {

    public static ListNode reverseList (ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
