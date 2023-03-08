package sliding_window;

/**
 * @author 马祥
 * @Package sliding_window
 * @date 2023-02-17 14:32
 * @Copyright © 2024未来可期
 * 395. 至少有 K 个重复字符的最长子串
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度
 */

/**
 *本题中我们要尽可能的扩大查看，增加字符，由于题目没有限制字符种类的数目，所以无法判断查看缩小的条件
 * 可以自己添加一个限制条件，每个字符的数量不少于K次，并且仅包含conut钟字符，就可以使用滑动窗口框架解决
 * 因为count最多也只是26钟，所注可以遍历1-26钟情况找出最大值即可
 */
public class LongestSubstring {
    public int longestSubstring(String s, int k) {
        int finalLength = 0;
        for (int i = 0; i < 26; i++) {
            finalLength = Math.max(finalLength,longestSubstringEach(s,k,i));
        }
        return finalLength;
    }
    //寻找S中仅包含count钟字符并且每种字符的数量大于等于k
    int longestSubstringEach(String s, int k,int count) {
        int res = 0;
        int left = 0,right = 0;
        //记录窗口中的字符，最多26钟
        int[] window = new int[26];
        //记录某个字符出现的次数
        int sCount = 0;
        //记录出现达标字符的数量（k）
        int vCount = 0;
        //滑窗模板
        while (right < s.length()){
            //移入字符，扩大窗口
            char c = s.charAt(right);
            if (window[c-'a'] == 0){
                //新的字符出现
                sCount++;
            }
            window[c-'a']++;
            if (window[c-'a'] == k){
                //达标的字符
                vCount++;
            }
            right++;

            //当窗口字符的种类 > count时，缩小窗口
            while (sCount > count){
                //移除的字符
                char d = s.charAt(left);
                if (window[d-'a'] == k){
                    //达标字符减一
                    vCount--;
                }
                window[d-'a']--;
                if (window[d-'a'] ==0){
                    //减少一种字符
                    sCount--;
                }
                left++;
            }
            // 当窗口中字符种类为 count 且每个字符出现次数都满足 k 时，更新答案
            if (vCount == count) {
                res = Math.max(res, right - left);
            }
        }
        return res;
    }
}
