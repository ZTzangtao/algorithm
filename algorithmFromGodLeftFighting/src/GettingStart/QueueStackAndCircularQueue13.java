package GettingStart;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 入门13 栈和队列，用数组实现队列
 */
public class QueueStackAndCircularQueue13 {

    class MyCircularQueue {
        public int[] queue;

        public int l, r, size, limit;

        // 同时在队列里的数不能超过k
        public MyCircularQueue(int k) {
            queue = new int[k];
            l = r = size = 0;
            limit = k;
        }

        public boolean isEmpty () {
            return size == 0;
        }

        public boolean isFull () {
           return size == limit;
        }

        // 如果队列满了，返回false
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            } else {
                queue[r] = value;
                r = r == limit - 1 ? 0 : (r + 1);
                size++;
                return true;
            }
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            } else {
                l = l == limit - 1 ? 0 : (l + 1);
                size--;
                return true;
            }
        }

        /**
         * 返回队列头部的数字，不弹出
         *
         * @return
         */
        public int front() {
            if (isEmpty()) {
                return -1;
            } else {
                return queue[l];
            }
        }

        public int rear() {
            if (isEmpty()) {
                return -1;
            } else {
                int last = r == 0 ? (limit - 1) : (r - 1);
                return queue[last];
            }
        }

    }


    /**
     * 用数组实现栈
     */
    public static class Stack2 {
        public int[] stack;

        public int size;

        public Stack2(int n) {
            stack = new int[n];
            size = 0;
        }
        public boolean isEmpty() {
            return size == 0;
        }


        public void push(int num) {
            stack[size++] = num;
        }


        public int pop() {
            return stack[--size];
        }


        public int peek() {
            return stack[size - 1];
        }


        public int size() {
            return size;
        }

    }


    /**
     * 实际刷题时更常见的写法，常数时间好
     * 如果可以确定加入操作的总次数不超过n，那么可以用
     * 一般笔试、面试都会有一个明确数据量，所以这是最常用的方式
     */
    public static class Queue2 {
        public int[] queue;

        public int l;

        public int r;

        public Queue2(int n) {
            queue = new int[n];
            l = 0;
            r = 0;
        }

        /**
         * 调任何方法前，先调用这个方法来判断队列是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return l == r;
        }

        /**
         * 向队列加入一个数，加到尾
         *
         * @param num
         */
        public void offer(int num) {
            queue[r++] = num;
        }

        /**
         * 从头拿
         *
         * @return
         */
        public int poll() {
            return queue[l++];
        }

        /**
         * 查看头元素，不弹出
         *
         * @return
         */
        public int peek() {
            return queue[l];
        }

        public int tail() {
            return queue[r - 1];
        }

        /**
         * 返回目前队列大小
         *
         * @return
         */
        public int size() {
            return r - l;
        }

    }



    /**
     * 直接用java的内部实现
     * 其实内部就是双向链表，常数操作慢
     */
    public static class Queue1 {
        /**
         * java中的双向链表
         */
        public Queue<Integer> queue = new LinkedList<>();

        /**
         * 调用任何方法之前，先调用这个方法来判断队列内是否有东西
         *
         * @return
         */
        public boolean isEmpty() {
            return queue.isEmpty();
        }

        /**
         * 向队列加入一个数，加到尾
         *
         * @param num
         */
        public void offer(int num) {
            queue.offer(num);
        }

        /**
         * 从头拿
         *
         * @return
         */
        public int poll() {
            return queue.poll();
        }

        /**
         * 查看头元素，不弹出
         *
         * @return
         */
        public int peek() {
            return queue.peek();
        }

        /**
         * 返回目前队列大小
         *
         * @return
         */
        public int size() {
            return queue.size();
        }

    }

}
