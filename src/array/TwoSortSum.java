package array;

/**
 * @author 马祥
 * @Package array
 * @date 2023-02-05 18:08
 * @Copyright © 2024未来可期
 */
public class TwoSortSum {
    private int[] twoSum(int[] nums, int target) {
        //左右指针做法
        int left = 0,right = nums.length-1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target){
                return new int[]{left,right};
            } else if (sum > target) {
                //小一点
                right--;
            } else if (sum < target) {
                //大一点
                left++;
            }
        }
        return new int[0];
    }
}
