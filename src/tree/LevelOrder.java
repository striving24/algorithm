package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 马祥
 * @Package tree
 * @date 2023-03-09 11:44
 * @Copyright © 2024未来可期
 * 二叉树的层序遍历
 */
public class LevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> stk = new LinkedList<>();
        stk.offer(root);
        //while循环控制从上层到下层遍历
        while (!stk.isEmpty()){
            int size = stk.size();
            //记录这一层的节点值
            List<Integer> curLevel = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = stk.poll();
                curLevel.add(node.val);
                if (node.left != null) stk.offer(node.left);
                if (node.right != null) stk.offer(node.right);
            }
            res.add(curLevel);
        }
        return res;
    }

    //写法二；
    public List<List<Integer>> levelOrder(TreeNode root){
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> stk = new LinkedList<>();
        stk.offer(root);
        while (!stk.isEmpty()){
            List<Integer> curLever = new ArrayList<>();
            int size = stk.size();
            while (size > 0) {
                TreeNode node = stk.poll();
                curLever.add(node.val);
                if (node.left != null) stk.offer(node.left);
                if (node.right != null) stk.offer(node.right);
                size--;
            }
            res.add(curLever);
        }
        return res;
    }
}
