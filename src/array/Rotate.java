package array;

/**
 * @author 马祥
 * @Package array
 * @date 2023-02-25 23:12
 * @Copyright © 2024未来可期
 *  48、旋转图像
 */

import javax.swing.*;

/**
 * 思路：将二维数组沿着对角线反转即交换，在将得到的数组每行元素进行反转得到就是顺时针旋90的结果
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        //1、先将二维数组沿着对角线镜像对称
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //2、然后反转一得到的二维矩阵的每一行
        for (int[] row : matrix){
            reverse(row);
        }
    }

    //反转一维数组
    private void reverse(int[] row) {
        int left = 0,right = row.length-1;
        while (left < right) {
            row[left] ^= row[right];
            row[right] ^= row[left];
            row[left] ^= row[right];
            left++;
            right--;
        }
    }

    //拓展：逆时针旋转90°的情况：
    public void rotate1(int[][] matrix){
        //1、将二维矩阵以右对称轴为中心镜像反转
        int n = matrix.length;
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][n-i-1];
                matrix[n-j-1][n-i-1] = temp;
            }
        }

        //2、反转得到的矩阵的每一行
        for (int[] row : matrix){
            reverse(row);
        }
        //反转一维数组，与上文一致
    }
}
