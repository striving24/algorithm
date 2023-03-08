package queue_and_stack;

/**
 * @author 马祥
 * @Package queue_and_stack
 * @date 2023-03-08 10:33
 * @Copyright © 2024未来可期
 */

import java.util.TreeMap;

/**
 * 使用自己实现的单调队列复杂度过高导致超时；采用已经有的数据结构可保证有序的且得到最值
 * treeMap提供了获取第一个元素和最后一个元素的函数，
 * 也就能在 O(1)的时间内获取滑动窗口内最小值和最大值。
 * 同时在增删后持续维护有序结构
 */
public class LongestSubarray1 {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0,right = 0;
        int res = 0;
        while (right < nums.length){
            //扩大窗口
            map.put(nums[right],map.getOrDefault(nums[right],0) + 1);
            //缩小窗口
            while (map.lastKey() - map.firstKey() > limit){
                map.put(nums[left],map.getOrDefault(nums[left],0) - 1);
                if (map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            res = Math.max(res,right-left+1);
            right++;
        }
        return res;
    }
}
