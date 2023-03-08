package queue_and_stack;

/**
 * @author 马祥
 * @Package queue_and_stack
 * @date 2023-03-06 17:23
 * @Copyright © 2024未来可期
 * 402. 移掉 K 位数字
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，
 * 移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 */

import java.util.Stack;

/**
 * 思路：是原来的数形成一个单调递增的数字即可实现删除后得到最小的数
 * 这里就用到了单调栈的思想，然后要避免0出现再开头的情况
 * 如果K的次数已经用完，此时栈中是单调递增的，则删除第一个元素（栈顶元素）即可
 */
public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()){
            while (!stack.isEmpty() && c < stack.peek() && k > 0){
                stack.pop();
                k--;
            }
            //避免0出现再开头(即出现0则跳过)
            if (stack.isEmpty() && c == '0'){
                continue;
            }
            stack.push(c);
        }
        //此时栈中元素为单调递增，k没有用完时
        while (!stack.isEmpty() && k > 0){
            stack.pop();
            k--;
        }
        //如果最后没有剩下数字则为0
        if (stack.isEmpty()){
            return "0";
        }
        //结果输出调整
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
