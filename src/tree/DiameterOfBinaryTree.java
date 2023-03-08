package tree;

/**
 * @author 马祥
 * @Package tree
 * @date 2023-03-08 19:30
 * @Copyright © 2024未来可期
 * 543. 二叉树的直径
 */
public class DiameterOfBinaryTree {
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

    /*
    分析：关键点在于，每一条二叉树的直径，就是一个节点的左右子树的深度之和
     */

    int res = 0;
    //主函数
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return res;
    }
    //计算二叉树的最大深度
    int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        //后续位置，顺便更新直径
        int curDepth = left + right;
        res = Math.max(res, curDepth);
        //最大深度计算
        return Math.max(left,right) + 1;
    }
}
