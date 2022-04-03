package ownWriteDemo.interview;

import java.util.Arrays;

/**
 * @Author: Tommy
 * @DATE: 2022/3/13
 */
public class MergeArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {1, 1, 3};
        merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        int cur = 0;
        while (p1 >= 0 || p2 >= 0) {
           if(p1 == -1){
               cur = nums2[p2--];
           }else if(p2 == -1){
               cur = nums1[p1--];
           }else if (nums1[p1] > nums2[p2]){
               cur = nums1[p1--];
           }else {
               cur = nums2[p2--];
           }
            nums1[tail--] = cur;
        }
    }


    public static void merge1(int[] nums1, int m, int[] nums2, int n){
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && p2 >= 0){
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        System.out.println(Arrays.toString(nums1));
        System.arraycopy(nums2,0,nums1,0, p2 + 1);
    }

}
