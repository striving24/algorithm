package hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 马祥
 * @Package hash_table
 * @date 2023-03-03 21:20
 * @Copyright © 2024未来可期
 * 18、四数之和
 */

/**
 * 思路和三数之和一样，此题多一层循环，解题方法和三数之和一样
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++){
            //去重及第一个就大于target的处理操作
            if (nums[i] > target){
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;//对nums[i]去重
            }
            for (int j = i + 1; j < nums.length; j++) {
                //对nums[j]去重
                if (j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int left = j + 1,right = nums.length-1;
                while (right > left){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target){
                        right--;
                    } else if (sum < target) {
                        left--;
                    }
                    else {
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums
                        [right]));
                        //对后两个数字进行去重操作
                        while (right > left && nums[right] == nums[right-1]){right--;}
                        while (right > left && nums[left] == nums[left+1]){left++;}

                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
