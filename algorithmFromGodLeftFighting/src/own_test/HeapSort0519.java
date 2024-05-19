package own_test;

import java.util.Arrays;

public class HeapSort0519 {

    public static void main(String[] args) {
        int[] t = new int[]{1,3,4,5,3,21,2,4,67,8,5};
        heapSort(t);
        System.out.println(Arrays.toString(t));
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        // 这是从前往后构建
//        for (int i = 0; i < arr.length - 1; i++) {
//            heapInsert(arr, i);
//        }
        // 这是从底到顶建立大根堆
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length - 1);
        }
        System.out.println(Arrays.toString(arr));
        int heapSize =  arr.length;
        while (heapSize > 1) {
            // 先交换
            swap(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }

    }

    // 插入操作
    public static void heapInsert(int[] arr, int i) {
        // 与父节点的位置比较
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    /**
     *  沉底
     *
     * @param arr
     * @param i
     * @param heapSize
     */
    public static void heapify (int[] arr, int i, int heapSize) {
        // 左孩子
        int left = i * 2 + 1;

        while (left < heapSize) {

            // 右孩子
            int right = left + 1;
            // 下标
            int biggest = right < heapSize && arr[right] > arr[left] ? right : left;
            int best = arr[i] > arr[biggest] ? i : biggest;
            if (i == best) {
                break;
            }
            swap(arr, i, best);
            i = best;
            left = best * 2 + 1;
        }




    }


    public static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
