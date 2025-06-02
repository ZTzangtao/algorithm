package class98;

import java.io.*;

/**
 * 快速幂、矩阵快速幂
 */
public class Code01_QuickPower {

    // test链接 https://www.luogu.com.cn/problem/P1226

    public static long a, b, p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        a = (int)in.nval;
        in.nextToken();
        b = (int)in.nval;
        in.nextToken();
        p = (int)in.nval;
        out.println(a + "^" + b + " mod " + p + "=" + power());
        out.flush();
        out.close();
        br.close();
    }

    public static int power() {
        // a的b次方
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = (ans * a) % p;
            }
            a = (a * a) % p;
            b >>= 1;
        }
        return (int) ans;
    }
}
