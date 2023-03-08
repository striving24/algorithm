package prefix_and;

import java.util.HashMap;

/**
 * @author 马祥
 * @Package prefix_and
 * @date 2023-02-11 22:43
 * @Copyright © 2024未来可期
 * 523、连续的字数组之和
 */
public class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        //也是利用前缀和，关键点在于：preSum[j]-preSum[i]的置和取余数==0即可

        //前缀和
        int n = nums.length;
        int[] preSum = new int[n+1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }

        //用哈希表保存前缀和信息，key:preSum[i]%k   value:i(索引)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {
            //记录余数
            int val = preSum[i] % k;
            if(!map.containsKey(val)){
                map.put(val,i);
            }
            //存在了则不做任何操作，此步骤只是为了记录余数和索引
        }

        //再次从第二个遍历，寻找符合条件的元素即可
        for (int i = 1; i < preSum.length; i++) {
            int need = preSum[i] % k;
            if(map.containsKey(need)){
                if (i-map.get(need) >= 2){
                    return true;
                }
            }
        }
        return false;
    }
}
