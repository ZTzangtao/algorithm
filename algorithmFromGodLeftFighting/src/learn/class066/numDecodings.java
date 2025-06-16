package learn.class066;

public class numDecodings {
    /**
     * https://leetcode.cn/problems/decode-ways/
     */
    public static int numDecodings(String s) {
        return f1(s.toCharArray(), 0);
    }

    /**
     * 暴力递归
     *
     * @param s
     * @param i
     * @return
     */
    private static int f1(char[] s, int i) {
        if (i == s.length) {
            return 1;
        }
        int ans;
        if (s[i] == '0') {
            ans = 0;
        } else {
            ans = f1(s, i + 1);
            if (i + 1 < s.length && ((s[i] - '0') * 10 + s[i + 1] - '0') <= 26) {
                ans += f1(s, i + 2);
            }
        }
        return ans;
    }


}
