package primary01;

import java.util.Arrays;

/**
 * @Author: Tommy
 * @DATE: 2021/6/3
 */
public class Code_00_BubbleSort {

    /**
     * 对数器的概念和使用
     * 0，有一个你想要测的方法a
     * 1，实现一个绝对正确但是复杂度不好的方法b，
     * 2，实现一个随机样本产生器
     * 3，实现比对的方法
     * 4，把方法a和方法b比对很多次来验证方法a是否正确
     * 5，如果有一个样本使得比对出错，打印样本分析是哪个方法出错
     * 6，当样本数量很多时比对测试依然正确，可以确定方法a已经正确。
     *
     * @param args
     */

    public static void main(String[] args) {
        int testTime = 50000;
        int size = 10;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(size, value);
            int[] arr2 = copyArray(arr1);
            bubbleSort(arr1);
            rightMethod(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "Oh no!");
        printArray(generateRandomArray(size, value));
    }

    //for test
    //随机数组发生器
    public static int[] generateRandomArray(int size, int value) {
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random() - (int) (value * Math.random()));
        }
        return arr;
    }

    //for test
    //绝对正确的函数/算法
    public static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

    //for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    //for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    //for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
