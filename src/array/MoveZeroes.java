package array;

/**
 * @author 马祥
 * @Package array
 * @date 2023-02-05 17:41
 * @Copyright © 2024未来可期
 * 283.移动0
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        //分析：题目叫我们找到0，并将其移动到数组末尾，
        // 那么根据上一题可以这样考虑：先删除0，最后在slow数组末尾补上相应个数的0即可：

        //去掉nums中的0，返回不含0的数组长度
        int len = removeElement(nums,0);
        //往数组后补充0（nums[i]后赋值为0）
        for (int i = len; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
    static int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] num = {1,0,3,45,0,12,6};
        new MoveZeroes().moveZeroes(num);
    }
}
