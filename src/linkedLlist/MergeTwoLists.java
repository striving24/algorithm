package linkedLlist;

import com.sun.org.apache.bcel.internal.generic.POP2;

/**
 * @author 马祥
 * @Package linkedLlist
 * @date 2023-02-17 19:37
 * @Copyright © 2024未来可期
 */
public class MergeTwoLists {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //创建一个虚拟头节点
        ListNode dummy = new ListNode(-1),p = dummy;
        //创建两个指针，即分别指向两个链表的头节点
        ListNode p1 = list1,p2 = list2;

        //思路：两个指针同时向前，小的接在p链表上即可，如果有一条链表遍历结束了，则下一条继续接上即可
        while (p1 != null && p2 != null){
            if (p1.val > p2.val){
                p.next = p2;
                p2 = p2.next;
            }else{
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if (p1 != null){
            p.next = p1;
        }
        if (p2 != null){
            p.next = p2;
        }
        return dummy.next;
    }
}
