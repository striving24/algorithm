package array;

/**
 * @author 马祥
 * @Package array
 * @date 2023-02-05 17:23
 * @Copyright © 2024未来可期
 * 27. 移除元素
 */
//分析：题目要求我们将=val的元素删除，返回原地修改后数组的长度，依旧使用快慢指针
//快指针遇到val就直接跳过，继续遍历，没遇到就赋值给慢指针即可
//代码如下：
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
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
}
