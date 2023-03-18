package backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 马祥
 * @Package backtrack
 * @date 2023-03-18 15:09
 * @Copyright © 2024未来可期
 * 39. 组合总和
 */
public class CombinationSum {
    //记录收集的结果
    List<List<Integer>> res = new LinkedList<>();
    //记录回溯递归中的路径
    LinkedList<Integer> track = new LinkedList<>();
    //记录track中的路径和
    int trackSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return res;
        backtrack(candidates,0,target);
        return res;
    }

    //回溯算法函数
    void backtrack(int[] nums,int start,int target){
        //base case 找到目标和记录结果
        if (trackSum == target){
            res.add(new LinkedList<>(track));
            return;
        }
        //base case 大于目标和则停止遍历
        if (trackSum > target){
            return;
        }
        //回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            //选择
            track.add(nums[i]);
            trackSum += nums[i];
            //递归进入下一个，注意这里需要重复使用
            backtrack(nums, i, target);
            //回溯，撤销选择
            trackSum -= nums[i];
            track.removeLast();
        }
    }
}
