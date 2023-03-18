package backtrack;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 马祥
 * @Package backtrack
 * @date 2023-03-18 13:21
 * @Copyright © 2024未来可期
 * 47. 全排列 II
 */
public class PermuteUnique {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    Boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return res;
        }
        used = new Boolean[len];
        //先排序
        Arrays.sort(nums);
        backtrack(nums,0);
        return res;
    }

    //回溯算法函数
    void backtrack(int[] nums,int start){
        //收集结果的时候
        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (used[i]) continue;
            // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            ///选择
            track.add(nums[i]);
            used[i] = true;
            //递归下一次
            backtrack(nums,i+1);
            //回溯。选择撤销
            track.removeLast();
            used[i] = false;
        }
    }
}
