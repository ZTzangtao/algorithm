package class98;

public class Code02_BigShow {


    //矩阵相乘
    // a的列数一定要等于b的行数
    public static int[][] multiply(int[][] a, int[][] b) {
        int n = a.length;
        int m = b[0].length;
        int k = a[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int c = 0; c < k; c++) {
                    ans[i][j]  += a[i][c] * b[c][j];
                }
            }
        }
        return ans;
    }

    // 矩阵快速幂
    // 要求矩阵m是正方形矩阵
    public static int[][] power(int[][] m, int p) {
        int n = m.length;
        // 对角线全是1、剩下数字都是0的正方形矩阵，称为单位矩阵
        // 相当于正方形矩阵中的1，矩阵a * 单位矩阵 = 矩阵a
        int [][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            ans[i][i] = 1;
        }
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                ans = multiply(ans, m);
            }
            m = multiply(m, m);
        }
        return ans;
    }

    // 用矩阵乘法解决斐波那契第n项的问题
    public static void f3() {
        int[][] start = { { 1, 0 } };
        int[][] m = {
                { 1, 1 },
                { 1, 0 }
        };
        int[][] a = multiply(start, m);
        int[][] b = multiply(a, m);
    }

    public static void f4() {
        int[][] start = { { 1, 0 } };
        int[][] m = {
                { 1, 1 },
                { 1, 0 }
        };
        int[][] a = multiply(start, power(m, 1));
        int[][] b = multiply(start, power(m, 2));
        int[][] c = multiply(start, power(m, 3));
        int[][] d = multiply(start, power(m, 4));
    }

    public static int fib2 (int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[][] start = { { 1, 0 } };
        int[][] base = {
                { 1, 1 },
                { 1, 0 }
        };
        int[][] ans = multiply(start, power(base, n-1));
        return ans[0][0];
    }


    public static void main(String[] args) {
        System.out.println(fib2(45));
        System.out.println(fib1(45));
    }


    public static int fib1 (int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);

    }
}
