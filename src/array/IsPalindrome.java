package array;

/**
 * @author 马祥
 * @Package array
 * @date 2023-02-06 12:30
 * @Copyright © 2024未来可期
 * 125、验证回文串
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。
 * 则可以认为该短语是一个 回文串 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        //分析：
        //此题和上一题相似，题目多了空格和其他字符的干扰，
        // 所以只需要先把原字符串非数字和字母的字符删除后在上一题的思路解答即可（左右指针前后判断即可）

        //1、先将源字符串转化为小写，并过滤掉非数字和字母的其他字符
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        //2、左右指针，相向向中间移动，判断
        s = sb.toString();
        int lp = 0,rp = s.length()-1;
        while (lp < rp) {
            if (s.charAt(lp) != s.charAt(rp)) {
                return false;
            }
            lp++;
            rp--;
        }
        return true;
    }
}
