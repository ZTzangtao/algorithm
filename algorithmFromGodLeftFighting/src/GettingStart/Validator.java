package GettingStart;

import primary01.Code_00_BubbleSort;
import primary01.Code_01_InsertionSort;
import primary01.Code_02_SelectionSort;

import java.util.Arrays;

public class Validator {

    //数组中的每个数，都在1~v之间，随机得到
    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * v) + 1;
        }
        return arr;
    }

    //为了验证
    public static int[] copyArray(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    // 为了验证
    public static boolean sameArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        for(int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 100;
        int V = 1000;
        int testTimes = 50000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            int n = (int) (Math.random() * N);

            int[] arr = randomArray(n, V);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);
            Code_00_BubbleSort.bubbleSort(arr1);
            Code_01_InsertionSort.insertionSort(arr2);
            Code_02_SelectionSort.selectSort(arr3);
            System.out.println(Arrays.toString(arr1));
            if (!sameArray(arr1, arr2) || !sameArray(arr1, arr3)) {
                System.out.println("出错了");
                // 当有错了
                // 打印是什么例子，出错的
                // 打印三个功能，各自排序成了什么样
                // 可能要把例子带入，每个方法，debug！
            }
        }
        System.out.println("测试结束");
    }
}
