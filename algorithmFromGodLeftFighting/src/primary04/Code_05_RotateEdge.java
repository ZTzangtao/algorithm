package primary04;

/**
 * @Author: Tommy
 * @DATE: 2022/9/18
 */
public class Code_05_RotateEdge {

    private static void rotate (int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    /**
     *
     * @param m
     * @param tR  左上角点的行
     * @param tC  左上角点的列
     * @param dR  右下角点的行
     * @param dC  右下角点的列
     */
    private static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[tR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = tmp;
        }

    }

}
