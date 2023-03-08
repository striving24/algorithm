package lanqian.java2013_a;

import java.util.Scanner;

/**
 * @author 马祥
 * @Package lanqian.java2013_a
 * @date 2023-02-06 15:53
 * @Copyright © 2024未来可期
 * 8、幸运数
 */
public class Test8 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int m = sca.nextInt();
        int n = sca.nextInt();
        int[] a = new int[n];//存储数据的数组
        //第一遍筛选：1 3 5 7 9 11 13 15 17
        for (int i = 0; i < n; i++) {
            a[i] = 2*i+1;
        }
        int l = 1;//当前的幸运数字
        while (true) {
            int p = l+1;//数字向前移动的位置
            for (int i = l+1; i < n; i++) {
                if ((i+1)%a[l] == 0){}//如果是直接跳过，啥也不做
                else {
                    a[p] = a[i];
                    p++;
                }
                if (a[i] > n){
                    break;
                }
            }
            l++;
            if (a[l] >= n){
                break;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] >= n)
                break;
            if (a[i] > m)
                res++;
        }
        System.out.println(res);
    }
}
