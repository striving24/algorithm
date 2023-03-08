package lanqian.java2013_a;

import java.util.Scanner;

/**
 * @author 马祥
 * @Package lanqian.java2013_a
 * @date 2023-02-08 22:08
 * @Copyright © 2024未来可期
 * 第10题：连号区间数
 */
public class Test10 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n ; i++) {
            num[i] = sca.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int max = num[i];
            int min = num[i];
            for (int j = i; j < n; j++) {
                if (num[j] > max) max = num[j];
                if (num[j] < min) min = num[j];
                if (max - min == j-i) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
