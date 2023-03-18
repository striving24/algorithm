package backtrack;

import search_tree.InsertIntoBST;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 马祥
 * @Package backtrack
 * @date 2023-03-18 9:48
 * @Copyright © 2024未来可期
 * 回溯算法之组合问题-------77、组合
 */
public class Combine {
    //结果
    List<List<Integer>> res = new LinkedList<>();
    //记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1,n,k);
        return res;
    }

    //回溯算法框架
    void backtrack(int start,int n,int k){
        //遍历到K层时，收集数据
        if (k == track.size()){
            res.add(new LinkedList<>(track));
            return;
        }
        //回溯算法标准框架
        for (int i = start; i <= n; i++) {
            //做选择
            track.addLast(i);
            //递归下一个，通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(i+1,n,k);
            //回溯，撤销选择
            track.pollLast();
        }
    }
}
