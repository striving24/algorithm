package queue_and_stack;

/**
 * @author 马祥
 * @Package queue_and_stack
 * @date 2023-03-06 16:18
 * @Copyright © 2024未来可期
 * 1475. 商品折扣后的最终价格
 */

import java.util.Stack;

/**
 * 思路：此题可以翻译为寻找下一个更小的数，即为单调栈的另一个变式，可以先定义方法找到数组元素的下一个更小元素
 * 若没有则赋值为-1，然后再次两个数组，看i位置上的数，得到的数组中不为-1则减去该数即为最终价格，是-1则原价
 */
public class FinalPrices {
    public int[] finalPrices(int[] prices) {
        int l = prices.length;
        int[] res = new int[l];
        int[] nextNum = nextSmallerNum(prices);
        for (int i = 0; i < l; i++) {
            //只要nextNum[i]不为-1，即为减价数量
            if (nextNum[i] != -1){
                res[i] = prices[i]-nextNum[i];
            }else {
                res[i] = prices[i];
            }
        }
        return res;
    }
    //定义方法：寻找下一个更小的数，没有返回-1
    int[] nextSmallerNum(int[] nums) {
        int len = nums.length;
        int[] num = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len-1; i >= 0 ; i--) {
            while (!stack.isEmpty() && num[i] < stack.peek()) {
                stack.pop();
            }
            num[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return num;
    }
}
