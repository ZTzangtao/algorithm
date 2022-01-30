package primary01;

/**
 * 堆排序
 *
 * @Author: Tommy
 * @DATE: 2022/1/30
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        // 建立大根堆 时间复杂度
        for(int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
    }

    /**
     * 往前跳 跳到0 是相等，也会停止
     *
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1)/2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
