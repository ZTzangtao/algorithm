package own_test;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /**
     * https://leetcode.cn/problems/two-sum/
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 3}, 6)));

    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tmp = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            if(tmp.containsKey(target - nums[i])){
                return new int[]{i, tmp.get(target-nums[i])};
            }
            tmp.put(nums[i],i);
        }
        return null;
    }
}
