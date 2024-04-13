package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/n-queens/description/
 */
public class NQueue {

    public static void main(String[] args) {
        solveNQueens(4);
    }


    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        List<String> strings;
        int[] q = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            q[i] = 0;
        }
        String point = ".";
        String queue = "Q";
        int j = 1;
        while (j >= 1) {
            q[j] = q[j] + 1;
            while (q[j] <= n && !checkValid(j, q)) {
                q[j] = q[j] + 1;
            }
            if(q[j] <= n) {
                if (j == n) {
                    strings = new ArrayList<>();
                    for (int i = 1; i <= n; i++) {
                        System.out.println(q[i]);
                        String pointOriginal = point.repeat(n);
                        char[] chars = pointOriginal.toCharArray();
                        chars[q[i] - 1] = queue.charAt(0);
                        strings.add(Arrays.toString(chars).replace(", ", "")
                                .replace("[", "")
                                .replace("]", ""));
                    }
                    list.add(strings);
                } else {
                    j = j + 1;
                }
            } else {
                q[j] = 0;
                j = j  - 1;
            }
        }
        return list;
    }

    /**
     * 判断在这个j是否有效
     *
     * @param j
     * @param q
     * @return
     */
    public static boolean checkValid (int j,  int[] q) {
        for (int i = 1; i < j; i++) {
            if (q[i] == q[j] || Math.abs(i - j) == Math.abs(q[i] - q[j])) {
                return false;
            }
        }
        return true;
    }

}
