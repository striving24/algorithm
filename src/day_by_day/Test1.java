package day_by_day;

import java.util.Scanner;

/**
 * @author 马祥
 * @Package day_by_day
 * @date 2023-03-14 10:22
 * @Copyright © 2024未来可期
 * 缩位求和
 */
public class Test1 {
    public static void main(String[] args) {
        int res = getRes();
        System.out.println(res);
    }
    public static int getRes(){
        //数据输入
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        //记录结果
        int res = 0;
        //遍历字符串，逐位相加（注意数据类型的转换）
        for (int i = 0; i < s.length(); i++) {
            res += Integer.parseInt(String.valueOf(s.charAt(i)));
            if (i == s.length()-1 && res/10 > 0){//求和到最后一位后如果大于9则就要重置继续求和（递归思想）
                s = String.valueOf(res);
                res = 0;//结果置零；
                i = -1;//循环结束 i 会++，所以i=-1；
            }
        }
        return res;
    }
}
