package tree;

/**
 * @author 马祥
 * @Package tree
 * @date 2023-03-10 9:55
 * @Copyright © 2024未来可期
 * 226. 翻转二叉树
 */
public class InvertTree {
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

    //主函数
    public TreeNode invertTree1(TreeNode root) {
        traverse(root);
        return root;
    }
    //二叉树遍历函数
    void traverse(TreeNode root){
        if (root == null){
            return;
        }
        //前序位置，将该节点的左右节点交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right =temp;

        traverse(root.left);
        traverse(root.right);
    }

    //主函数
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        //利用主函数定义反转左右子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        //再交换左右节点
        root.left = right;
        root.right = left;
        return root;
    }
}
