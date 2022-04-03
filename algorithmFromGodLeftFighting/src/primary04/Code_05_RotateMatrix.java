package primary04;

/**
 * @Author: Tommy
 * @DATE: 2022/2/12
 */
public class Code_05_RotateMatrix {


    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC){
        if(tR == dR){
            for(int i = tC; i <= dC; i++){
                System.out.print(m[tR][i] + " ");
            }
        }else if(tC == dC){
            for(int i = tR; i <= dR; i++){
                System.out.print(m[i][tC] + " ");
            }
        }else {
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
