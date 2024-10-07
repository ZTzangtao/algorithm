import java.util.HashSet;
import java.util.Set;

/**
 * @Author Tommy
 * @Date 2024/8/19 15:23
 * @Version 1.0
 */
public class test1 {

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     * Example : Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     */
    public static void main(String[] args) {
        String[] strs = {"floswer", "flosw", "flisght"};
        String[] strss = {"flower", "flow", "flight"};
        System.out.println(findLongestCommonPrefix(strs));
        System.out.println(findLongestCommonPrefix(strss));
    }

    private static String findLongestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        int maxLong = Integer.MAX_VALUE;
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            maxLong = Math.min(maxLong, str.length());
        }
        for (int i = 0; i < maxLong - 1; i++) {
            Set<String> set = new HashSet<>();
            for (String str : strs) {
                String s = String.valueOf(str.toCharArray()[i]);
                set.add(s);
            }
            if (set.size() == 1) {
                stringBuilder.append(set.stream().iterator().next());
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }


}
