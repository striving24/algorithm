package linkedLlist;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Random;

/**
 * @author 马祥
 * @Package linkedLlist
 * @date 2023-03-14 14:19
 * @Copyright © 2024未来可期
 * 382. 链表随机节点
 * 水塘抽样算法应用
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    ListNode head;
    Random rad = new Random();
    public Solution(ListNode head) {
        this.head = head;
    }

    //随机返回一个节点
    public int getRandom() {
        int i = 0;
        int res = 0;
        ListNode p = head;
        //循环遍历链表
        while (p != null){
            //生成一个[0,i)之间的整数
            //这个整数等于0的概率为1/i
            if (rad.nextInt(++i) == 0){
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
}
