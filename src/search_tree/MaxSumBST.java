package search_tree;

/**
 * @author 马祥
 * @Package binary_search
 * @date 2023-03-15 20:33
 * @Copyright © 2024未来可期
 * 1373. 二叉搜索子树的最大键值和
 */
public class MaxSumBST {
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
  二叉树相关题目最核心的思路是明确当前节点需要做的事情是什么，那么我们想计算子树中 BST 的最大和，
  站在当前节点的视角，需要做什么呢
1、得知道左右子树是不是合法的 BST，如果这俩儿子有一个不是 BST，以我为根的这棵树肯定不会是 BST
2、如果左右子树都是合法的 BST，我得瞅瞅左右子树加上自己还是不是合法的 BST 了。因为按照 BST 的定义
当前节点的值应该大于左子树的最大值，小于右子树的最小值，否则就破坏了 BST 的性质。
3、因为题目要计算最大的节点之和，如果左右子树加上我自己还是一棵合法的 BST，
也就是说以我为根的整棵树是一棵 BST，那我需要知道我们这棵 BST 的所有节点值之和是多少，
方便和别的 BST 争个高下
简单说就是要知道以下具体信息：
1、左右子树是否是 BST。
2、左子树的最大值和右子树的最小值。
3、左右子树的节点值之和。
   */

    /*
定义一个 traverse 函数，traverse(root) 返回一个大小为 4 的 int 数组，我们暂且称它为 res，其中：
res[0] 记录以 root 为根的二叉树是否是 BST，若为 1 则说明是 BST，若为 0 则说明不是 BST；
res[1] 记录以 root 为根的二叉树所有节点中的最小值；
res[2] 记录以 root 为根的二叉树所有节点中的最大值；
res[3] 记录以 root 为根的二叉树所有节点值之和。
     */
    // 全局变量，记录 BST 最大节点之和
    int maxSum = 0;
    /* 主函数 */
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    int[] traverse(TreeNode root) {
        // base case
        if (root == null) {
            return new int[] {
                    1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0
            };
        }

        // 递归计算左右子树
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        /*******后序遍历位置*******/
        int[] res = new int[4];
        // 这个 if 在判断以 root 为根的二叉树是不是 BST
        if (left[0] == 1 && right[0] == 1 &&
                root.val > left[2] && root.val < right[1]) {
            // 以 root 为根的二叉树是 BST
            res[0] = 1;
            // 计算以 root 为根的这棵 BST 的最小值
            res[1] = Math.min(left[1], root.val);
            // 计算以 root 为根的这棵 BST 的最大值
            res[2] = Math.max(right[2], root.val);
            // 计算以 root 为根的这棵 BST 所有节点之和
            res[3] = left[3] + right[3] + root.val;
            // 更新全局变量
            maxSum = Math.max(maxSum, res[3]);
        } else {
            // 以 root 为根的二叉树不是 BST
            res[0] = 0;
            // 其他的值都没必要计算了，因为用不到
        }
        /**************************/

        return res;
    }
}

