package day_by_day;

import java.net.DatagramSocket;
import java.util.ResourceBundle;

/**
 * @author 马祥
 * @Package day_by_day
 * @date 2023-03-15 13:36
 * @Copyright © 2024未来可期
 * 到x星球旅行的游客都被发给一个整数，作为游客编号。x星的国王有个怪癖，他只喜欢数字3,5和7。
 * 国王规定，游客的编号如果只含有因子:3,5,7,就可以获得─份奖品。我们来看前10个幸运数字是:
 * 3，5，7，9，15，21，25 27 35，45因而第11个幸运数字是:49
 * 小明领到了一个幸运数字59084709587505，他去领奖的时候，
 * 人家要求他准确地说出这是第几个幸运数字，否则领不到奖品。
 * 请你帮小明计算一下，59084709587505是第几个幸运数字。
 */

/*
每一个数都是乘以3 5 7得到的， 第一组3 5 7 ，然后后面的又一次乘以3 5 7 得到后面的数字
具体看代码
 */
public class Test3 {
    public static void main(String[] args) {
        long n = 59084709587505L;
        int res = 0;
        for (int i = 0; Math.pow(3,i) < n; i++) {
            for (int j = 0; Math.pow(5, j) < n; j++) {
                for (int k = 0; Math.pow(7, k) < n; k++) {
                    if (Math.pow(3,i) * Math.pow(5,j) * Math.pow(7,k) < n){
                        res++;
                    }
                    else break;
                }
            }
        }
        System.out.println(res);
    }
}
