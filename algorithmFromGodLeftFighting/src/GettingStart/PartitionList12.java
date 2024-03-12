package GettingStart;

import listNode.ListNode;

public class PartitionList12 {

    /**
     * https://leetcode.cn/problems/partition-list/description/
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partitionList(ListNode head, int x) {
        ListNode leftHead = null, leftTail = null;
        ListNode rightHead = null, rightTail = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < x) {
                if (leftHead == null) {
                    leftHead = head;
                } else {
                    leftTail.next = head;
                }
                leftTail = head;
            } else {
                if (rightHead == null) {
                    rightHead = head;
                } else {
                    rightTail.next = head;
                }
                rightTail = head;
            }
            head = next;
        }
        if (leftHead == null) {
            return rightHead;
        }
        leftTail.next = rightHead;
        return leftHead;
    }


}
