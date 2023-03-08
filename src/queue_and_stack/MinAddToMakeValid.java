package queue_and_stack;

/**
 * @author 马祥
 * @Package queue_and_stack
 * @date 2023-03-05 13:00
 * @Copyright © 2024未来可期
 * 921、使括号有效的最少添加
 */
public class MinAddToMakeValid {
    public int minAddToMakeValid(String s) {
        //结果（需要添加的最少括号）
        int res = 0;
        //记录右括号的需求量
        int need = 0;
        for (int i = 0; i < s.length();i++){
            if (s.charAt(i) == '('){
                need++;
            }
            if (s.charAt(i) == ')'){
                need--;
                if (need == -1){
                    need = 0;
                    //需要添加一个左括号
                    res++;
                }
            }
        }
        return res += need;
    }
}
