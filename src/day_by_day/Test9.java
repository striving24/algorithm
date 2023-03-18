package day_by_day;

import java.nio.channels.DatagramChannel;
import java.util.Scanner;

/**
 * @author 马祥
 * @Package day_by_day
 * @date 2023-03-16 16:33
 * @Copyright © 2024未来可期
 * 刷题统计
 */
public class Test9 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        long a =sca.nextInt();
        long b = sca.nextInt();
        long n = sca.nextInt();
        long sum = 5*a + 2*b;
        long k = n/sum;
        n -= k*sum;
        long res = k * 7;
        for (int i = 0; i < 5; i++) {
            if (n <= 0) break;
            n -= a;
            res++;
        }
        for (int i = 0; i < 2; i++) {
            if (n <= 0) break;
            n -= b;
            res++;
        }
        System.out.println(res);
    }
}
