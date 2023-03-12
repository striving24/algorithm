package lanqiao2023.simulation.match_3;

import java.util.Scanner;

/**
 * @author 马祥
 * @Package lanqiao2023.simulation.match_3
 * @date 2023-03-12 16:11
 * @Copyright © 2024未来可期
 *
 * 问题描述：给定一天是一周中的哪天，请问 n 天后是一周中的哪天？
 * 输入格式
 * 　　输入第一行包含一个整数 w，表示给定的天是一周中的哪天，w 为 1 到 6 分别表示周一到周六，w 为 7 表示周日。
 * 　　第二行包含一个整数 n。
 * 输出格式
 * 　　输出一行包含一个整数，表示 n 天后是一周中的哪天，1 到 6 分别表示周一到周六，7 表示周日。
 * 样例输入
 * 6
 * 10
 * 样例输出
 * 2
 * 评测用例规模与约定
对于所有评测用例，1 <= n <= 1000000。
 */

//思路：将输入的两个数相加并取余数即可，若余数为0则单独输出周日
public class Test6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int res = (n+m) % 7;
        if (res == 0) res = 7;
        System.out.println("今天周"+m+","+n+"天后周"+res);
    }
}
