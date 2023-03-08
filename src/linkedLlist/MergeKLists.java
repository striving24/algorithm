package linkedLlist;

import java.util.PriorityQueue;

/**
 * @author 马祥
 * @Package linkedLlist
 * @date 2023-02-22 21:29
 * @Copyright © 2024未来可期
 */

public class MergeKLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        //优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length,(a,b) -> (a.val-b.val)
        );
        //将K个链表的头节点添加到队列中
        for (ListNode head : lists) {
            if (head != null){
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            //获取最小节点，放入结果链表中
            ListNode r = pq.poll();
            p.next = r;
            if (r.next != null) {
                pq.add(r.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
