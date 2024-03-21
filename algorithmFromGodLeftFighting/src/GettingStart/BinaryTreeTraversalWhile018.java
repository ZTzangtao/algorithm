package GettingStart;

import listNode.TreeNode;

import java.util.Stack;

public class BinaryTreeTraversalWhile018 {

    /**
     * 先序打印所有节点，非递归版
     * @param head
     */
    public static void preOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.val + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
            System.out.println();
        }
    }

    /**
     * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
     *
     * @param head
     */
    public static void inOrder (TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while(!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.val + " ");
                    head = head.right;
                }
            }
            System.out.println();
        }
    }

    /**
     * 后续遍历
     * 两个栈实现
     *
     * @param head
     */
    public static void posOrder (TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> collect = new Stack<>();
            stack.push(head);
            while(!stack.isEmpty()) {
                head = stack.pop();
                collect.push(head);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
            while (!collect.isEmpty()) {
                System.out.print(collect.pop().val + " ");
            }
            System.out.println();
        }
    }

    /**
     * 后续遍历
     * 一个栈实现
     *
     * @param head
     */
    public static void posOrder1 (TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            /**
             * 如果始终没有打印过节点，head就一直是头节点
             * 一旦打印过节点，head就变成打印节点
             * 之后head的含义： 上一次打印的节点
             */
            while(!stack.isEmpty()) {
                TreeNode cur = stack.peek();
                // 有左树，且左树没有被处理过
                if (cur.left != null && head != cur.left && head != cur.right) {
                    stack.push(cur.left);
                } else if (head.right != null && head != cur.right) {
                    // 有右树，且右树没有被处理过
                    stack.push(head.right);
                } else {
                    // 左树、右树 没有 或者 都处理过了
                    System.out.println(cur.val + " ");
                    head = stack.pop();
                }
            }
            System.out.println();
        }
    }

}
