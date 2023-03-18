package search_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PrimitiveIterator;

/**
 * @author 马祥
 * @Package binary_search
 * @date 2023-03-15 19:22
 * @Copyright © 2024未来可期
 * 95. 不同的二叉搜索树 II
 */
public class GenerateTrees {
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
    此题和上一题思路基本一致，多了一个要求，需要把所有可能的二叉树构建出来
    1、先穷举出root节点的所有可能
    2、递归构造出左右子树的所有合法的BST
    3、再给root节点穷举出所有左右子树的组合
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return build(1,n);
    }

    //构造闭区间[ lo,hi ]组成的所有合法BST
    List<TreeNode> build(int lo,int hi){
        LinkedList<TreeNode> res = new LinkedList<>();
        if (lo > hi){
            res.add(null);
            return res;
        }
        //1、穷举root节点的所有可能
        for (int i = lo; i <= hi; i++) {
            //2、递归构造出所有左右子树的合法BST
            List<TreeNode> leftTree = build(lo, i - 1);
            List<TreeNode> rightTree = build(i + 1, hi);
            //3、给root节点穷举所有左右子树的组合
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    //以root为根节点的树
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
