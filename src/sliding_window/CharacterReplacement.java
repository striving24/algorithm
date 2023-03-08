package sliding_window;

/**
 * @author 马祥
 * @Package sliding_window
 * @date 2023-02-16 20:51
 * @Copyright © 2024未来可期
 * 424、替换后的最长重复字符
 */

import java.security.cert.CertPathValidatorException;

/**
 * 此题和最大连续1的子数组类似，三个点基本一样
 * 变试：找出最大的重复子字符串，该子字符串最多有K个其他字符
 */
public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        //记录窗口中每个字母的出现次数
        int[] count = new int[26];
        //记录窗口中某字母重复出现的次数，则其他字符的个数即可计算：right-left -count
        int window = 0;
        int left = 0,right = 0;
        int res = 0;
        while (right < s.length()){
            //扩大窗口
            count[s.charAt(right)-'A']++;
            window = Math.max(window, count[s.charAt(right)-'A']);
            right++;

            while (right - left - window > k){
                //缩小窗口
                count[s.charAt(left)-'A']--;
                left++;
            }
            res = Math.max(res,right-left);
        }
        return res;
    }
}
