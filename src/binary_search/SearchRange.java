package binary_search;

/**
 * @author 马祥
 * @Package binary_search
 * @date 2023-02-07 23:04
 * @Copyright © 2024未来可期
 * 34、在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    /**
     * 分析题目可知：刚好是总结的寻找左边界和有边界的二分搜索
     * 直接分别使用左右两个模板找到两个返回即可
     */
    public int[] searchRange(int[] nums, int target) {
        return new int[]{leftBoundary(nums, target), rightBoundary(nums, target)};
    }

    private int rightBoundary(int[] nums, int target) {
        int left = 0,right = nums.length-1;//注意
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        // 这里改为检查 right 越界的情况，见下图
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    private int leftBoundary(int[] nums, int target) {
        int left = 0,right = nums.length-1;//注意
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

}
