package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author Tommy
 * @Date 2023/7/22 17:24
 * @Version 1.0
 */
public class Lc1223RemoveSubfolders {

    //tips1 <= folder.length <= 4 * 104
        //2 <= folder[i].length <= 100
        //folder[i] 只包含小写字母和 '/'
        //folder[i] 总是以字符 '/' 起始
        //folder 每个元素都是 唯一 的
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Arrays.sort(folder);
        res.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            int pre = res.get(res.size() - 1).length();
            if (!(pre < folder[i].length() && folder[i].substring(0, pre).equals(res.get(res.size() - 1)) && folder[i].charAt(pre) == '/' )) {
                res.add(folder[i]);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        List<String> list = removeSubfolders(new String[] {"/a", "/a/b", "/a/b/c"});
        System.out.println(Arrays.toString(new List[]{list}));
    }

}
