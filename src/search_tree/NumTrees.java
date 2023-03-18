package search_tree;

import sun.awt.geom.AreaOp;

/**
 * @author 马祥
 * @Package binary_search
 * @date 2023-03-15 18:50
 * @Copyright © 2024未来可期
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
 * 返回满足题意的二叉搜索树的种数。
 */
public class NumTrees {
    //备忘录
    int[][] mome;
    public int numTrees(int n) {
        mome = new int[n+1][n+1];
        return count(1,n);
    }

    //计算区间[lo,hi]组成BST的个数
    int count(int lo,int hi){
        if(lo > hi) return 1;
        //查备忘录
        if (mome[lo][hi] != 0){
            return mome[lo][hi];
        }
        int res = 0;
        for (int i = lo; i < hi; i++) {
            //以i的值作为根节点计算
            int left = count(lo,i-1);
            int right = count(i+1,hi);
            res += left * right;
        }
        //将结果存入备忘录
        mome[lo][hi] = res;
        return res;
    }
}
