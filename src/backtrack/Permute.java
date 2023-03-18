package backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 马祥
 * @Package backtrack
 * @date 2023-03-16 10:23
 * @Copyright © 2024未来可期
 * 全排列
 */
public class Permute {
    //记录结果
    List<List<Integer>> res = new LinkedList<>();
    //主函数，输出给定数组的全部排列
    public List<List<Integer>> permute(int[] nums) {
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        //路径中的元素标记为true,避免重复使用
        boolean[] used = new boolean[nums.length];
        backTrack(nums,track,used);
        return res;
    }

    //回溯算法框架
    //1、路径：记录在track中
    //2、选择列表 ：nums中不存在于track(记录路径的)中的元素（used[i] == false的元素）
    //3、结束条件 ；nums中的元素全部出现在了track中
    void backTrack(int[] nums,LinkedList<Integer> track,boolean[] used){
        //出发结束条件，收集结果
        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        //开始遍历操作
        for (int i = 0; i < nums.length; i++) {
            //排除不符合条件的情况
            if (used[i]){
                continue;//之前已经被选择过（已经在track中），跳过
            }
            //合法了，做选择
            track.add(nums[i]);
            used[i] = true;//当前做了选择，将其赋值为true
            //递归进入下一层循环
            backTrack(nums, track, used);
            //回溯，撤销选择
            track.pollLast();
            used[i] = false;
        }
    }
}
