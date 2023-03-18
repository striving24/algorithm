package lanqiao2023.simulation.match_3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 马祥
 * @Package lanqiao2023.simulation.match_3
 * @date 2023-03-12 11:36
 * @Copyright © 2024未来可期
 * 问题描述
 * 　　请找到一个大于 2022 的最小数，这个数转换成十六进制之后，所有的数位（不含前导 0）都为字母（A 到 F）。
 * 　　请将这个数的十进制形式作为答案提交。
 * 答案提交
 * 　　这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 */

//思路：从2022往后的每一个数，将他转化16进制然后每一位数都加入到一个集合中，知道符合条件为止
public class Test1 {
    public static boolean getNum(int x){
        List<Integer> num = new ArrayList<>();
        while (x > 0){
            int temp = x % 16;
            num.add(temp);
            x /= 16;
        }
        //现在num中已经是转化为16进制的数字
        for (int n : num){
            if (n < 10) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int x =2023;
        while (true){
            if (getNum(x)){
                System.out.println(x);
                return;
            }
            x++;
        }
    }
}
