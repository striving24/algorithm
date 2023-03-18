package backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 马祥
 * @Package backtrack
 * @date 2023-03-17 11:40
 * @Copyright © 2024未来可期
 * 回溯算法之子集问题
 * 78、子集
 */

public class Subsets {
    //记录结果（所有子集）
    List<List<Integer>> res = new LinkedList<>();
    //记录回溯算法中的路径
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return res;
    }

    //回溯算法核心框架,遍历子集问题的回溯树
    void backtrack(int[] nums,int start){
        //前序位置，因为每一个节点的值都是子集
        res.add(new LinkedList<>(track));
        //框架模板
        for (int i = start; i < nums.length; i++) {
            //做选择
            track.addLast(nums[i]);
            //递归进入下一个
            backtrack(nums, i+1);
            //回溯，撤销选择
            track.pollLast();
        }
    }
}
