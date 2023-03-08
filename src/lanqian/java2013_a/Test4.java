package lanqian.java2013_a;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author 马祥
 * @Package lanqian.java2013_a
 * @date 2023-02-05 15:33
 * @Copyright © 2024未来可期
 * 第四题：黄金连分数
 */
public class Test4 {
    /**
     * 思路分析：首先想到将其分开一个一个的找规律， 可以发现其分母随着精度的增加分别是：
     * 1 2 3 5 8 13 21 34 即为斐波那契数列 即为前后两数的比值（关键点一）
     * 所以就可以入手解答，题目要求精度达到100位，意思解答应该是101后面都是的稳定的，不变的(关键点2)
     * 而flout,double的精度是无法满足要求的
     * java提供了高精度的BigInteger（整数）和BigDecimal（任意精度的带符号的十进制数字）
     */
    public static void main(String[] args) {
        BigInteger a = BigInteger.ONE;// 1
        BigInteger b = BigInteger.ONE;// 1
        for (int i = 0; i < 300; i++) {
            BigInteger temp = b;
            b = b.add(a);
            a = temp;
        }
        BigDecimal res = new BigDecimal(a, 110).divide(new BigDecimal(b, 110),BigDecimal.ROUND_HALF_DOWN);
        System.out.println(res.toPlainString().substring(0,103));
        //答案：0.6180339887498948482045868343656381177203091798057628621354486227052604628189024497072072041893911375
    }
}
