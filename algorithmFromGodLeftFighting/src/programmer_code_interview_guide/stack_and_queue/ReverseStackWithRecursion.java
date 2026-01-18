package programmer_code_interview_guide.stack_and_queue;

import java.util.*;
import java.io.*;



// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class ReverseStackWithRecursion {

    public static void main(String[] args) throws IOException {
        Stack<Integer> originalStack = new Stack<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String str =  bufferedReader.readLine();
        String[] strArr = str.split(" ");
        for (int i = 0; i < n; i++) {
            originalStack.push(Integer.parseInt(strArr[i]));
        }
        reverse(originalStack);
        while (!originalStack.isEmpty()) {
            System.out.print(originalStack.pop() + " ");
        }
    }

    // 返回最后一个数，且移除，并不改变之前的栈元素
    public static int getNewNumber(Stack<Integer> stack ) {
        int v = stack.pop();
        if (stack.isEmpty()) {
            return v;
        } else {
            int last = getNewNumber(stack);
            stack.push(v);
            return last;
        }
    }

    // push操作也是先插入最底下的值
    public static void reverse (Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getNewNumber(stack);
        reverse(stack);
        stack.push(i);

    }

}