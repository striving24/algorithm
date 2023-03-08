package queue_and_stack;

/**
 * @author 马祥
 * @Package queue_and_stack
 * @date 2023-03-05 10:32
 * @Copyright © 2024未来可期
 * 20、有效的括号
 */

import java.util.Stack;

/**
 * 利用栈先进后出的特点，遍历字符串，遇到左括号就压入栈，遇到右括号就将对应的左括号与之比较判断是否满足题意
 */
public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if (!stack.isEmpty() && leftChar(c) == stack.peek()){
                    stack.pop();
                }
                else return false;
            }
        }
        return stack.isEmpty();
    }
    //定义方法：遇到右括号将其对应的左括号与stack中比较
    char leftChar(char c){
        if (c == '}') return '{';
        if (c == ')') return '(';
        return '[';
    }
}
