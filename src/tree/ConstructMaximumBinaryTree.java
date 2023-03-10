package tree;

/**
 * @author 马祥
 * @Package tree
 * @date 2023-03-10 11:55
 * @Copyright © 2024未来可期
 * 654. 最大二叉树
 */
public class ConstructMaximumBinaryTree {
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

    /**
     * 思路：分解问题，递归思想
     * 先构造出根节点，再递归构造左右子节点即可
     * @param nums
     * @return
     */
    //主函数
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0, nums.length-1);
    }

    //定义递归函数，利用数组nums[l,r]构造符合条件的二叉树,返回根节点
    TreeNode build(int[] nums,int l,int r){
        if (l > r) return null;
        //1、先找到数组中的最大值和其索引
        int maxValue = Integer.MIN_VALUE;
        int index = -1;
        for (int i = l; i <= r; i++) {
            if (nums[i] > maxValue){
                maxValue = nums[i];
                index = i;
            }
        }
        //2、得到了最大数值,构造根节点
        TreeNode root = new TreeNode(maxValue);
        //3、递归构造左右子树即可
        root.left = build(nums,l,index-1);
        root.right = build(nums,index+1,r);
        return root;
    }
}
