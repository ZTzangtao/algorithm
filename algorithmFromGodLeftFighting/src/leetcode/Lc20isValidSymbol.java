package leetcode;

/**
 * @Author: Tommy
 * @DATE: 2023/5/18
 */
public class Lc20isValidSymbol {

    public static boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return false;
        }
        char[] allSymbols = s.toCharArray();

        char[] stack = new char[allSymbols.length];

//        Stack<Character> stack = new Stack();
        int size = 0;
        for (char symbol : allSymbols) {
            if (symbol == '(' || symbol == '[' || symbol == '{') {
                stack[size++] = symbol == '(' ? ')' : (symbol == '[' ? ']' : '}');
//                stack.add(symbol == '(' ? ')' : (symbol == '[' ? ']' : '}'));
            } else {
//                if (stack.isEmpty()) {
                if (size == 0) {
                    return false;
                }
//                char c = stack.pop();
                char c =  stack[--size];
                if (c != symbol) {
                    return false;
                }
            }
        }
        return size == 0;
//        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
