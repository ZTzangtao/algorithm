package ownWriteDemo.greedy;

import java.util.Arrays;

/**
 * @Author: Tommy
 * @DATE: 2023/7/4
 */
public class ByteDanceMaxValue {

    public static void main(String[] args) {

    }

    public static int max(int[] w, int[] v, int bag) {
        int n = w.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = w[i];
            arr[i][1] = v[i];
        }
        //重量小的放前面
        Arrays.sort(arr, (a, b) -> (a[0] - b[0]));
        return 1;
    }

}
