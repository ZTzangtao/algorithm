package leetcode;

import listNode.ListNode;

/**
 * @Author Tommy
 * @Date 2024/7/7 14:05
 * @Version 1.0
 */
public class Lc160intersectionOfTwoLinkedLists {

      /**
       * Definition for singly-linked list.
       * public class ListNode {
       *     int val;
       *     ListNode next;
       *     ListNode(int x) {
       *         val = x;
       *         next = null;
       *     }
       * }
       */
      public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
          ListNode node = headA;
          int diff = 0;
          while (node != null) {
              diff++;
              node = node.next;
          }
          node = headB;
          while (node != null) {
              diff--;
              node = node.next;
          }
          if (diff < 0) {
              // B 长
              node = headA;
              headA = headB;
              headB = node;
          }
          int step = Math.abs(diff);
          while (step > 0) {
              step--;
              headA = headA.next;
          }
          while (headA != null) {
              if (headA == headB) {
                  return headA;
              } else {
                  headB = headB.next;
                  headA = headA.next;
              }
          }
          return null;
      }





}
