package queue_and_stack;

/**
 * @author 马祥
 * @Package queue_and_stack
 * @date 2023-03-06 12:44
 * @Copyright © 2024未来可期
 * 503、下一个更大元素
 */

import java.util.Arrays;
import java.util.Stack;

/**
 * 思路：此题升级为环形数组，可以加将容量扩大2倍，即可实现环形
 * 通过取余数来确定数组索引
 */
public class NextGreaterElements1 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length <= 1){
            return new int[]{-1};
        }
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * len; i++){
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]){
                res[stack.peek()] = nums[i%len];
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
