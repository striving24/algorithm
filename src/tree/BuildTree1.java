package tree;

import java.util.HashMap;

/**
 * @author 马祥
 * @Package tree
 * @date 2023-03-11 10:42
 * @Copyright © 2024未来可期
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class BuildTree1 {
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
     * 思路：此题将上一题的前序和后续作为了一个交换，整体解题思路和上一题基本一致
     * 注意递归左右子树的边界位置即可
     * 具体看代码
     * @param preorder
     * @param inorder
     * @return
     */

    //记录中序inorder数组的值和对于索引
    HashMap<Integer,Integer> valindex = new HashMap<>();
    //主函数
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valindex.put(inorder[i],i);
        }
        return  build(inorder,0,inorder.length-1,inorder,0,postorder.length-1);
    }

    /*
    对于方法：前序遍历数组为preorder[preStart,preEnd]
            中序遍历数组为inorder[inStart,inEnd]
            构造这个二叉树返回根节点
     */
    TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int podtEnd){
        if (inStart > inEnd){
            return null;
        }
        //得到根节点，后续遍历数组的最后一个元素即为根节点的值
        int rootval = postorder[podtEnd];
        //将此值在中序数组中来查找索引
        int index = valindex.get(rootval);
        //进而计算后序遍历的左子树的末尾索引
        int rightSize = index - inStart;
        //先构造根节点
        TreeNode root = new TreeNode(rootval);
        //递归构造左右子树
        root.left = build(inorder,inStart,index-1,
                postorder,postStart,postStart+rightSize-1);
        root.right = build(inorder,index+1,inEnd,
                postorder,postStart+rightSize,podtEnd-1);
        return root;
    }
}
