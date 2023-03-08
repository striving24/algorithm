package queue_and_stack;

/**
 * @author 马祥
 * @Package queue_and_stack
 * @date 2023-03-05 13:15
 * @Copyright © 2024未来可期
 * 1541. 平衡括号字符串的最少插入次数
 */
public class MinInsertions {
    public int minInsertions(String s) {
        //记录需要插入的最少次数
        int res = 0;
        //记录右括号的需求量
        int need = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                need += 2;
                if (need % 2 == 1) {
                    //因为右括号的数量必须为偶数，为基数时补上一个，然后need减一
                    res++;
                    need--;
                }
            }
            if (s.charAt(i) == ')'){
                need--;
                if (need == -1){
                    //右括号多了，此时need数量只需一个即可
                    need = 1;
                    //左括号加一，右括号也只需要加一
                    res++;
                }
            }
        }
        return res += need;
    }
}
