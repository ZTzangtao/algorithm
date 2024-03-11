package GettingStart;

import listNode.ListNode;

import java.util.List;

public class TwoListsSum11 {

    public ListNode AddTwoNumbers(ListNode h1, ListNode h2) {
        ListNode ans = null, cur = null;
        int carry = 0;
        for (int sum,val; h1 != null || h2 != null; h1 = h1 == null? null : h1.next, h2 = h2 == null ? null : h2.next) {
            sum = (h1 == null ? 0 : h1.val) + (h2 == null ? 0 : h2.val) + carry;
            val = sum % 10;
            carry = sum / 10;
            if (ans == null) {
                ans = new ListNode(val);
                cur = ans;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return ans;
    }

}
