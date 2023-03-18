package day_by_day;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author 马祥
 * @Package day_by_day
 * @date 2023-03-15 14:31
 * @Copyright © 2024未来可期
 * 本题为填空题，只需要算出结果后，在代码中使用输出语句将所填结果输出即可。
 * 小蓝要把一个字符串中的字母按其在字母表中的顺序排列。
 * 例如，LANQIAO 排列后为 AAILNOQ。
 * 又如，GOODGOODSTUDYDAYDAYUP 排列后为 AADDDDDGGOOOOPSTUUYYY。
 * 请问对于以下字符串，排列之后字符串是什么？
 * WHERETHEREISAWILLTHEREISAWAY
 */
public class Test5 {
    public static void main(String[] args) {
        String s = "WHERETHEREISAWILLTHEREISAWAY";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        System.out.println(new String(chars));
    }
}
