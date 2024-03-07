package GettingStart;

import java.util.ArrayList;
import java.util.Arrays;

public class Complexity {

    public static void main(String[] args) {
        /**
         * 随机生成长度为n 值在0 ~ v-1 之间 且任意相邻两数不相等的数组
         */
        int n = 10;
        int v = 4;
        int[] arr1 = new int[n];
        arr1[0] = (int) (Math.random() * v);
        for (int i = 1; i < n; i++) {
            do {
                arr1[i] = (int) (Math.random() * v);
            } while (arr1[i] == arr1[i - 1]);
        }
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("===================");
        // java中的动态数组是ArrayList
        // 各个语言的动态数组的初始化大小和实际扩容因子可能会变化，但是均摊都是O(1)
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(5);
        arr2.add(4);
        arr2.add(9);
        arr2.set(1, 6);
        System.out.println(arr2.get(1));
        System.out.println("===================");

        int[] arr = {32,4,45,7,3,2,2,345,23,7,4,34,67};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();
        System.out.println("===================");
        int N = 200000;
        long start;
        long end;
        System.out.println("starting...");
        start = System.currentTimeMillis();
        for (int i = 1; i <= N; i++) {
            for(int j = i; j <= N; j += i ) {
                /**
                 * 时间复杂度收敛于 O(N * logN)
                 */
            }
        }
        end = System.currentTimeMillis();
        System.out.println("测试结束，运行时间为: " + (end - start) + " 毫秒");

        System.out.println("starting...");
        start = System.currentTimeMillis();
        for(int i = 0; i <= N; i++) {
            for(int j = i; j <= N; j++ ) {
                /**
                 * 时间复杂度收敛于 O(N^2)
                 */
            }
        }
        end = System.currentTimeMillis();
        System.out.println("测试结束，运行时间为" + (end - start) + " 毫秒");
    }


    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        int end = n - 1, i = 0;
        while (end > 0) {
            if (arr[i] > arr[i + 1]) {
                int t = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = t;
            }
            if (i < end - 1) {
                i++;
            } else {
                end--;
                i = 0;
            }
        }
    }
}
