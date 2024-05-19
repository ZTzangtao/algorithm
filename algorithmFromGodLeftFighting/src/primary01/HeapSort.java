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
        // 建立大根堆 时间复杂度 由顶到底
//        for(int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }
        // 由底到顶建堆
        for (int i = arr.length - 1; i >= 0; i--) {
//            heapInsert(arr, i);
            heapify(arr, i, arr.length - 1);
        }

        int heapSize = arr.length;
//        swap(arr, 0, --heapSize);
        while (heapSize > 1) {
            swap(arr,0, --heapSize);
            heapify(arr,0, heapSize);
        }
    }

    /**
     * 往前跳 跳到0 是相等，也会停止
     *
     * @param arr
     * @param index
     */
    // arr[index] 这个数是新来的，往上看，与父亲节点比较，直到不比父亲大，或者来到顶
    public static void heapInsert(int[] arr, int index) {
        // 当前值与父亲节点相比，如果大于父亲节点就交换
        //i -> 父亲节点的值
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1)/2);
            // 来到父亲节点的位置
            index = (index - 1) / 2;
        }
    }

    /**
     *
     * @param arr
     * @param index 位置
     * @param heapSize 堆的最右边
     */
    // 从i位置变， i位置的数变小了，又想维持大根堆结构
    public static void heapify(int[] arr, int index, int heapSize){
        // 左孩子下标
        int left = index * 2 + 1;

        // 有左孩子
        while (left < heapSize) {
            // 右孩子下标
            int right = left + 1;

            // 评选哪个更大
            // 两个条件都满足才是右孩子，不然都是左孩子最大
            int largest = right < heapSize && arr[right] > arr[left] ?
                    right : left;
            // 与自己比较，谁是最大的下标
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                // 最强的是自己
                break;
            }
            // largest != index
            swap(arr, largest, index);
            index = largest;
            // 左孩子下标
            left = index * 2 + 1;

        }


    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
