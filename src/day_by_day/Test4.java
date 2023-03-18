package day_by_day;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 马祥
 * @Package day_by_day
 * @date 2023-03-15 14:01
 * @Copyright © 2024未来可期
 * 求和（2022年省赛）
 */
/*
思路：本体可以暴力解决，但是复杂度较高，不建议使用
方法二，数学知识归纳，eg : 1 3 5 7 四个数字相加
               第一层 ： 1*3 + 1*5 + 1*7 = 1 * （3+5+7）
               第二层 ；3*5 + 3*7 =       3 *（5+7）
               即：每一次相乘相加，就等于当前数值中除去num的其余数值之和
               解法代码如下：
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        //读入数据
        int[] nums = new int[m];
        //记录结果
        long res = 0;
        //记录读入数据的和
        long sum = 0;
        for (int i = 0; i < m; i++) {
            nums[i] = scan.nextInt();
            sum += nums[i];
        }
        for (int i = 0; i < m; i++) {
            res += nums[i] * (sum-nums[i]);
            //加一次，就把当前索引的元素减去
            sum -= nums[i];
        }
        System.out.println(res);
        //在此输入您的代码...
        scan.close();
    }
}
