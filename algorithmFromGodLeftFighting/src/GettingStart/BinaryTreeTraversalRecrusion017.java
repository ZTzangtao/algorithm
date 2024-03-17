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

    /**
     * 中序遍历
     *
     * @param head
     */
    public static void  inOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        preOrder(head.left);
        System.out.print(head.val + " ");
        preOrder(head.right);
    }


    /**
     * 后续打印
     *
     * @param head
     */
    public static void  posOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        preOrder(head.left);
        preOrder(head.right);
        System.out.print(head.val + " ");
    }

}
