package queue_and_stack;

/**
 * @author 马祥
 * @Package queue_and_stack
 * @date 2023-03-07 10:25
 * @Copyright © 2024未来可期
 */

import java.util.LinkedList;

/**
 * 单调队列的实现：
 * 实现单调队列需使用一种可以实现在对头和对尾插入和删除的数据结构，这里使用了双向链表
 * 具体见代码以及相关注释
 */
public class MonitonicQueue {
    //双向链表，实现对头和对尾的插入和删除
    //维护其中的元素，保证从队尾到对头是单调递增的
    private LinkedList<Integer> maxq = new LinkedList<>();

    //添加元素在对尾部，核心思想所在，维护单调递增性质
    public void push(int n) {
        //将前面小于自己的元素都删掉（即和队尾元素比较）
        while (!maxq.isEmpty() && maxq.getLast() < n){
            maxq.pollLast();
        }
        maxq.addLast(n);
    }

    //得到队列中的最大值
    public int max() {
        //因为队列元素为单调递增的，此时对头元素一定为最大值
        return maxq.getFirst();
    }

    //在对头删除元素n
    public void pop(int n){
        //这里判断n与对头元素是因为n有可能以及被压制后移了，就不需要再删除了
        if(n == maxq.getFirst()) {
            maxq.pollFirst();
        }
    }
}
