package queue_and_stack;

/**
 * @author 马祥
 * @Package queue_and_stack
 * @date 2023-03-06 15:54
 * @Copyright © 2024未来可期
 * 1944. 队列中可以看到的人数
 */

import java.util.Stack;

/**
 * 思路：翻译一下就是求该元素到下一个更大元素之间存在多少元素
 * 具体看代码
 */
public class CanSeePersonsCount {
    public int[] canSeePersonsCount(int[] heights) {
        int len = heights.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len-1; i >=0; i--){
            //记录右边比自己矮的人
            int count = 0;
            //单调栈模板
            while (!stack.isEmpty() && heights[i] > stack.peek()){
                stack.pop();
                count++;
            }
            //注意可以看到人：比自己矮的和下一个更高的
            res[i] = stack.isEmpty() ? count : count + 1;
            stack.push(heights[i]);
        }
        return res;
    }
}
