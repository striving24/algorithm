package linkedLlist;

/**
 * @author 马祥
 * @Package linkedLlist
 * @date 2023-02-22 21:56
 * @Copyright © 2024未来可期
 */
public class RemoveNthFromEnd {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    /**
     * 首先寻找倒数第K个节点，一般思路是直接遍历即可，但是链表一般给的只有头节点，只有先遍历一遍才能知道长度
     * 思路二：
     * 长度为K,倒数K个节点，即为正数的第n-k+1个
     * 只需要遍历一遍即可，定义两个指针，怕1先移动k步，此时p2和p1同时移动,p1结束时，P2刚好移动了N-k步，停留在
     * 倒数第K个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //要删除倒数第K个节点，就要找到前一个，即倒数第K+1个
        ListNode node = findListNode(dummy, n + 1);
        node.next = node.next.next;
        return dummy.next;
    }
    ///寻找倒数第K个节点
    ListNode findListNode(ListNode head,int n){
        ListNode p1 = head;
        //p1先走n步
        for(int i=0;i<n;i++){
            p1 = p1.next;
        }
        //p2此时和P1同时移动
        ListNode p2 = head;
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
