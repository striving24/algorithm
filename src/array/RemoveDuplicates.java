package array;

/**
 * @author 马祥
 * @Package array
 * @date 2023-02-05 16:53
 * @Copyright © 2024未来可期
 */
/**
26. 删除有序数组中的重复项
给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分
更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
将最终结果插入 nums 的前 k 个位置后返回 k 。*/

//快慢指针
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        /**
         * 思路分析：如果不是原地修改的话，我们直接 new 一个int[]数组，把去重之后的元素放进这个新数组中，
         * 然后返回这个新数组即可。
         * 但是现在题目让你原地删除，不允许 new 新数组，只能在原数组上操作，然后返回一个长度，
         * 这样就可以通过返回的长度和原始数组得到我们去重后的元素有哪些了。
         * 由于数组已经排序，所以重复的元素一定连在一起，找出它们并不难。
         * 但如果毎找到一个重复元素就立即原地删除它，由于数组中删除元素涉及数据搬移，整个时间复杂度是会达到O(N^2)。
         * 高效解决这道题就要用到快慢指针技巧：
         * 我们让慢指针slow走在后面，快指针fast走在前面探路，找到一个不重复的元素就赋值给slow并让slow前进一步。
         * 这样，就保证了nums[0..slow]都是无重复的元素，
         * 当fast指针遍历完整个数组nums后，nums[0..slow]就是整个数组去重之后的结果
         */
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]){
                slow++;
                //维护nums[slow]不重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
