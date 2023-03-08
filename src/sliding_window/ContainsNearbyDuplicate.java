package sliding_window;

/**
 * @author 马祥
 * @Package sliding_window
 * @date 2023-02-16 21:22
 * @Copyright © 2024未来可期
 * 219、存在重复元素
 */

import java.util.HashSet;

/**
 * 思路：将窗口视为左右指针，right-left 即为 abs(i-j)
 * 回归三个问题:
 * 1、j-i 小于K时，窗口扩大
 * 2、j-i 大于等于K时，缩小窗口
 * 3、j-i 时，判断窗口中是否存在重复元素，存在则返回true
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //定义一个HashSet,来记录窗口中是否出现重复的元素
        HashSet<Integer> set = new HashSet<>();
        int left = 0,right = 0;
        while (right < nums.length){
            //扩大窗口
            if (set.contains(nums[right])){
                return true;
            }
            set.add(nums[right]);
            right++;

            while (right - left > k){
                set.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}
