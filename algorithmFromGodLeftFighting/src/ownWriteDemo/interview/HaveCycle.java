package ownWriteDemo.interview;

import listNode.ListNode;

/**
 * 环形链表
 *
 * @Author: Tommy
 * @DATE: 2022/3/12
 */
public class HaveCycle {

    public static void main(String[] args) {


        ListNode l1 = addBoy(6);
//        ListNode l2 = new ListNode(2, l1);
//        ListNode l3 = new ListNode(2, l2);
//        ListNode l4 = new ListNode(2, l3);
//        ListNode l5 = new ListNode(2, l4);

        System.out.println(hasCycle(l1));

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next() == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next();
        while (slow != fast) {
            if (fast == null || fast.next() == null) {
                return false;
            }
            slow = slow.next();
            fast = fast.next().next();
        }
        return true;
    }


    public static ListNode addBoy(int nums) {
        //创建一个环形的单向链表
        // 创建一个first节点，当前没有编号
        ListNode first = null;
        // 定义辅助节点
        ListNode curBoy = null;

        // 对nums做一个校验
        if (nums < 1) {
            System.out.println("数据错误");
            return null;
        }
        // 使用循环创建环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号创建节点
            ListNode boy = new ListNode(i);
            // 如果是第一个节点
            if (i == 1) {
                first = boy;
                first.next(first);
                // 让curBoy指向第一个节点，帮助构建链表
                curBoy = first;
            } else {
                curBoy.next(boy);
                // 使其指向第一个节点，形成环状
                boy.next(first);
                // curBoy后移
                curBoy = boy;
            }
        }
        return first;
    }

}
