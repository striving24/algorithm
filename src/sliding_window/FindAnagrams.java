package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 马祥
 * @Package sliding_window
 * @date 2023-02-15 22:30
 * @Copyright © 2024未来可期
 * 438、找到字符串中所有字母的异位
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c,0) + 1);
        }

        int left = 0,right = 0;
        int count = 0;
        //结果数组
        ArrayList<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            //进入的字符
            char c = s.charAt(left);
            //右边扩大窗口
            right++;
            //更新
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0) + 1);
                if (need.get(c).equals(window.get(c))){
                    count++;
                }
            }
            //左边
            while (right - left >= p.length()) {
                if (count == need.size())
                    res.add(left);
                //移除的字符
                char d = s.charAt(right);
                left++;
                //更新
                if (need.containsKey(d)){
                    if (need.get(d).equals(window.get(d))){
                        count--;
                    }
                    window.put(d, window.getOrDefault(d,0) - 1);
                }
            }
        }
        return res;
    }
}
