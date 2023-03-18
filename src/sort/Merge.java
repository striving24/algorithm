package sort;

import java.time.temporal.Temporal;

/**
 * @author 马祥
 * @Package sort
 * @date 2023-03-12 10:16
 * @Copyright © 2024未来可期
 * 归并排序深度理解
 */
public class Merge {
    //辅助数组，用于合并有序数组
    private static int[] temp;
    //主方法：归并排序
    public static void mergeSort(int[] nums){
        //先给temp数组开辟空间
        temp = new int[nums.length];
        //排序整个数组（原地修改）
        sort(nums,0, nums.length-1);
    }
    //定义方法：将子数组nums[l.r]进行排序
    private static void sort(int[] nums,int l,int r){
        if (l == r) return;
        //中间位置(可以理解为二叉树的中间节点)
        int mid = l + (r-l)/2;
        //递归实现将mid左边的数组排序
        sort(nums, l, mid);
        //递归实现将mid右边的数组排序
        sort(nums, mid+1, r);
        //(二叉树遍历的后续位置)
        //最后合并两个有序数组
        merge(nums,l,mid,r);
    }

    //方法：合并两个有序数组
    private static void merge(int[] nums,int l,int mid ,int r){
        //先把nums[l,r]元素复制到temp辅助数组中，便于合并后直接存入原数组nums中
        for (int i = l; i < r; i++) {
            temp[i] = nums[i];
        }
        //数组双指针技巧，合并两个有序数组
        int i = l,j = mid + 1;
        for (int p = l; p < r; p++) {
            if (l == mid+1){//左边已经合并完成
                nums[p] = temp[j++];
            } else if (r == r+1) { //右边已经合并完成
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            }else {
                nums[p] = temp[i++];
            }
        }
    }
}
