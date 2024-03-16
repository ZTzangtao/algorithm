package GettingStart;

import listNode.TreeNode;

/**
 * 二叉树及其三种序的递归实现
 */
public class BinaryTreeTraversalRecrusion017 {

    /**
     * 先序遍历，递归版本
     * @param head
     */
    public static void  preOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        preOrder(head.left);
        preOrder(head.right);
    }


}
