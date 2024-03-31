package primary01;

import java.util.Arrays;

/**
 *
 * @Author: Tommy
 * @DATE: 2021/6/6
 */
public class Code_04_QuickSort {

    public static void main(String[] args) {
        int[] arr = {1,3,5,5,46,4,42,2,23,42,35,42};
        int[] newArr = partition(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(newArr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            // 挑选随机树放在数组末尾
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    /**
     *
     * @param arr 原数组
     * @param L 左侧
     * @param R 右侧
     * @return
     */
    public static int[] partition(int[] arr, int L, int R) {
        // 最左侧，小于more的值
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                // 先减一, 再赋值
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
