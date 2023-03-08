package array;

import com.sun.imageio.plugins.common.I18N;

/**
 * @author 马祥
 * @Package array
 * @date 2023-02-06 13:17
 * @Copyright © 2024未来可期
 * 5、最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        String res = "";
        //分别以i 、i+1 为中心寻找结果
        for (int i = 0; i < s.length(); i++) {
            //以s[i]为中心
            String s1 = palindrome(s,i,i);
            //以s[i]、s[i+1]为中心
            String s2 = palindrome(s,i, i+1);
            //根据两者长度更新答案
            res = res.length() < s1.length() ? s1 : res;
            res = res.length() < s2.length() ? s2 : res;
        }
        return res;
    }
    //先定义一个方法：寻找以l和r为中心的最长回文子串
    String palindrome(String s, int l, int r){
        //边界条件
        while (l > 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            //继续扩张
            l--;
            r++;
        }
        //返回得到的最长回文串
        return s.substring(l+1,r);
    }
}
