package ownWriteDemo.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Tommy
 * @DATE: 2022/3/23
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] test = new int[][] {{1,3},{2,6},{8,10},{15,18}};
        test = mergeIntervals(test);
        for(int i = 0; i < test.length; i++){
            for (int j = 0; j < test[i].length; j++){
                System.out.println(test[i][j] + ",");
            }
        }
    }

    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return null;
        }
        //先对原二维数组按第一个数排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        int left = 0;
        int right = 0;
        while (right < intervals.length){
            int less = intervals[left][0];
            int more = intervals[right][1];
            while (right < intervals.length && intervals[right][0] <= more){
                more = Math.max(intervals[right][1], more);
                right++;
            }
            list.add(new int[]{less, more});
            left = right;
        }
        //将数组类型的集合转成二维数组
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }


}
