package programmer_code_interview_guide.stack_and_queue;
import java.util.*;
import java.io.*;
public class SortStackByStack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] strArr = str.split(" ");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(strArr[i]));
        }
        sortStack(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);

        }
        while(!help.isEmpty()) {
            stack.push(help.pop());
        }

    }

}
