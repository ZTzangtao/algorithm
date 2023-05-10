package interviewAlgorithm.reversePoland;

import java.util.Stack;

/**
 * @Author: Tommy
 * @DATE: 2023/5/9
 */
public class ReversePolishNotation {

    public static int getAns(String rpn){
        if (rpn == null || rpn.equals("")){
            return 0;
        }
        String[] parts = rpn.split(" ");
        Stack<Integer> stack = new Stack<>();
        for (String part : parts) {
            if (("+").equals(part) || ("-").equals(part) || ("*").equals(part) || ("/").equals(part)) {
                int right = stack.pop();
                int left = stack.pop();
                int ans = 0;
                if (("+").equals(part)) {
                    ans = left + right;
                } else if (("-").equals(part)) {
                    ans = left - right;
                } else if (("*").equals(part)) {
                    ans = left * right;
                } else {
                    ans = left / right;
                }
                stack.push(ans);
            } else {
                stack.push(Integer.valueOf(part));
            }
        }
        return stack.pop();
    }

    enum Operation {
        SingleNumber, AddOrMinus, MultiplyOrDivide;
    }

    public static String convert(String rpn) {
        if (rpn == null || rpn.equals("")){
            return rpn;
        }

        String[] parts = rpn.split(" ");
        Stack<String> stack1 = new Stack<>();
        Stack<Operation> stack2 = new Stack<>();
        for (String cur: parts) {
            if ("+".equals(cur) || "-".equals(cur)) {
                String right = stack1.pop();
                String left = stack1.pop();
                stack2.pop();
                stack2.pop();
                stack1.push(left + cur + right);
                stack2.push(Operation.AddOrMinus);
            } else if ("*".equals(cur) || "/".equals(cur)) {
                String b = stack1.pop();
                String a = stack1.pop();
                Operation bOp = stack2.pop();
                Operation aOp = stack2.pop();
                String left = aOp == Operation.AddOrMinus ? ( "(" + a + ")") : a;
                String right = bOp == Operation.AddOrMinus ? ( "(" + b + ")") : b;
                stack1.push(left + cur + right);
                stack2.add(Operation.MultiplyOrDivide);
            } else {
                stack1.push(cur);
                stack2.push(Operation.SingleNumber);
            }
        }
        return stack1.pop();
    }

    public static void main(String[] args) {
        String rpn = "3 -5 13 + * 6 2 3 - 2 + / + 4 5 3 * * -";
        System.out.println(getAns(rpn));
        System.out.println(convert(rpn));
    }
}
