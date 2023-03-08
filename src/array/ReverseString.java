package array;

/**
 * @author 马祥
 * @Package array
 * @date 2023-02-05 18:22
 * @Copyright © 2024未来可期
 * 344、反转字符串
 */
public class ReverseString {
    public void reverseString(char[] s) {
        //左右两个指针
        int left = 0,right = s.length - 1;
        while (left < right) {
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
    }
}
