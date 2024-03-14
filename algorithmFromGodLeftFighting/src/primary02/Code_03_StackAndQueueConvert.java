package primary02;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: Tommy
 * @DATE: 2022/2/5
 */
public class Code_03_StackAndQueueConvert {

    /**
     * 两个栈实现队列
     *  1.pop只有空了，才能往pop里倒数据
     *  2.如果要倒数据，数据一定要清完
     *
     */
    public static class TwoStackQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStackQueue(int pushInt){
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
            data = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
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
}
