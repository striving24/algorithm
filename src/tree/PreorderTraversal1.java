package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 马祥
 * @Package tree
 * @date 2023-03-09 10:29
 * @Copyright © 2024未来可期
 * 二叉树的前序遍历（迭代）
 */
public class PreorderTraversal1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root){
        //结果集
        ArrayList<Integer> res = new ArrayList<>();
        //辅助栈
        Stack<TreeNode> stk = new Stack<>();
        if (root != null) stk.push(root);//先将根节点压入
        while (!stk.empty()){
            TreeNode node = stk.peek();
            if (node != null){
                stk.pop();//将该节点（头节点）弹出，避免重复操作，接下来按右 左 中 顺序入栈---得到前序中 左 右
                if (root.right != null) stk.push(root.right);//压入右节点（不加空节点）
                if (root.left != null)  stk.push(root.left);//压入左节点（不加入空节点）
                stk.push(root);//压入中节点（需要处理的节点）
                stk.push(null);//在处理节点的后面接入空节点，作为标记
            }else {
                //node==null，即弹出了空节点，下一个弹出并加入结果集
                stk.pop();//弹出空节点
                node = stk.peek();//取出下一个元素
                //弹出元素并加入到结果集
                stk.pop();
                res.add(node.val);
            }
        }
        return res;
    }
}
