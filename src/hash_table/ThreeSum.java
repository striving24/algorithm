package hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 马祥
 * @Package hash_table
 * @date 2023-03-03 20:52
 * @Copyright © 2024未来可期
 * 15、三数之和
 */

/**
 * 思路：本题使用哈希表不容易解决，因为此题要求是不重复的结果，用哈希表不容易去重
 * 双指针解法较好，前提先对数组进行排序 一个遍历指针， 两个左右指针根据sum的结果过进行指针的移动
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums){
        //结果数组
        ArrayList<List<Integer>> res = new ArrayList<>();
        //1、先对数组进行排序
        Arrays.sort(nums);
        //2、开始遍历求和
        for(int i = 0; i < nums.length; i++){
            //如果第一个数就大于0则不符合条件
            if (nums[i] > 0){
                return res;
            }
            //继续遍历求和,去重
            else if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1,right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                //和较大，右指针左移
                if (sum > 0) {
                    right--;
                }
                //和较小。左指针右移
                if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //在对后两个数进行去重处理
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    right--;
                    left++;
                }
            }
        }
        return res;
    }
}

