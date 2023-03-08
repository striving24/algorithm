package sliding_window;

/**
 * @author 马祥
 * @Package sliding_window
 * @date 2023-02-16 15:45
 * @Copyright © 2024未来可期
 * 1658、将X减到0的最小操作数
 */

import javax.swing.*;

/**
 * 根据题意按照滑动窗口的思想变式为：
 * 在nums数组中寻找和为sum[nums]-k的最大子数组
 */
public class MinOperations {
    public int minOperations(int[] nums, int x) {
        //先得到目标数target
        int n = nums.length, sum =0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int target = sum - x;

        //左右指针，思考问题什么时候开始向右扩大窗口
        int left = 0,right = 0;
        //记录窗口内的和
        int window = 0;
        //记录结果
        int res = Integer.MIN_VALUE;
        //开始执行滑动窗口框架
        while (right < n){
            //扩大窗口
            window += nums[right];
            right++;
            //什么时候缩小窗口
            while (window > target && left < right){
                window -= nums[left];
                left++;
            }
            //寻找目标子数组
            if (window == target){
                res = Math.max(res,right - left);
            }
        }
        return res == Integer.MIN_VALUE ? -1 : n-res;
    }
}
