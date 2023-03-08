package queue_and_stack;

/**
 * @author 马祥
 * @Package queue_and_stack
 * @date 2023-03-06 9:37
 * @Copyright © 2024未来可期
 * 155、最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 */

import java.util.Stack;

/**
 * 思路：由于栈对数据的操作有限制，每次只能操作栈顶数据，所以再定义一个栈来记录维护每次的最小数据处于栈顶
 */
public class MinStack {
    //记录栈中所有元素
    Stack<Integer> stack;
    //阶段性记录栈中最小元素
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        //维护记录栈中最小元素
        if (minStack.isEmpty() || val <= minStack.peek()){
            //此时该元素就是最小的
            minStack.push(val);
        }
    }

    public void pop() {
        if (minStack.peek().equals(stack.peek())){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
