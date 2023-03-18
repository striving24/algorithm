package search_tree;

/**
 * @author 马祥
 * @Package search_tree
 * @date 2023-03-14 11:48
 * @Copyright © 2024未来可期
 * 230. 二叉搜索树中第K小的元素
 */
public class KthSmallest {
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
   解法一：因为二叉搜索树的中序遍历就是一个二叉树的升序排列，所以可以在中序遍历过程中应一个遍历记录并判断即可
    */
    public int kthSmallest(TreeNode root, int k) {
        traverse(root,k);
        return res;
    }
    //记录结果
    int res = 0;
    //记录当前元素的排序
    int rank = 0;
    void traverse(TreeNode root,int k){
        if (root == null){
            return;
        }
        traverse(root.left,k);
        //-----中序位置------(即需要操作的位置)
        rank++;
        if (rank == k){
            //找到符合题意的元素
            res = root.val;
            return;
        }
        traverse(root.right,k);
    }
}
