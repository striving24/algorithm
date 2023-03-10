package tree;

/**
 * @author 马祥
 * @Package tree
 * @date 2023-03-10 11:30
 * @Copyright © 2024未来可期
 * 114. 二叉树展开为链表
 */
public class Flatten {
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
  //主函数 : 以root为根节点的二叉树拉成一条链表
    public void flatten(TreeNode root) {
          if (root == null){
               return;
          }
           //递归先将左右子树拉成一条
          flatten(root.left);
          flatten(root.right);
          //后续位置
          //此时左右子树已经拉成了一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        //将左子树转为为右子树
        root.left = null;
        root.right = left;

        //就原来的右子树接到当前的右子树末端
        TreeNode p = root;
        while (p.right != null){
            p = p.right;
        }
        p.right = right;
    }
}
