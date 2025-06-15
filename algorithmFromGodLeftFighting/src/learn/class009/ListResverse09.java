package learn.class009;

import listNode.ListNode;

/**
 * 单双链表及其反转
 *
 * @Author Tommy
 * @Date 2024/3/8 23:37
 * @Version 1.0
 */
public class ListResverse09 {
    /**
     * 单向链表反转
     *
     *
     */
    public static ListNode reverseList (ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static class DoubleListNode {
        public int value;
        public DoubleListNode last;
        public DoubleListNode next;
        public DoubleListNode (int v) {
            value = v;
        }
    }


    public static DoubleListNode reverseDoubleList (DoubleListNode head) {
        DoubleListNode pre = null;
        DoubleListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
       int[] arr = {1,2,4,2,3,4,4,6,43,332};
        g3(arr);
        System.out.println(arr[0]);
        g4(arr);
        System.out.println(arr[0]);
    }

    private static void g3(int[] arr) {
        arr = null;
    }

    private static void g4(int[] arr) {
        arr[0] = 100;
    }






}
