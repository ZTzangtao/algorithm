package primary01;

/**
 * @Author: Tommy
 * i ~ n-1范围上，找到最小值并放在i位置，然后i+1 ~ n-1范围上继续
 * @DATE: 2021/6/3
 */
public class Code_02_SelectionSort {
    //冒泡排序是先确定最后面的最大的数，而选择排序是先确定第一个数
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
