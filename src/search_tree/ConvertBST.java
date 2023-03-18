package search_tree;

/**
 * @author 马祥
 * @Package search_tree
 * @date 2023-03-14 16:02
 * @Copyright © 2024未来可期
 * 538. 把二叉搜索树转换为累加树
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * 提醒一下，二叉搜索树满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 */
public class ConvertBST {
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
    思路：二叉树解题框架的遍历思维，维护一个为外部变量sum累加和，变量过程中并把sum赋值给每一个节点即可
    分局题目节点要求是大于等于源节点的值之和，二叉树中序的遍历为，左 中 右，这里就需要调换一下顺序为：右中左才符合题意
     */
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
    int sum = 0;
    void traverse(TreeNode root){
        if (root == null){
            return;
        }
        traverse(root.right);
        //-------中序位置-------
        sum += root.val;
        root.val = sum;
        //--------------------
        traverse(root.left);
    }
}
