package prefix_and;

import java.util.HashMap;

/**
 * @author 马祥
 * @Package prefix_and
 * @date 2023-02-11 21:59
 * @Copyright © 2024未来可期
 * 525、连续数组
 */
public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        //利用前缀和思想，因为nums数组是只有0、1，我们把0看成-1，即寻找和为 0的最长子数组
        //再把前缀和用哈希表保存记录好索引，在遍历寻找key0的value最大值即可

        //1、构造前缀和
        int n = nums.length;
        int[] preSum = new int[n+1];
        preSum[0] = nums[0];
        for (int i = 0; i < n; i++) {
            preSum[i+1] = preSum[i] + (nums[i] == 0 ? -1:1);
        }

        //2、哈希表保存信息
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < preSum.length; i++) {
            if (!map.containsKey(preSum[i])){
                //前缀和第一次出现，存入
                map.put(preSum[i],i);
            }else{
                //已经出现，找到目标数组，更新最大值
                res = Math.max(res, i-map.get(preSum[i]));
            }
        }
        return res;
    }
}
