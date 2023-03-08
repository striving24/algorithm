package prefix_and;

/**
 * @author 马祥
 * @Package prefix_and
 * @date 2023-02-09 16:29
 * @Copyright © 2024未来可期
 * 303、区域和检索-数组不可变
 */
public class NumArray {
    //标准的前缀和数组题目，要求[i,j]之间的和，可以直接暴力暴力复杂度为N
    //但是使用前缀和复杂度只需要1即可：构造出数组的前缀和 [i,j]的和即为前缀和[j]-前缀和[i](注意细节)

    //前缀和数组
    private int[] preSum;
    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right+1] - preSum[left];
    }

}
