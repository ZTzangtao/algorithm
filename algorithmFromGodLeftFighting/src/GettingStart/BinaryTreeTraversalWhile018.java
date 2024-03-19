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

}
