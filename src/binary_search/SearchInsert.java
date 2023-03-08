package binary_search;

/**
 * @author 马祥
 * @Package binary_search
 * @date 2023-02-07 0:34
 * @Copyright © 2024未来可期
 * 35、搜索插入位置
 */

/**
 * 考察搜索左侧边界的二分算法的细节理解，前文 二分搜索详解 着重讲了数组中存在目标元素重复的情况，没仔细讲目标元素不存在的情况。
 * 当目标元素 target 不存在数组 nums 中时，搜索左侧边界的二分搜索的返回值可以做以下几种解读：
 * 1、返回的这个值是 nums 中大于等于 target 的最小元素索引。
 * 2、返回的这个值是 target 应该插入在 nums 中的索引位置。
 * 3、返回的这个值是 nums 中小于 target 的元素个数。
 * 比如在有序数组 nums = [2,3,5,7] 中搜索 target = 4，搜索左边界的二分算法会返回 2，你带入上面的说法，都是对的。
 * 所以以上三种解读都是等价的，可以根据具体题目场景灵活运用，显然这里我们需要的是第二种。
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        //相当于搜索左侧边界的二分查找
        if (nums.length == 0) return -1;
        int left = 0,right = nums.length - 1;//注意
        while (left < right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid+1;
            }
        }
        return left;
    }
}
