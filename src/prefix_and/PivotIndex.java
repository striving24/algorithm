package prefix_and;

/**
 * @author 马祥
 * @Package prefix_and
 * @date 2023-02-11 20:13
 * @Copyright © 2024未来可期
 * 724、寻找中心数组的下标
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        //1、构造出前缀和
        int[] preNums = new int[n+1];
        preNums[0] = 0;
        for (int i = 1; i <= n; i++) {
            preNums[i] = preNums[i-1] + nums[i-1];
        }
        //2、根据前缀和计算出左右两边的数组和，并比较
        for (int i = 1; i < preNums.length; i++) {
            // nums[i-1]的左右侧
            int left = preNums[i-1] - preNums[0];
            int right = preNums[n] - preNums[i];
            if (left == right) return i-1;
        }
        return  -1;
    }
}
