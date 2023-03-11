package tree;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.HashMap;

/**
 * @author 马祥
 * @Package tree
 * @date 2023-03-11 11:16
 * @Copyright © 2024未来可期、
 * 889. 根据前序和后序遍历构造二叉树
 */
public class ConstructFromPrePost {
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

    //存储后续遍历数组中的元素和索引
    HashMap<Integer, Integer> valIndex = new HashMap<>();
    //主方法
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            valIndex.put(postorder[i], i);
        }
        return  build(preorder,0, preorder.length-1,postorder,0,postorder.length-1);
    }
    /*
    对于方法：前序遍历数组为preorder[preStart,preEnd]
            后续遍历数组为postorder[postStart,postEnd]
            构造这个二叉树返回根节点
     */
    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] postorder,int postStart,int postEnd) {
        if (preStart > preEnd) return null;
        if (preStart == preEnd) return new TreeNode(preorder[preStart]);

        //root节点值就是前序遍历数组的第一个元素
        int rootval = preorder[preStart];
        //root节点的左边子节点，这里默认为前序遍历数组的第二个元素（其实是不确定的，因为答案可以有多个）
        int leftRootVal = preorder[preStart+1];
        //通过leftRootVal在后续遍历数组中寻找索引
        int index = valIndex.get(leftRootVal);
        //计算左子树的个数
        int lefiSize = index - postStart + 1;

        //先构造出当前根节点
        TreeNode root = new TreeNode(rootval);
        //递归构造左右子树
        root.left = build(preorder,preStart+1,preStart + lefiSize,
                        postorder,postStart,index);
        root.right = build(preorder,preStart+lefiSize+1,preEnd,
                        preorder,index+1,postEnd-1);
        return root;
    }
}
