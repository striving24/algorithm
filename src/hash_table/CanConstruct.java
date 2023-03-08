package hash_table;

/**
 * @author 马祥
 * @Package hash_table
 * @date 2023-03-02 23:11
 * @Copyright © 2024未来可期
 * 383、救赎信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */

import sun.java2d.cmm.kcms.KcmsServiceProvider;

/**
 * 思路：本题很容易想到使用哈希表，题目两个字符串都是小写字母，并且最多26个字母
 * 所以使用数组代替效率更高一些
 */
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for(char c : magazine.toCharArray()){
            arr[c-'a'] +=1;
        }
        for(char c : ransomNote.toCharArray()){
            arr[c-'a'] -=1;
        }
        //判断：如果在数组中出现负数则说明不匹配，反之则true
        for (int i : arr){
            if(i < 0) return false;
        }
        return true;
    }
}
