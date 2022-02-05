package primary02;

import org.omg.SendingContext.RunTime;
import sun.security.mscapi.CPublicKey;

import java.util.Stack;

/**
 * @Author: Tommy
 * @DATE: 2022/2/5
 */
public class Code_02_GetMinStack {

    public static class MySatck1{
        private Stack<Integer> stackDate;
        private Stack<Integer> stackMin;

        public MySatck1(){
            this.stackDate = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int newNum){
            if (this.stackMin.isEmpty()){
                this.stackMin.push(newNum);
            } else if(newNum <= this.getmin()){
                this.stackMin.push(newNum);
            }
            this.stackDate.push(newNum);
        }

        public int pop(){
            if (this.stackDate.isEmpty()){
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.stackDate.pop();
            if(value == this.getmin()){
                this.stackMin.pop();
            }
            return value;
        }

        public int getmin() {
            if(this.stackMin.isEmpty()){
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }

    public static class MyStack2{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2(){
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int newNum){
            if(this.stackMin.isEmpty()){
                this.stackMin.push(newNum);
            }else if(newNum < this.getmin()){
                this.stackMin.push(newNum);
            } else {
                int newMin = this.stackMin.peek();
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }

        public int pop(){
            if (this.stackData.isEmpty()){
                throw new RuntimeException("Your stack is empty.");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }

        private int getmin() {
            if(this.stackMin.isEmpty()){
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }

    }


}
