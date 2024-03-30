package necessary;

/**
 * 翻转对数量
 *
 * https://leetcode.cn/problems/reverse-pairs/
 */
public class algorithm_22_2_merge_ReversePairs {

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{1,3,2,3,1}));
    }

    public static int MAXN = 50001;

    public static int[] help = new int[MAXN];

    /**
     * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
     */
    public static int reversePairs(int[] nums) {
        return counts(nums, 0, nums.length - 1);
    }

    /**
     * 统计l ... r 范围上，翻转对的数量，同时 l ... r 范围统计完后变有序
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private static int counts(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = l + ((r - l) >> 1);
        return counts(nums, l, m) + counts(nums, m + 1, r) + merge(nums, l, m, r);
    }

    private static int merge(int[] arr, int l, int m, int r) {
        // 统计部分
        int ans = 0;
        for (int i = l, j = m + 1; i <= m; i++) {
            while (j <= r && (long) arr[i] > (long) arr[j] * 2) {
                j++;
            }
            ans += j - m - 1;
        }
        // 正常merge
        int i = l;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            // 从小到大赋值到help数组上
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 两个必有且只有一个越界
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = l; i <= r; i++) {
            arr[i] = help[i];
        }
        return ans;
    }

}
