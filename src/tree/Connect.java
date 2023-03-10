package tree;

import queue_and_stack.Trap;

/**
 * @author 马祥
 * @Package tree
 * @date 2023-03-10 10:58
 * @Copyright © 2024未来可期
 * 116. 填充每个节点的下一个右侧节点指针
 */
public class Connect {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    //主函数
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        traverse(root.left,root.right);
        return root;
    }

    //三茶树遍历框架
    void traverse(Node root1,Node root2){
        if (root1 == null || root2 == null){
            return;
        }
        //前序位置
        //将传入的节点连接起来
        root1.next = root2;
        //连接相同父节点的两个节点
        traverse(root1.left,root1.right);
        traverse(root2.left,root2.right);
        //跨越连接两个不同父节点的两个节点
        traverse(root1.right,root2.left);
    }
}
