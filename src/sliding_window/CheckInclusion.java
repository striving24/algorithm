package sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 马祥
 * @Package sliding_window
 * @date 2023-02-15 22:00
 * @Copyright © 2024未来可期
 * 567、字符拆的排列
 */
public class CheckInclusion {
    //套用最小覆盖子串的代码即可，改变一下缩小窗口的条件，这里应该再right-letf > t.size()时就开始
    //然后==就返回true
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        //将目标元素存入need中
        for (char c : s1.toCharArray()){
            need.put(c, need.getOrDefault(c,0) + 1);
        }
        //左右窗口指针
        int left = 0,right =0;
        int count = 0;//记录符合条件的元素个数
        //int start = 0,len = Integer.MAX_VALUE;//记录窗口初始索引和长度(此处不需要)

        //一次遍历
        while (right < s2.length()){
            //进入窗口的字符
            char c = s2.charAt(right);
            right++;
            //窗口里的字符更新
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c,0) +1);
                if (need.get(c).equals(window.get(c))){
                    count++;
                }
            }

            //左窗口的缩短判断与更新
            while (right - left >= s1.length()){
                //在这里判断是否找到合法的字符串
                if (count == need.size()) return true;
                //移除的字符
                char d = s2.charAt(left);
                //窗口缩小
                left++;
                //窗口更新
                if (need.containsKey(d)){
                    if (need.get(d).equals(window.get(d)))
                        count--;
                    window.put(d, window.getOrDefault(d,0) - 1);
                }
            }
        }
        return false;
    }
}
