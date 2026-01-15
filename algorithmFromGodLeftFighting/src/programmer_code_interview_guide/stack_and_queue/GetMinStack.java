package programmer_code_interview_guide.stack_and_queue;

import java.util.Stack;

/**
 * @Author: Tommy
 * @DATE: 2022/2/5
 */
public class GetMinStack {

    public static class MySatck1 {
        private Stack<Integer> stackDate;
        private Stack<Integer> stackMin;

        public MySatck1() {
            this.stackDate = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.getmin()) {
                this.stackMin.push(newNum);
            } else {
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }
            this.stackDate.push(newNum);
        }

        public int pop() {
            if (this.stackDate.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.stackDate.pop();
            if(value == this.getmin()) {
                this.stackMin.pop();
            }
            return value;
        }

        public int top() {
            if (this.stackDate.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.stackDate.peek();
            if(value == this.getmin()) {
                this.stackMin.peek();
            }
            return value;
        }


        public int getmin() {
            if(this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }

    public static class MyStack2 {

        public final int MAXN = 8001;

        public int[] data;

        public int[] min;

        int size;

        public MyStack2() {
            data = new int[MAXN];
            min = new int[MAXN];
            size = 0;
        }

        public void push(int val) {
            data[size] = val;
            if (size == 0 || val <= min[size - 1]) {
                min[size] = val;
            } else {
                min[size] = min[size - 1];
            }
            size++;
        }

        public void pop() {
            size--;
        }
        public int top() {
            return data[size - 1];
        }

        public int getMin() {
            return min[size - 1];
        }
    }


}
