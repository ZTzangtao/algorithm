package primary04;

/**
 * @Author: Tommy
 * @DATE: 2022/2/12
 */
public class Code_05_RotateMatrix {


    /**
     * 循环打印二维数组
     *
     * @param matrix
     */
    public static void spiralOrderPrint (int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC  <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    /**
     * 打印矩阵
     *
     * @param m  二维数组
     * @param tR  左上角点的行
     * @param tC  左上角点的列
     * @param dR  右下角点的行
     * @param dC  右下角点的列
     */
    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC){
        if(tR == dR){
            for(int i = tC; i <= dC; i++){
                System.out.print(m[tR][i] + " ");
            }
        } else if(tC == dC){
            for(int i = tR; i <= dR; i++){
                System.out.print(m[i][tC] + " ");
            }
        } else {
            int curC = tC;
            int curR = tR;
            while (curC != dC){
                System.out.print(m[tR][curC] + " ");
                curC++;
            }
            while (curR != dR){
                System.out.print(m[curR][dC] + " ");
                curR++;
            }
            while (curC  != tC){
                System.out.print(m[dR][curC] + " ");
                curC--;
            }
            while (curR != tR){
                System.out.print(m[curR][tC] + " ");
                curR--;
            }
        }
    }

}
