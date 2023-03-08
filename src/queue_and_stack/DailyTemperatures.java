package queue_and_stack;

/**
 * @author 马祥
 * @Package queue_and_stack
 * @date 2023-03-06 11:24
 * @Copyright © 2024未来可期
 * 739、每日温度
 */

import java.util.Stack;

/**
 * 单调栈的使用：这里根据题意，存储的是元素的下标
 * 如果当前遍历的元素大于栈顶元素，即栈顶右边第一个大于他的数即为当前遍历元素
 * 否则即继续压入栈中
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < len; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }
}
