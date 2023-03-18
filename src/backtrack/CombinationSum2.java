package backtrack;

import java.awt.color.ICC_ColorSpace;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 马祥
 * @Package backtrack
 * @date 2023-03-18 12:57
 * @Copyright © 2024未来可期
 * 40. 组合总和 II
 */
public class CombinationSum2 {
    //记录结果
    List<List<Integer>> res = new LinkedList<>();
    //记录回溯算法递归中的路径
    LinkedList<Integer> track = new LinkedList<>();
    //记录递归中的路径和
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //先将数字进行排序
        Arrays.sort(candidates);
        backtrack(candidates,0,target);
        return res;
    }

    //回溯算法
    void backtrack(int[] nums,int start,int target){
        // base case 路径和达标则收集结果
        if (sum == target){
            res.add(new LinkedList<>(track));
            return;
        }
        if (sum > target){
            return;
        }
        //回溯算法框架
        for (int i = start; i < nums.length; i++) {
            //先排除一些情况（剪枝）
            if (i > start && nums[i] == nums[i-1]){
                continue;
            }
            //做选择
            track.addLast(nums[i]);
            sum += nums[i];
            //递归进入下一个
            backtrack(nums, i+1, target);
            //回溯，选择撤销
            track.removeLast();
            sum -= nums[i];
        }
    }
}
