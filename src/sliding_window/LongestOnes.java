package sliding_window;

/**
 * @author 马祥
 * @Package sliding_window
 * @date 2023-02-16 17:28
 * @Copyright © 2024未来可期
 * 1004、做大连续1的个数
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 */

/**
 * 思路：题意转换为：找到一个最长的字数组，该子数组内最多包含K个0
 * 回答框架的三个问题：
 * 1、子数组内的0小于K时，扩大窗口，增加0的个数
 * 2、子数组内的0大于K时，缩小窗口，减少0的个数
 * 3、子数组内0小于k时，都是合法的子数组，不断更新答案即可
 */
public class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0,right = 0;
        int window = 0;//记录窗口里的0数量
        int res  =0;
        while (right < n){
            if (nums[right] == 0){
                window++;
            }
            while (window > k){
                if (nums[left++] == 0){
                    window--;
                }
            }
            res = Math.max(res,right-left+1);
            right++;
        }
        return res;
    }

    /**
     * 方式二：模板框架（dong）
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes1(int[] nums, int k) {
        int n = nums.length;
        int left = 0,right = 0;
        int window = 0;//记录窗口里的1数量
        int res  =0;
        while (right < n){
            if (nums[right] == 1){
                window++;
            }
            right++;
            while (right - left -window > k){
                if (nums[left] == 1){
                    window--;
                }
                left++;
            }
            //此时的子数组一定是和合法的
            res = Math.max(res,right-left);
        }
        return res;
    }
}
