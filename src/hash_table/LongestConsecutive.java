package hash_table;

import java.util.HashSet;

/**
 * @author 马祥
 * @Package hash_table
 * @date 2023-02-27 9:48
 * @Copyright © 2024未来可期
 * 128、最长连续序列
 */
public class LongestConsecutive {
    /**
     * 暴力 ：
     * 遍历并查找下一个元素是否存在
     * @param nums
     * @return
     */
    public int longestConsecutive1(int[] nums) {
        int res = 0;
        int curLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            curLen = 1;
            //判断后续是否存在，寻找连续序列
            while (contains(nums, curNum + 1)) {
                curNum++;
                curLen++;
            }
        }
        return Math.max(res, curLen);
    }
    //定义一个方法，判断一个数是否在数组中
    public boolean contains(int[] nums ,int k){
        for (int num : nums){
            if (num == k) return true;
        }
        return false;
    }

    /**
     * 方法二：哈希表保存查找
     * 分析：将元素存放到哈希表中，然后找到序列的第一个数字，一次递增查找即可
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums){
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        for (int num : set){
            if (set.contains(num-1)){
                //不是序列的第一个，跳过
                continue;
            }
            //开始查找，更新长度
            int curNum = num;
            int curLen = 1;
            while (set.contains(curNum+1)){
                curNum+=1;
                curLen+=1;
            }
            res = Math.max(res,curLen);
        }
        return res;
    }
}
