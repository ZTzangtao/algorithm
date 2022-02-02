package ownWriteDemo;

import java.util.Arrays;

/**
 * @Author: Tommy
 * @DATE: 2022/2/1
 */
public class QuickSortDemo {

    public static void main(String[] args) {
        int[] arr = {1,3,5,5,46,4,42,2,23,42,35,42};
        int[] newArr = partition(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(newArr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length - 1);
    }

    public static void quickSort(int[] arr, int L, int R){
        if(L < R) {
            swap(arr, L + (int) ( Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr,p[1] + 1, R);
        }
    }

    /**
     * 小于arr[R]放左边, 等于arr[R]放中间, 大于arr[R]放右边
     *
     * @param arr
     * @param L
     * @param R
     */
    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R + 1;
        int i = arr[R];
        int cur = L;
        while(cur < more){
            if (arr[cur] < i){
               swap(arr, ++less, cur++);
            }else if(arr[cur] > i) {
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    /**
     * 交换位置
     *
     * @param arr original arr
     * @param i index
     * @param j index
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
