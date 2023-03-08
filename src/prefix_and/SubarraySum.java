package prefix_and;

import java.util.HashMap;

/**
 * @author 马祥
 * @Package prefix_and
 * @date 2023-02-11 23:19
 * @Copyright © 2024未来可期
 * 560、和为K的子数组
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        //本题和前两题的最大区别在于，需要在维护 preSum 前缀和数组的同时动态维护 count 映射，
        // 而不能等到 preSum 计算完成后再处理 count，因为 count[need] 应该维护 preSum[0..i] 中值为 need 的元素个数。

        int n = nums.length;
        int[] preSum = new int[n+1];
        preSum[0] = 0;
        //用哈希表记录信息，便于查找到目标元素
        HashMap<Integer, Integer> count = new HashMap<>();
        count.put(0,1);

        int res = 0;//记录结果
        for (int i = 1; i <=n; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
            //目标前缀和need
            int need = preSum[i] - k;
            if (count.containsKey(need)) {
                res += count.get(need);
            }
            if (!count.containsKey(preSum[i])){
                count.put(preSum[i],1);
            }else{
                count.put(preSum[i],count.get(preSum[i])+1);
            }
        }
        return res;
    }
}
