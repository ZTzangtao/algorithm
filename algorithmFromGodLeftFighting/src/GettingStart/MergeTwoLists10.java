package GettingStart;

import listNode.ListNode;

/**
 * @Author Tommy
 * @Date 2024/3/9 23:16
 * @Version 1.0
 */
public class MergeTwoLists10 {

    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if(head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode head =  head1.val <= head2.val ? head1 : head2;
        ListNode cur1 = head.next;
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = head;
        while (cur1 != null && cur2 != null) {

        }


        return head;
    }

}
