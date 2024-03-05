package GettingStart;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(exist(new int[]{1,3,4,67,87,967,657465,27465745}, 967));
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
