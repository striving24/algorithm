package array;

import sun.applet.Main;

import java.util.Arrays;

/**
 * @author 马祥
 * @Package array
 * @date 2023-02-05 14:10
 * @Copyright © 2024未来可期
 */
//31.下一个排列
public class NextPermutation {

    public void nextPermutation1(int[] nums) {
        /**
         * 思路：一遍扫描，首先如果当前数组排列为降序的话，则下一个排列就为将其转为升序排列
         * 一般情况下：排列为无序的，只需要找到最后一个升序的组合，
         * 然后将此数与后面的数字依次比较找到最靠近当前要交换的数字再交换即可
         * 代码如下：
         */
        int k = nums.length-2;//从倒数第二个开始
        while (k >= 0 && nums[k] > nums[k+1])
            k--;//不是降序，继续往前遍历
        //如果全部以降序排列，则以最小序输出
        if (k < 0)
            Arrays.sort(nums);
        //2、一般情况：找到了最后一个升序的排列
        //2.1定义n从k的后面第二个数开始比较
        int n = k+2;
        while (n < nums.length && nums[n] > nums[k])
            n++;
        //2.2循环推出时找到目标数的下一个,进行交换
        int temp = nums[k];
        nums[k] = nums[n-1];
        nums[n-1] = temp;
        //2.3将k后面的数字前后两两交换（实现升序）
        int lp = k+1;
        int rp = nums.length-1;
        while (lp < rp) {
            int tem = nums[lp];
            nums[lp] = nums[rp];
            nums[rp] = tem;
            lp++;
            rp--;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        NextPermutation res = new NextPermutation();
        res.nextPermutation(nums);
        for (int num:nums){
            System.out.print(num+"\t");
        }
    }

    private void nextPermutation(int[] nums) {
        //算法优化:与其再从后往前找k，不如直接j-end排序后，直接升序里找一个k与其交换即可
        int len = nums.length;
        for (int i = len-1; i > 0; i--) {
            if (nums[i] > nums[i-1]){
                Arrays.sort(nums,i,len);
                for (int j = i; j < len; j++) {
                    if (nums[j] > nums[i-1]){
                        int temp = nums[i-1];
                        nums[i-1] = nums[j];
                        nums[j] = temp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
        return;
    }
}
