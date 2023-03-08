package string;

/**
 * @author 马祥
 * @Package string
 * @date 2023-02-23 22:36
 * @Copyright © 2024未来可期
 * 541、反转字符串2
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */

/**
 * 每隔2K个就反转前K个，尾数不够K时，就全部反转
 */
public class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length();i+=2*k){
            int start = i;
            int end = Math.min(s.length()-1,start+k-1);
            //反转操作
            while (start < end){
                c[start] ^= c[end];
                c[end] ^= c[start];
                c[start] ^= c[end];
                start++;
                end--;
            }
        }
        return new String(c);
    }
}
