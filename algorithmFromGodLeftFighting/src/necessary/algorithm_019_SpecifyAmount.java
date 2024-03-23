package necessary;

import java.io.*;

/**
 * 算法笔试中处理输入和输出
 */
public class algorithm_019_SpecifyAmount {

    public static void main(String[] args) throws IOException {
        // 把文件的内容，load进来，保存在内存里，很高效，很经济，托管的很好
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 一个一个读数字
        StreamTokenizer in = new StreamTokenizer(br);
        // 提交答案的时候用的，也是一个内存托管区
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) { // 文件没有结束就继续
            // n,二维数组的行
            int n = (int) in.nval;
            in.nextToken();
            // m,二维数组的列
            int m = (int) in.nval;
            // 装数字的矩阵，临时动态生成
            int[][] mat = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    in.nextToken();
                    mat[i][j] = (int) in.nval;
                }
            }
            out.println(maxSumSubmatrix(mat, n, m));
        }
        out.flush();
        out.close();
    }

    // 求子矩阵的最大累加和
    private static int maxSumSubmatrix(int[][] mat, int n, int m) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            // 需要辅助数组，临时动态生成
            int[] arr = new int[m];
            for (int j = i; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    arr[k] += mat[j][k];
                }
                max = Math.max(max, maxSumSubarray(arr, m));
            }
        }
        return max;
    }

    private static int maxSumSubarray(int[] arr, int m) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < m; i++) {
            cur += arr[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }

}
