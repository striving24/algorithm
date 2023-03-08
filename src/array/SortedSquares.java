package array;

/**
 * @author 马祥
 * @Package array
 * @date 2023-02-14 21:33
 * @Copyright © 2024未来可期
 * 977、有序数组的平方
 */
public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        //因为有负数，暴力一遍后再进行排序操作复杂度达到nlogn
        //可以直接使用双指针首位比骄并按要求排列即可

        //左右指针
        int n = nums.length;
        int left = 0,right = n - 1;
        //结果数组
        int[] res = new int[n];
        int p = n-1;
        while (left <= right){
            if (Math.abs(nums[left]) > Math.abs(nums[right])){
                res[p] = nums[left] * nums[left];
                left++;
            }else{
                res[p] = nums[right] * nums[right];
                right--;
            }
            p--;
        }
        return res;
    }
}
