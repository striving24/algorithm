package queue_and_stack;

/**
 * @author 马祥
 * @Package queue_and_stack
 * @date 2023-03-08 9:41
 * @Copyright © 2024未来可期
 * 1438. 绝对差不超过限制的最长连续子数组
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit
 * 请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * 如果不存在满足条件的子数组，则返回 0
 */

import sun.security.pkcs11.wrapper.CK_AES_CTR_PARAMS;

import java.util.LinkedList;

/**
 * 显而易见，是一道滑动窗口的题目，但是此题多了一个限制条件，即要求窗口中的任意两个元素差要小于limit
 * 等价于窗口中的max-min >= limit
 * (即窗口扩大和缩小的条件：当max -min < limit时，扩大窗口，大于等于时就缩小窗口，更新答案)
 * 所以需要在更新窗口的同时的得到窗口中的最值来查找符合条件的结果
 * 单调队列就可实现这一功能：获取队列中的最值
 */
public class LongestSubarray {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0,right = 0;
        int windowsize = 0,res = 0;
        MonotonicQueue window = new MonotonicQueue();
        //滑动窗口模板
        while (right < nums.length){
            //扩大窗口，并更新窗口最值
            window.push(nums[right]);
            right++;
            windowsize++;
            while (window.max()-window.min() >= limit){
                //缩小窗口，更新窗口最值
                window.pop(left);
                left++;
                windowsize--;
            }
            //窗口收缩完毕后才更新答案
            res = Math.max(res,windowsize);
        }
        return res;
    }
    //单调队列的通用实现，高校维护最大值和最小值
    class MonotonicQueue{
        //单调递增队列（尾部到头部），头部为最大值
        LinkedList<Integer> maxq = new LinkedList<>();
        //单调递减队列（...）,头部为最小值
        LinkedList<Integer> minq = new LinkedList<>();
        public void push(int n){
            //维护maxp ,小于当前元素的删除
            while (!maxq.isEmpty() && maxq.getLast() < n){
                maxq.pollLast();
            }
            maxq.addLast(n);
            //维护minq,大于当前元素的删除
            while (!minq.isEmpty() && minq.getLast() > n){
                maxq.pollLast();
            }
            minq.addLast(n);
        }
        //最大值
        public int max(){
            return maxq.getFirst();
        }
        //最小值
        public int min(){
            return minq.getFirst();
        }
        //删除指定元素
        public void pop(int n){
            if (n == maxq.getFirst()){
                maxq.pollFirst();
            }
            if (n == minq.getFirst()){
                minq.pollFirst();
            }
        }
    }
}
