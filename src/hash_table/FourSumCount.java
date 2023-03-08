package hash_table;

/**
 * @author 马祥
 * @Package hash_table
 * @date 2023-03-01 12:37
 * @Copyright © 2024未来可期
 * 454、四数之和
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * 本题和三数之和四数之和并不相同，本题是四个独立的数组，互不干扰，是一题标准的可用哈希表直接解决的题目
 * 哈希表记录前两个的数组的元素和，再在后两个中判断的符合条件的数组个数
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int temp = 0;
        //1、先统计两个数组的和并放入map中，记录出现的次数
        for (int i : nums1){
            for (int j : nums2){
                temp = i+j;
                if (map.containsKey(temp)){
                    map.put(temp,map.get(temp)+1);
                }else{
                    map.put(temp,1);
                }
            }
        }
        //2、再统计另外两个数组的与0-temp比较
        for (int i : nums3){
            for (int j : nums4){
                temp = i+j;
                if (map.containsKey(0-temp)){
                    res+=map.get(0-temp);
                }
            }
        }
        return res;
    }
}
