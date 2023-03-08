package day_by_day.prefix_and;

import java.util.Scanner;

/**
 * @author 马祥
 * @Package day_by_day.prefix_and
 * @date 2023-02-13 19:44
 * @Copyright © 2024未来可期
 */
public class TruncatedArray {
    public static void main(String[] args) {
        //输入数据并计算前缀和
        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();
        //前缀和数组
        int[] preSum = new int[n+1];
        preSum[0] = 0;
        for (int i = 1; i <=n; i++) {
            preSum[i] = preSum[i-1] + sca.nextInt();
        }
        //维护第一段前缀和为preSum[n]/的数组数量
        if (preSum[n] % 3 != 0){
            System.out.println(0);
        }
        int cnt = 0;
        //最后结果
        long res = 0;
        for (int j = 2; j < n; j++) {
            if (preSum[j-1] == preSum[n]/3) cnt++;
            if (preSum[j] == preSum[n]/3 * 2) res += cnt;
        }
        System.out.println(res);
    }
}
