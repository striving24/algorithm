package queue_and_stack;

/**
 * @author 马祥
 * @Package queue_and_stack
 * @date 2023-03-06 14:47
 * @Copyright © 2024未来可期
 * 42、接雨水
 */

/**
 * 此题使用双指针解法，分别记录左边和右边的最高水柱，判断更新答案
 */
public class Trap {
    public int trap(int[] height) {
        int left = 0,right = height.length-1;
        //分别记录左边和右边遍历的最高水柱
        int lMax = 0,rMax = 0;
        int res = 0;
        while (left < right) {
            lMax = Math.max(lMax,height[left]);
            rMax = Math.max(rMax,height[right]);

            //res = Math.min(lMax,rMax)-height[i]
            if (lMax < rMax){
                res += lMax-height[left];
                left++;
            }else {
                res += rMax-height[right];
                right--;
            }
        }
        return res;
    }
}
