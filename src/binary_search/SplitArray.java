package binary_search;

import java.awt.color.ICC_ColorSpace;

/**
 * @author 马祥
 * @Package binary_search
 * @date 2023-02-08 20:53
 * @Copyright © 2024未来可期
 * 410、分割数组最大值
 */
public class SplitArray {
    public int splitArray(int[] nums, int k) {
        //分析：本题仔细对比货运问题其实就是一样的，完全可以套用货运问题的解法
        //2、确定左右边界，并明确所求为左边界
        int left = 0,right = 1;
        for (int n : nums) {
            left = Math.max(left, n);
            right += n;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(nums,mid) <= k){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    //1、判断x f(x) target分别是什么，并写出f(x)的函数
    int f(int[] nums, int x){
        int p = 0;
        int cap = x;
        for(int i = 0; i < nums.length;){
            while(i < nums.length){
                if (cap < nums[i]) break;
                else cap -= nums[i];
                i++;
            }
            p++;
        }
        return  p;
    }
}
