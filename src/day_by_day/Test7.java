package day_by_day;

import java.util.Scanner;

/**
 * @author 马祥
 * @Package day_by_day
 * @date 2023-03-16 14:55
 * @Copyright © 2024未来可期
 * 尾号评分
 */

//看作一个长度为4的字符串匹配，匹配上了加分条件就加分
public class Test7 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            char[] chars = sca.next().toCharArray();
            //条件一：连号，降序和升序
            if (chars[3] -chars[2] == 1 && chars[2] -chars[1] == 1 && chars[1] - chars[0] == 1){
                sum = sum+5;
            }
            if (chars[3] -chars[2] == -1 && chars[2] -chars[1] == -1 && chars[1] - chars[0] == -1){
                sum = sum+5;
            }
            //条件2：前三个数字相同，或后三个数字相同，都加3分。
            if (chars[2]==chars[1] && chars[1] == chars[0]){
                sum = sum+3;
            }
            if (chars[2]==chars[1] && chars[2] == chars[3]){
                sum = sum+3;
            }
            //条件3：AABB.ABAB
            if (chars[0] == chars[1] && chars[2] == chars[3]){
                sum = sum+1;
            }
            if (chars[0] == chars[2] && chars[1] == chars[3]){
                sum = sum+1;
            }
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '6' || chars[j] == '8' || chars[j] == '9'){
                    sum = sum+1;
                }
            }
            res[i] = sum;
        }
        for (int k : res) {
            System.out.println(k);
        }
    }
}
