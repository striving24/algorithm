package string;

/**
 * @author 马祥
 * @Package string
 * @date 2023-02-23 23:09
 * @Copyright © 2024未来可期
 * 151、反转字符串中的单词
 */

/**
 * 思路：
 * 1、先将字符串多余的空格删除
 * 2、讲整个字符串反转
 * 3、再将每个单词反转即可
 */
public class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder sb = removeSpaces(s);
        reverseString(sb,0,sb.length()-1);
        reverseEachWord(sb);
        return sb.toString();
    }

    //方法：1、删除多余的空格
    public StringBuilder removeSpaces(String s) {
        int start = 0,end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;

        StringBuilder sb = new StringBuilder();
        while (start <= end){
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length()-1) != ' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    //定义方法：2、反转指定区间的字符串[start,end]
    public void reverseString(StringBuilder sb,int start,int end){
        while (start < end){
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
    }

    //方法三：3、反转每个单词
    public void reverseEachWord(StringBuilder sb){
        int start = 0, end = 1;
        int n = sb.length();
        while (start < n){
            while (end < n && sb.charAt(end) != ' '){
                end++;
            }
            reverseString(sb,start,end-1);
            start = end+1;
            end = start+1;
        }
    }
}
