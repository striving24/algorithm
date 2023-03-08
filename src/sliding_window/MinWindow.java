package sliding_window;

/**
 * @author 马祥
 * @Package sliding_window
 * @date 2023-02-14 22:42
 * @Copyright © 2024未来可期
 * 76、最小覆盖子串
 */

import java.util.HashMap;

/**
 * 滑动窗口算法的思路大概为：
 * 1、我们再字符串S中使用左右指针，left = 0;right =0;分别指向第一个索引，将索引区间[left,rught)视为一个窗口，注意是左闭右开便于解题
 * 2、不断的扩大窗口[left,right),知道窗口中的元素符合要求为止
 * 3、此时，停止右边窗口移动，开始移动左边减小窗口大小，直到不满足条件为止；同时，left每次移动就更新一次结果
 * 4、重复2，3步骤直到字符串暴力完为止
 * 注：2相当于寻找可行解，3相当于优化这个解
 *
 *
 *
 *套模板时注意思考以下几个问题：
 * 1、什么时候应该移动 right 扩大窗口？窗口加入字符时，应该更新哪些数据？
 * 2、什么时候窗口应该暂停扩大，开始移动 left 缩小窗口？从窗口移出字符时，应该更新哪些数据？
 * 3、我们要的结果应该在扩大窗口时还是缩小窗口时进行更新？
 * 如果一个字符进入窗口，应该增加 window 计数器；如果一个字符将移出窗口的时候，应该减少 window 计数器；
 * 当 valid 满足 need 时应该收缩窗口；应该在收缩窗口的时候更新最终结果。
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        //定义两个哈希表，分别保存目标信息T和窗口信息W即
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        //目标信息T保存
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c,0) + 1);
        }
        //定义左右指针
        int left = 0,right = 0;
        //判断是否满足条件的辅助变量
        int valid = 0;
        //记录最小覆盖子串的初始索引和长度
        int start = 0,len = Integer.MAX_VALUE;
        while (right < s.length()){
            //进入窗口的字符
            char c = s.charAt(right);
            right++;
            //进行窗口里的数据更新
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0) + 1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            //判断左边窗口是否需要收缩
            while (valid == t.length()){
                //更新最小覆盖字串的长度
                if(right - left < len){
                    start = left;
                    len = right - left;
                }
                //d是将要移除窗口的字符
                char d = s.charAt(left);
                //缩小窗口
                left++;
                //进行窗口内的数据更新
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,need.getOrDefault(d,0) - 1);
                }
            }
        }
        //返回结果
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start + len);
    }
}
