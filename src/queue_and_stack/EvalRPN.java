package queue_and_stack;

/**
 * @author 马祥
 * @Package queue_and_stack
 * @date 2023-03-05 13:53
 * @Copyright © 2024未来可期
 * 150、逆波兰表达式
 */

import sun.awt.image.IntegerInterleavedRaster;

import java.util.Stack;

/**
 * 逆波兰表达式的定义就是为了方便计算机使用栈来实现计算功能的
 * 思路：遍历字符，如果遇到数字就入栈，如果遇到符号就将栈中的前两个数字弹出进行计算，并将结果压入栈中，
 * 注意减法和除法，弹出的第二个数才是被检和被除数
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if ("+-*/".contains(s)) {
                //遍历遇到运算符，从栈中拿出两个数字进行计算
                int a = stack.pop();
                int b = stack.pop();
                switch (s){
                    case "+":
                        stack.push(a+b);
                        break;
                    case "*":
                        stack.push(a*b);
                        break;
                    case "-":
                        stack.push(b-a);
                        break;
                    case "/":
                        stack.push(b/a);
                        break;
                }
            }else {
                //遍历到的是数字,直接压入栈中
                stack.push(Integer.valueOf(s));
            }
        }
        //最后剩下的就是计算的结果
        return stack.pop();
    }
}
