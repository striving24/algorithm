package search_tree;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * @author 马祥
 * @Package binary_search
 * @date 2023-03-15 15:31
 * @Copyright © 2024未来可期
 * 验证二叉搜索树
 */
public class IsValidBST {
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

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);
    }
    /*
    BST 左小右大的特性是指 root.val 要比左子树的所有节点都更大，
    要比右子树的所有节点都小，你只检查左右两个子节点当然是不够的
    利用赋值函数，增加函数的参数列表，将其传递给所有子树作为约束
     */
    //辅助函数：以root为跟节点的子树必须满足 max.value > root.value > min.value
    public boolean isValidBST(TreeNode root,TreeNode min,TreeNode max) {
        if (root == null){
            return true;
        }
        //判断是否满足max min的限制，即是否合法
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        //递归，并限定左子树最大值root.val,右子树的最小值为root.val
        return  isValidBST(root.left,min,root) &&
        isValidBST(root.right,root,max);
    }
}
