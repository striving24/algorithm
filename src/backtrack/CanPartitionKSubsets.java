package backtrack;

import java.util.Arrays;
import java.util.jar.JarEntry;

/**
 * @author 马祥
 * @Package backtrack
 * @date 2023-03-17 10:37
 * @Copyright © 2024未来可期
 * 回溯算法经典问题--集合划分
 */
public class CanPartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        //先排除一些基本情况
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) return false;
        int target = sum / k;
        //排序优化(降序)
        Arrays.sort(nums);
        int l = 0,r = nums.length-1;
        while (l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return backtrack(nums,0,new int[k],k,target);
    }

    //回溯算法框架
    boolean backtrack(int[] nums,int index,int[] bucket,int k,int target){
        //结束条件（框架中的收集结果的时）优化
        if (index == nums.length) return true;//即每个球都放入了正确的桶中
        //开始遍历每个桶
        for (int i = 0; i < k; i++) {
            //优化二：
            if (i > 0 && bucket[i] == bucket[i-1]) continue;
            //剪枝
            if (bucket[i] + nums[index] > target) continue;
            //放入（即框架中的选择）
            bucket[i] += nums[index];
            //递归判断下一个index的球
            if (backtrack(nums, index+1, bucket, k, target)) return true;
            //回溯，撤销选择
            bucket[i] -= nums[index];
        }
        return false;
    }
}
