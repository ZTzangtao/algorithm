package primary02;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 *
 * @Author: Tommy
 * @DATE: 2022/2/5
 */
public class Code_03_StackAndQueueConvert {

    /**
     * https://leetcode.cn/problems/implement-queue-using-stacks/submissions/512001285/
     *
     * 两个栈实现队列
     *  1.pop只有空了，才能往pop里倒数据
     *  2.如果要倒数据，数据一定要清完
     *
     */
    public static class TwoStackQueue {
        // in
        private Stack<Integer> stackPush;
        //往外弹的
        private Stack<Integer> stackPop;

        public TwoStackQueue(){
          stackPush = new Stack<Integer>();
          stackPop = new Stack<Integer>();
        }

        public void push(int pushInt){
            stackPush.push(pushInt);
        }


        public int poll(){
            if(stackPop.empty() && stackPush.empty()){
                throw new RuntimeException("Queue is empty!");
            } else if(stackPop.empty()){
                while (!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek() {
            if(stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }else if(stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }

    }


    public static class TwoQueueStack {
        private Queue<Integer> data;
        private Queue<Integer> help;

        public TwoQueueStack(){
            data = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(int pushInt){
            data.add(pushInt);
        }

        public int peek(){
            if (data.isEmpty()){
                throw new RuntimeException("Stack is empty!");
            }

            while (data.size() != 1){
                help.add(data.poll());
            }
            int res = data.poll();
            help.add(res);
            swap();
            return res;
        }

        public int pop(){
            if (data.isEmpty()){
                throw new RuntimeException("Stack is empty!");
            }
            while (data.size() > 1){
                help.add(data.poll());
            }
            int res = data.poll();
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> tmp = help;
            help = data;
            data = tmp;
        }
    }

    public static class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push (int x) {
            int n = queue.size();
            queue.offer(x);
            for (int i = 0; i < n; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop () {
            return queue.poll();
        }

        public int top () {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }

    }

}
