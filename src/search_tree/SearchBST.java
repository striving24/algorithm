package search_tree;

/**
 * @author 马祥
 * @Package binary_search
 * @date 2023-03-15 16:27
 * @Copyright © 2024未来可期
 * 700、二叉搜索树中的搜索
 */
public class SearchBST {
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
    public TreeNode searchBST(TreeNode root, int val) {
          if (root == null) return null;
          if (root.val < val) return searchBST(root.right,val);
          if (root.val > val) return searchBST(root.left,val);
          return root;
    }
}
