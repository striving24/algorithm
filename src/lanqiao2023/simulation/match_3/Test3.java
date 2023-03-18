package lanqiao2023.simulation.match_3;

/**
 * @author 马祥
 * @Package lanqiao2023.simulation.match_3
 * @date 2023-03-12 12:10
 * @Copyright © 2024未来可期
 * 问题描述
 * 对于一个日期，我们可以计算出年份的各个数位上的数字之和，
 * 也可以分别计算月和日的各位数字之和。请问从 1900 年 1 月 1 日至 9999 年 12 月 31 日，
 * 总共有多少天，年份的数位数字之和等于月的数位数字之和加日的数位数字之和。
 * 例如，2022年11月13日满足要求，因为 2+0+2+2=(1+1)+(1+3) 。
 * 请提交满足条件的日期的总数量。
 */

/*
思路：首先想到的依然是暴力求解，遍历1900到9999所有年份，取出满足年份的各个数字之和等于月份和日的数字之和的日期
并判断是否合法
 */
public class Test3 {
    private static int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    //方法：判断日期是否合法
    public static boolean isData(int y,int m,int d){
        //闰年判断
        if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)){
            if (m == 2){
                if (d > 29) return false;
                else return true;
            }else {
                if (d > days[m]) return false;
                else return true;
            }
        }
        if (d > days[m]) return false;
        return true;
    }
    //主方法
    public static void main(String[] args) {
        int res = 0;
        //遍历年份
        for (int i = 1900; i <= 9999; i++) {
            int m = i;
            //记录年的和
            int ySum = 0;
            //将年份的每一位数取出并相加
            while (m > 0){
                ySum += m % 10;
                m /= 10;
            }
            //遍历月份
            for (int j = 1; j <= 12; j++) {
                int n1 = j;
                //记录月的和
                if (n1 >= 10) n1 -= 9;//eg:11 = 1+1 = 2 = 11-9
                for (int k = 1; k <=31 ; k++) {
                    int d = k;
                    //记录日的和
                    int n2 = 0;
                    while (d > 0){
                        n2 += d % 10;
                        d /= 10;
                    }
                    if (ySum == n1 + n2 && isData(i,j,k)) res++;
                }
            }
        }
        System.out.println(res);
    }
}
