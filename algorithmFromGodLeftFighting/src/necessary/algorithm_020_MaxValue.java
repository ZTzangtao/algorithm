package necessary;

// 用这个例子讲解递归如何执行
public class algorithm_020_MaxValue {

    public static void main(String[] args) {
        int[] arr = { 3, 8, 7, 6, 4, 5, 1, 2};
        System.out.println("数组最大值 : " + maxValue(arr));
    }

    private static int maxValue(int[] arr) {
        return f(arr, 0, arr.length - 1);

    }

    // arr[l ... r] 范围上的最大值
    private static int f(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int m = (l + r) / 2;
        int lMax = f(arr, l, m);
        int rMax = f(arr, m+1, r);
        return Math.max(lMax, rMax);
    }

}
