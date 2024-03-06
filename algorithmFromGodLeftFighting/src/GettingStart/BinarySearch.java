package GettingStart;

public class BinarySearch {

    public static void main(String[] args) {
//        System.out.println(exist(new int[]{1,3,4,67,87,967,657465,27465745}, 967));
//        System.out.println(minIndex(new int[]{1,3,4,67,87,967,657465,27465745}, 9670));
        System.out.println(maxIndex(new int[]{1,3,4,67,87,967,657465,27465745}, 9670));
    }

    /**
     * 找峰值点
     * https://leetcode.cn/problems/find-peak-element/submissions/508516559/
     * @param arr
     * @return
     */
    public static int findPeakElement(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        // 单独验证0位置
        if (arr[0] > arr[1]) {
            return 0;
        }
        // 单独验证 n - 1 位置
        if (arr[n - 1] > arr[n - 2]) {
            return n - 1;
        }
        int l = 1, r = n - 2,m = 0,ans = -1;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (arr[m - 1] > arr[m]) {
                r = m - 1;
            } else if (arr[m] < arr[m + 1]) {
                l = m + 1;
            } else {
                ans = m;
                break;
            }

        }
        return ans;
    }


    //大于等于num的最小位置
    public static int minIndex(int[] arr, int num) {
        if (arr.length == 0 || arr == null) {
            return -1;
        }
        int ans = -1;
        int l = 0, r = arr.length -1, m = 0;
        while (l <= r) {
            // 取中间值 (防止大于int的最大值)
            m = l + ((r - l) >> 1);
            if (arr[m] >= num) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    public static int maxIndex(int[] arr, int num) {
        if (arr.length == 0 || arr == null) {
            return -1;
        }
        int ans = -1;
        int l = 0, r = arr.length -1, m = 0;
        while (l <= r) {
            // 取中间值 (防止大于int的最大值)
            m = l + ((r - l) >> 1);
            if (arr[m] > num) {

                r = m - 1;
            } else {
                ans = m;
                l = m + 1;
            }
        }
        return ans;
    }


    // arr 有序的情况下，判断num存在与否
    public static boolean exist(int[] arr, int num) {
        if (arr.length == 0 || arr == null) {
            return false;
        }
        // 左边界，有边界和终点
        int l = 0, r = arr.length -1, m = 0;
        while (l <= r) {
            // 取中间值 (防止大于int的最大值)
            m = l + ((r - l) >> 1);
            if (arr[m] == num) {
                return true;
            } else if (arr[m] > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }

}
