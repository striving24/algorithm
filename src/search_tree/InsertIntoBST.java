package search_tree;

import javax.swing.*;

/**
 * @author 马祥
 * @Package binary_search
 * @date 2023-03-15 16:41
 * @Copyright © 2024未来可期
 * 701. 二叉搜索树中的插入操作
 */
public class InsertIntoBST {
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
          //找到空位置然后插入空节点
          if (root == null) return new TreeNode(val);
          if (val > root.val){
              root.right = insertIntoBST(root.right,val);
          }
          if (val < root.val){
              root.left = insertIntoBST(root.left,val);
          }
          return root;
    }
}
