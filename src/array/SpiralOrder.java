package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 马祥
 * @Package array
 * @date 2023-02-26 12:53
 * @Copyright © 2024未来可期
 * 54、螺旋矩阵
 */

/**
 * 思路：按照右下左上的顺序遍历即可，并更新圈定范围
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        //左右上下边界
        int left_bound = 0,right_bound = n-1;
        int upper_bound = 0,lower_bound = m-1;
        //保存结果的数组
        List<Integer> res = new LinkedList<>();
        //当res的长度=m*n时，即遍历完毕
        while (res.size() < m * n){
            //1、在顶部向右边遍历，上下边界为限制
            if (upper_bound <= lower_bound) {
                for (int j = left_bound; j <= right_bound; j++) {
                    res.add(matrix[upper_bound][j]);
                }
                //上边界下移
                upper_bound++;
            }
            //2、在右边从上到下遍历
            if (left_bound <= right_bound){
                for (int i = upper_bound; i <= lower_bound; i++) {
                    res.add(matrix[i][right_bound]);
                }
                right_bound--;
            }
            //3、在下边从右往左遍历
            if (upper_bound <= lower_bound){
                for (int j = right_bound; j >= left_bound ; j--) {
                    res.add(matrix[lower_bound][j]);
                }
                lower_bound--;

            }
            //4、在左边从下往上遍历
            if (left_bound <= right_bound){
                for (int i = lower_bound; i >= upper_bound ; i--) {
                    res.add(matrix[i][left_bound]);
                }
                left_bound++;
            }
        }
        return res;
    }
}
