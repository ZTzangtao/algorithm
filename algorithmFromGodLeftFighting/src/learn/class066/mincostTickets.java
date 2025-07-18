package learn.class066;

import java.util.Arrays;

public class mincostTickets {
    /**
     * https://leetcode.cn/problems/minimum-cost-for-tickets/
     */

    public static int[] duration = {1, 7, 30};

    public static int mincostTickets(int[] days, int[] costs) {
        return f1(days, costs, 0);
    }

    /**
     * 暴力递归
     * @param days
     * @param costs
     * @param i
     * @return
     */
    private static int f1(int[] days, int[] costs, int i) {
        if (i == days.length) {
            // 后续无旅行
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = 0, j = i; k < 3; k++) {
            while (j < days.length && days[i] + duration[k] > days[j]) {
                j++;
            }
            ans = Math.min(ans, costs[k] + f1(days, costs, j));
        }
        return ans;
    }

    public static int mincostTickets2(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
//        for (int i = 0; i < days.length; i++) {
//            dp[i] = Integer.MAX_VALUE;
//        }
        return f2(days, costs, 0, dp);
    }

    private static int f2(int[] days, int[] costs, int i, int[] dp) {
        if (i == days.length) {
            return 0;
        }
        if (dp[i] != Integer.MAX_VALUE) {
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = 0, j = i; k < 3; k++) {
            while (j < days.length && days[i] + duration[k] > days[j]) {
                j++;
            }
            ans = Math.min(ans, costs[k] + f2(days, costs, j, dp));
        }
        dp[i] = ans;
        return ans;
    }

    private static int f3(int[] days, int[] costs) {
        int[] dp = new int[366];
        int n  = days.length;
        Arrays.fill(dp, 0, n + 1, Integer.MAX_VALUE);
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 0, j = i; k < 3; k++) {
                while (j < days.length && days[i] + duration[k] > days[j]) {
                    j++;
                }
               dp[i] = Math.min(dp[i], costs[k] + dp[j]);
            }
        }
        return dp[0];
    }


}
