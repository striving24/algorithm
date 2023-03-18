package day_by_day;

import java.util.Scanner;

/**
 * @author 马祥
 * @Package day_by_day
 * @date 2023-03-15 14:47
 * @Copyright © 2024未来可期
 * 修建灌木（2022年省赛）
 * 有 N 棵灌木整齐的从左到右排成一排。爱丽丝在每天傍晩会修剪一棵灌 木,
 * 让灌木的高度变为 0 厘米。爱丽丝修剪灌木的顺序是从最左侧的灌木开始,
 * 每天向右修剪一棵灌木。当修剪了最右侧的灌木后, 她会调转方向, 下一天开 始向左修剪灌木。
 * 直到修剪了最左的灌木后再次调转方向。然后如此循环往复。
 * 灌木每天从早上到傍晩会长高 1 厘米, 而其余时间不会长高。在第一天的 早晨,
 * 所有灌木的高度都是 0 厘米。爱丽丝想知道每棵灌木最高长到多高。
 */
/*
灌木丛只要一被修剪，高度就变为0，那么在下一次修建之前，轮到修建自己的时间越长就长的越高，
最大长度即为，即将修建的哪个晚上，看他离那边比较远
 */
public class Test6 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();
        for (int i = 1; i <= n ; i++) {
            int max = Math.max(i-1,n-i);
            System.out.println(max*2);
        }
    }
}
