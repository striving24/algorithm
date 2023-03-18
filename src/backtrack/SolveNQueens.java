package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 马祥
 * @Package backtrack
 * @date 2023-03-16 11:12
 * @Copyright © 2024未来可期
 * N皇后问题
 */
public class SolveNQueens {
    //记录结果
    List<List<String>> res = new LinkedList<>();
    //主函数
    public List<List<String>> solveNQueens(int n) {
        //先构造出棋盘（全为“.”）
        char[][] borad = new char[n][];
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars,'.');
            borad[i] = chars;
        }
        //调用函数
        backTrack(borad,0);
        return res;
    }

    //回溯算法框架
    //1、路径：当前行之前的行上已经放置了皇后，即board中小于row的已经放置了
    //2、选择列表：当前行所在的所有列都是可选择的位置
    //3、结束条件：当前所在行已经大于board的最后一行
    void backTrack(char[][] board,int row){
        //到达结束条件，收集结果
        if (row == board.length){
            List<String> str = new ArrayList<>(row);
            for (char[] chars : board){
                str.add(new String(chars));
            }
            res.add(str);
            return;
        }
        //未到达结束条件，获取当前行的列数（即为选择列表）
        int len = board[row].length;
        for (int col = 0;col < len;col++){
            //判断当前列是否可以放置皇后（排除不合法位置）
            if (!isValid(board,row,col)){
                continue;//不合法跳过继续
            }
            //做出选择
            board[row][col] = 'Q';
            //递归进入下一行
            backTrack(board,row+1);
            //回溯，撤销选择
            board[row][col] = '.';
        }
    }

    //判断board[row][col]是否可以放置皇后Q
    boolean isValid(char[][] board,int row,int col){
        int n = board.length;//行数列数
        //检查列是否有皇后冲突
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        //检查左上方是否有皇后冲突
        for (int i = row-1,j = col-1;i >= 0&&j >= 0;i--,j--){
            if (board[i][j] == 'Q') return false;
        }
        //检查右上方是否有皇后冲突
        for (int i = row-1,j = col+1;i >= 0 && j < n;i--,j++){
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
