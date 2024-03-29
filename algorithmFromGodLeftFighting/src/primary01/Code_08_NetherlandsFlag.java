package primary01;

import java.util.Arrays;

/**
 * 荷兰国旗问题 (小于num放左边，等于num放中间，大于num放右边)
 *
 * @Author: Tommy
 * @DATE: 2021/6/5
 */
public class Code_08_NetherlandsFlag {

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,3,2,7,5,3,8,23,4,8};
        System.out.println(Arrays.toString(partition(arr,0, arr.length - 1,8)));
    }

    public static int[] partition(int[] arr, int L, int R, int num) {
        int less = L - 1;
        int more = R + 1;
        while (L < more) {
            if (arr[L] < num) {
                swap(arr, ++less, L++);
            } else if (arr[L] > num) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        // 返回等于num的 边界值  下标 index
//        return new int[]{less + 1, more - 1};
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
