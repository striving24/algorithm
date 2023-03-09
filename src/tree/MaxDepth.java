package tree;

/**
 * @author 马祥
 * @Package tree
 * @date 2023-03-08 17:33
 * @Copyright © 2024未来可期
 */
public class MaxDepth {
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

    //记录最大深度
    int res = 0;
    //记录遍历到的节点深度
    int depth = 0;
    //主函数
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }
    //二叉树遍历框架
    public void traverse(TreeNode root){
        if (root == null){
            //到达了叶子节点，更新最大深度
            res = Math.max(res,depth);
            return;
        }
        //前序位置
        depth++;
        traverse(root.left);
        traverse(root.right);
        //后续位置
        depth--;
    }


    //思路二：分解问题求解，可以通过求解子树的最大高度来计算整棵树的高度
    public int maxDepth1(TreeNode root) {
        if (root == null){
            return 0;
        }
        //求解左树的最大高度（本质也是递归）
        int left = maxDepth1(root.left);
        //求解右树的最大高度
        int right = maxDepth1(root.right);
        //整棵树的最大高度就等于子树最大高度加上根夫节点本身
        int res = Math.max(left, right)+1;
        return res;
    }
    public static void main(String[] args) {
        System.out.println("努力多一点");
        System.out.println("努力多一点");
    }
}
