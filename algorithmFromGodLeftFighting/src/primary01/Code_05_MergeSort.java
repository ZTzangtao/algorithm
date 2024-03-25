package primary01;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @Author: Tommy
 * @DATE: 2021/6/4
 */
public class Code_05_MergeSort {

    public static void main(String[] args) {
        int[] n = new int[]{1,54,8,7,6,3,2,8,0,34,3,1,23,4,6,3};
        mergeSort(n);
        System.out.println( Arrays.toString(n) );

    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    /**
     * T(n) = 2 * T(n/2) + O(n)
     * a = 2, b = 2, c = 1
     * 根据master公式，时间复杂度为O(n * logn)
     * 空间复杂度O(n)
     *
     * @param arr
     * @param L
     * @param R
     */
    private static void sortProcess(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        //L和R中点的位置
        int mid = L + ((R - L) >> 1);
        //T(N/2)
        sortProcess(arr, L, mid);
        //T(N/2)
        sortProcess(arr, mid + 1, R);
        //T(N) = 2(T(N/2)) + O(N)  =  O(N*logN)
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[i++] =
                    arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //两个必有且只有一个越界
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }

    }

}
