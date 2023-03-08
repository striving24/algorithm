package lanqiao.java2017_b;

/**
 * @author 马祥
 * @Package lanqiao.java2017_b
 * @date 2023-02-27 23:05
 * @Copyright © 2024未来可期
 * 题目： X星球的高科技实验室中整齐地堆放着某批珍贵金属原料。每块金属原料的外形、尺寸完全一致，但重量不同。金属材料被严格地堆放成金字塔形。
 * 其中的数字代表金属块的重量（计量单位较大）。
 * 最下一层的X代表30台极高精度的电子秤。
 * 假设每块原料的重量都十分精确地平均落在下方的两个金属块上，
 * 最后，所有的金属块的重量都严格精确地平分落在最底层的电子秤上。
 * 电子秤的计量单位很小，所以显示的数字很大。
 * 工作人员发现，其中读数最小的电子秤的示数为：2086458231
 * 请你推算出：读数最大的电子秤的示数为多少？
 */

import java.util.Scanner;

/**
 * 分析：根据题意，上一层材料的重量都是平均分在下一层上的
 * 定义一个二维数组，将数据填入数组（最后一行用于计算结果），然后遍历计算上一层weight/2，加到下一层即可，直到遍历结束
 * 再最后一层寻找最大和最小值int[29][j]
 */
public class Test3 {
    public static void main(String[] args) {
        //录入数据
        Scanner in = new Scanner(System.in);
        double[][] n = new double[30][30];
        for (int i = 0; i < 29; i++) {
            for (int j = 0; j <= i; j++) {
                n[i][j] = in.nextDouble();
            }
        }
        //处理数据
        for (int i = 0; i < 29; i++) {
            for (int j = 0; j <= i; j++) {
                //将上一层的数据平均分配到下一层中，一直往下
                double temp = n[i][j]/2.0;
                n[i+1][j] += temp;
                n[i+1][j+1] += temp;
            }
        }

        //寻找结果
        double minRes = Double.MAX_EXPONENT;
        double maxRes = Double.MIN_EXPONENT;
        for (int j = 0; j < 30; j++) {
            if (n[29][j] < minRes){
                minRes = n[29][j];
            }
            if (n[29][j] > maxRes){
                maxRes = n[29][j];
            }
        }
        System.out.println((2086458231.0  * maxRes)/ minRes);
    }
}
