package leetcode;

import listNode.TreeNode;

import java.util.*;

public class JZOF32PrintTreeNodeUpToDown {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        List<List<Integer>> lists = leverOrderLeftToRight(root);
        for (List<Integer> list : lists) {
            System.out.println(list + "");
        }
    }

    public static List<List<Integer>> leverOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> newList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                newList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(newList);
        }
        return list;
    }

    public static List<List<Integer>> leverOrderLeftToRight(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        // 0: left  1: right
        int level = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> listItem = new LinkedList<>();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 0) {
                    listItem.add(node.val);
                } else {
                    listItem.add(0, node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
            list.add(listItem);
        }
        return list;
    }
}
