package queue_and_stack;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author 马祥
 * @Package queue_and_stack
 * @date 2023-03-07 11:59
 * @Copyright © 2024未来可期
 * 239、滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k-1){
                //先填满前K-1个数据（即剩一个数据）
                window.push(nums[i]);
            }else {
                //窗口向前滑动，即添加窗口的最后一个数据
                window.push(nums[i]);
                //记录此时窗口的最大值
                res.add(window.max());
                //删除旧数据
                window.pop(nums[i-k+1]);//队尾
            }
        }
        //结果输出调整
        int[] arr = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            arr[i] = res.get(i);
        }
        return arr;

    }
    //定义一个单调队列
    class MonotonicQueue{
        private LinkedList<Integer> maxqueue = new LinkedList<>();
        //队尾添加数据，维护单调递增数据
        public void push(int n){
            while (!maxqueue.isEmpty() && maxqueue.getLast() < n){
                maxqueue.pollLast();
            }
            maxqueue.addLast(n);
        }
        public int max(){
            return maxqueue.getFirst();
        }
        public void pop(int n){
            if (n == maxqueue.getFirst()){
                maxqueue.pollFirst();
            }
        }
    }
}
