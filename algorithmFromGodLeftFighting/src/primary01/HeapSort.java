package primary01;


import java.util.Arrays;

/**
 * 堆排序
 *
 * @Author: Tommy
 * @DATE: 2022/1/30
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {1,3,5,5,46,4,42,2,23,42,35,42};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        // 建立大根堆 时间复杂度
        for(int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0){
            heapify(arr,0, heapSize);
            swap(arr,0, --heapSize);
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

    /**
     *
     * @param arr
     * @param index 位置
     * @param heapSize 堆的最右边
     */
    public static void heapify(int[] arr, int index, int heapSize){
        // 左孩子
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ?
                    left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index){
                break;
            }
            // largest != index
            swap(arr, largest,index);
            index = largest;
            left = index * 2 + 1;

        }


    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
