package linkedLlist;

/**
 * @author 马祥
 * @Package linkedLlist
 * @date 2023-02-18 16:36
 * @Copyright © 2024未来可期
 */
public class Partition {
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

    /**
     * 86、分割链表：给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
     * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        //1、定义两个虚拟节点，来存储小于和大于等于X的链表
        //小于
        ListNode dummy1 = new ListNode(-1);
        //大于等于
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1,p2 = dummy2;
        //遍历链表
        ListNode p = head;
        while (p1 != null){
            if (p.val >= x){
                p2.next = p;
                p2 = p2.next;
            }
            if (p.val < x){
                p1.next = p;
                p1 = p1.next;
            }
            //断开原来链表的每个节点的next指针
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        //连接两个链表
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
