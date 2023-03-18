package tree;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.HashMap;

/**
 * @author 马祥
 * @Package tree
 * @date 2023-03-11 9:54
 * @Copyright © 2024未来可期
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildTree {
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
     * 思路：仍然以分解问题的思想，先把根节点确定，再递归的构造出子节点即可
     * 观察可以发现，preorder数组的第一个元素即为根节点，现在考虑就是如何确定递归左右子节点的范围索引
     * 中序遍历的根节点在中间，可以确定索引范围，而前序的根节点在第一个，所以需要想办法确定索引
     * 具体看代码
     * @param preorder
     * @param inorder
     * @return
     */

    //记录中序inorder数组的值和对于索引
    HashMap<Integer,Integer> valindex = new HashMap<>();
    //主函数
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valindex.put(inorder[i],i);
        }
        return  build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    /*
    对于方法：前序遍历数组为preorder[preStart,preEnd]
            中序遍历数组为inorder[inStart,inEnd]
            构造这个二叉树返回根节点
     */
    TreeNode build(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        if (preStart > preEnd){
            return null;
        }
        //得到根节点，前序遍历数组的第一个元素即为根节点的值
        int rootval = preorder[preStart];
        //将此值在中序数组中来查找索引
        int index = valindex.get(rootval);
        //进而计算前序遍历的左子树的末尾索引
        int leftSize = index - inStart;
        //先构造根节点
        TreeNode root = new TreeNode(rootval);
        //递归构造左右子树
        root.left = build(preorder,preStart+1,leftSize+preStart,
                inorder,inStart,index-1);
        root.right = build(preorder,leftSize+preStart+1,preEnd,
                inorder,index+1,inEnd);
        return root;
    }
}
