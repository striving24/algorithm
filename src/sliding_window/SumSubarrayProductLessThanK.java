package sliding_window;

/**
 * @author 马祥
 * @Package sliding_window
 * @date 2023-02-16 16:12
 * @Copyright © 2024未来可期
 * 713、乘积小于K的子数组
 */

import java.lang.annotation.Target;

/**
 * 首先明白滑动窗口的一个基本前提：元素进出窗口的反馈腰围单调性的
 * 一样的回答三个问题：
 * 1、窗口内元素乘积小于K，扩大窗口，让积更大
 * 2、窗口内元素乘积大于K，缩小窗口，让积变小
 * 3、窗口内元素乘积小于K时，窗口内的子数组都是合法子数组
 */
public class SumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0,right = 0;
        //窗口内元素乘积
        int window = 1;
        //结果
        int res = 0;
        //开始套用框架
        while (right < nums.length){
            //扩大窗口
            window *= nums[right];
            right++;

            //缩小窗口
            while(window >= k && left < right){
                window /= nums[left];
                left++;
            }
            //现在窗口里的就是合法的，考虑如何计算此时窗口里的子数组个数
            //eg:left = 1,right = 4 ，即[1,4)就有[1] [1,2] [1,2,3]三种
            //所以res = right - left;
            res += right - left;
        }
        return res;
    }
}
