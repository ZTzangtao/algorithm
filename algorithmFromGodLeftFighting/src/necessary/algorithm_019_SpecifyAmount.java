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

        }

    }

}
