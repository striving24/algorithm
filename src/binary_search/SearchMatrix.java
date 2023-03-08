package binary_search;

/**
 * @author 马祥
 * @Package binary_search
 * @date 2023-02-06 22:08
 * @Copyright © 2024未来可期
 * 74、搜索二维矩阵
 */

public class SearchMatrix {
    /**
     * 思路分析：因为矩阵是有序的就要想到二分搜索；
     * 只需要将二维角标转化为一维的即可，最后在转化回来
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midSum = matrix[mid/n][mid%n];
            if (midSum == target){
                return true;
            } else if (midSum > target) {
                right = mid-1;
            } else if (midSum < target) {
                left  = mid+1;
            }
        }
        return false;
    }

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length,n = matrix[0].length;
            // 把二维数组映射到一维
            int left = 0, right = m * n - 1;
            // 标准的二分搜索框架
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(get(matrix,mid) == target){
                    return true;
                }else if(get(matrix,mid) < target){
                    left = mid + 1;
                }else if(get(matrix,mid) > target){
                    right = mid - 1;
                }
            }
            return false;
        }
        //使用一维数组索引来访问二维数组的元素
        int get(int[][] matrix ,int index){
            int m = matrix.length,n = matrix[0].length;
            //转换为二维数组的坐标为
            int i = index / n,j = index % n;
            return matrix[i][j];
        }
    }
}
