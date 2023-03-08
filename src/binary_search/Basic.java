package binary_search;

/**
 * @author 马祥
 * @Package binary_search
 * @date 2023-02-06 20:46
 * @Copyright © 2024未来可期
 * 二分查找
 */

public class Basic {
    public int binarySearch1(int[] nums, int target){
        //写法一：[left,right]左闭右闭区间
        int left = 0;
        int right = nums.length - 1;//注意地方

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearch2(int[] nums, int target){
        //写法2：[left,right)左闭右开区间
        int left = 0;
        int right = nums.length;//注意地方

        while (left < right) {//注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target){
                left = mid+1;
            }
            else if(nums[mid] > target){
                right = mid;
            }
        }
        return -1;
    }

    //寻找左侧边界的二分搜索：eg:[1 2 2 2 5]
    public int binarySearch3(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    //寻找右侧边界的二分搜索
    public int binarySearch4(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                left = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }
}
