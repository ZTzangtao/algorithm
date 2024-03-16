package GettingStart;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 算法讲解016 入门
 * 双端队列-双链表和固定数组实现
 *
 * https://leetcode.cn/problems/design-circular-deque/submissions/512762483/
 */
public class MyCircularDeque016 {

    /**
     * 用固定数组来实现
     */
    class MyCircularDeque2 {
        public int[] deque;

        public int l, r, size, limit;

        public MyCircularDeque2(int k) {
            deque = new int[k];
            l = r = size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    l = r = 0;
                    deque[0] = value;
                } else {
                    l = l == 0 ? (limit - 1) : (l - 1);
                    deque[l] = value;
                }
                size++;
                return true;
            }
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    l = r = 0;
                    deque[0] = value;
                } else {
                    r = r == limit - 1 ? (0) : (r + 1);
                    deque[r] = value;
                }
                size++;
                return true;
            }
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            } else {
              l = l == limit - 1 ? 0 : (l + 1);
              size--;
              return true;
            }
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            } else {
                r = r == 0 ? (limit - 1) : (r - 1);
                size--;
                return true;
            }
        }

        public int getFront() {
            if(isEmpty()) {
                return -1;
            } else {
                return deque[l];
            }
        }

        public int getRear() {
            if(isEmpty()) {
                return -1;
            } else {
                return deque[r];
            }
        }

        public boolean isFull() {
            return limit == size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

    }




    // 其内部就是双向链表
    // 其常数操作慢
    class MyCircularDeque1 {
        public Deque<Integer> deque = new LinkedList<>();

        public int size;

        public int limit;

        public MyCircularDeque1(int k) {
            size = 0;
            limit = k;
        }

        public boolean insertFront (int value) {
            if (isFull()) {
                return false;
            } else {
                deque.offerFirst(value);
                size++;
                return true;
            }
        }

        public boolean insertLast (int value) {
            if (isFull()) {
                return false;
            } else {
                deque.offerLast(value);
                size++;
                return true;
            }
        }

        public boolean deleteFront () {
            if (isEmpty()) {
                return false;
            } else {
                size--;
                deque.pollFirst();
                return true;
            }
        }

        public boolean deleteLast () {
            if (isEmpty()) {
                return false;
            } else {
                size--;
                deque.pollLast();
                return true;
            }
        }

        public int getFront () {
            if (isEmpty()) {
                return -1;
            } else {
                return deque.peekFirst();
            }
        }

        public int getRear () {
            if (isEmpty()) {
                return -1;
            } else {
                return deque.peekLast();
            }
        }

        public boolean isFull () {
            return size == limit;
        }

        public boolean isEmpty () {
            return size == 0;
        }

    }
}
