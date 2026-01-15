package programmer_code_interview_guide.stack_and_queue;


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

    // import java.io.*;
    //import java.util.*;
    //
    //
    //// 注意类名必须为 Main, 不要有任何 package xxx 信息
    //public class Main {
    //    static Stack<Integer> enterStack = new Stack<>();
    //
    //    static Stack<Integer> goStack = new Stack<>();
    //
    //    public static void add (int val) {
    //        enterStack.push(val);
    //    }
    //
    //    public static int peek () {
    //        if (!goStack.isEmpty()) {
    //            return goStack.peek();
    //        } else {
    //            while (!enterStack.isEmpty()) {
    //                goStack.push(enterStack.pop());
    //            }
    //            return goStack.peek();
    //        }
    //    }
    //
    //    public static int poll () {
    //        if (!goStack.isEmpty()) {
    //            return goStack.pop();
    //        } else {
    //            while (!enterStack.isEmpty()) {
    //                goStack.push(enterStack.pop());
    //            }
    //            return goStack.pop();
    //        }
    //
    //    }
    //
    //    public static void main(String[] args) throws Exception {
    //        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //        int n = Integer.valueOf(in.readLine());
    //        for (int i = 0; i < n; i++) {
    //            String input = in.readLine();
    //            String[] elements = input.split(" ");
    //            if ("add".equals(elements[0])) {
    //                add(Integer.parseInt(elements[1]));
    //            } else if ("peek".equals(input)) {
    //                System.out.println(peek());
    //            } else if ("poll".equals(input)) {
    //                // poll
    //                poll();
    //            }
    //        }
    //
    //
    //    }
    //}

}
