package lanqiao2023.simulation.match_3;

/**
 * @author 马祥
 * @Package lanqiao2023.simulation.match_3
 * @date 2023-03-12 11:47
 * @Copyright © 2024未来可期
 * 问题描述
 * 在 Excel 中，列的名称使用英文字母的组合。前 26 列用一个字母，依次为 A 到 Z，
 * 接下来 26*26 列使用两个字母的组合，依次为 AA 到 ZZ。
 * 请问第 2022 列的名称是什么？
 * 答案提交
 * 这是一道结果填空的题，你只需要算出结果后提交即可。
 * 本题的结果为一个由大写字母组成的字符串，在提交答案时只填写这个字符串，填写多余的内容将无法得分。
 */

//思路：简单计算可以发现，2022 > 26*26,即为三个字母组成的，直接暴力。代码如下
public class Test2 {
    public static void main(String[] args) {
        int x = 2022 - 26*26 -26;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    x--;
                    if (x == 0){
                        System.out.println((char) ('a'+i) + " " + (char) ('a'+j) + " " + (char) ('a'+k) + " ");
                    }
                }
            }
        }
    }
}
