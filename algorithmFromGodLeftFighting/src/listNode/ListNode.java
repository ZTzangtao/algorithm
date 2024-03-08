package listNode;

/**
 * @Author: Tommy
 * @DATE: 2022/3/12
 */
public class ListNode {

    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public ListNode next() {
        return next;
    }

    public void next(ListNode next) {
        this.next = next;
    }

    public int val(){
        return val;
    }
}
