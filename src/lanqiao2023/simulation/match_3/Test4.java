    package lanqiao2023.simulation.match_3;

    import javafx.scene.control.IndexRange;
    import tree.InvertTree;

    import java.util.Arrays;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.Set;

    /**
     * @author 马祥
     * @Package lanqiao2023.simulation.match_3
     * @date 2023-03-12 15:02
     * @Copyright © 2024未来可期
     * 问题描述：
     * 小蓝有 30 个数，分别为：99, 22, 51, 63, 72, 61, 20, 88, 40, 21, 63, 30, 11,
     *      18, 99, 12, 93, 16, 7, 53, 64, 9, 28, 84, 34, 96, 52, 82, 51, 77 。
     * 小蓝可以在这些数中取出两个序号不同的数，共有 30*29/2=435 种取法。
     * 请问这 435 种取法中，有多少种取法取出的两个数的乘积大于等于 2022 。
     */

    /*
    解法一：暴力遍历即可
     */
    public class Test4 {
        public static void main(String[] args) {
            int[] num = {99, 22, 51, 63, 72, 61, 20, 88, 40, 21, 63, 30, 11, 18, 99, 12, 93,
                    16, 7, 53, 64, 9, 28, 84, 34, 96, 52, 82, 51, 77};
            int res = 0;
            for (int i = 0; i < num.length; i++) {
                for (int j = i+1; j < num.length; j++) {
                    if (num[i] * num[j] >= 2022){
                        res++;
                    }
                }
            }
            System.out.println(res);
        }
    }
