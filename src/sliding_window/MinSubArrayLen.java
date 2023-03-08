package sliding_window;

/**
 * @author 马祥
 * @Package sliding_window
 * @date 2023-02-14 22:03
 * @Copyright © 2024未来可期
 * 209、长度最小子数组
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;//左窗口
        //因为要求长度最小，先赋值为大值用于更新结果
        int result = Integer.MAX_VALUE;//
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum +=nums[right];
            while (sum >= target){
                result = Math.min(result,right-left+1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
