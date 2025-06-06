package necessary;

/**
 * 随机选择算法 时间复杂度O(N) 额外空间复杂度O(1)
 */
public class algorithm_24_2_RandomizedSelect {

    /**
     * 返回第K大
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(
                findKthLargest(new int[] {3, 2, 1, 5, 6, 4, 7}, 2));
    }

    /**
     * 随机选择算法，时间复杂度O(n）
     *
     * @param nums
     * @param k
     * @return
     */

    public static int findKthLargest (int[] nums, int k) {
        // 第N - 1 大
        return randomizedSelect(nums, nums.length - k);
    }

    /**
     * 如果arr排序的话， i位置上的数是什么
     *
     * @param arr
     * @param i
     * @return
     */
    private static int randomizedSelect(int[] arr, int i) {
        int ans = 0;
        // 0 ~ n-1
        // l ~ r
        for (int l = 0, r = arr.length - 1; l <= r;) {
            // 随机
            partition(arr, l, r, arr[l + (int) (Math.random() * (r - l + 1))]);
            // first  last
            if (i < first) {
                r = first - 1;
            } else if (i > last) {
                l = last + 1;
            } else {
                ans = arr[i];
                break;
            }

        }
        return ans;
    }

    public static int first, last;

    // 荷兰国旗问题
    // < x   ==x   >x
    public static void partition(int[] arr, int L, int R, int x) {
        first = L;
        last = R;
        int i = L;
        while (i <= last) {
            if (arr[i] < x) {
                swap(arr, first++, i++);
            } else if (arr[i] > x) {
                swap(arr, i, last--);
            } else {
                i++;
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
