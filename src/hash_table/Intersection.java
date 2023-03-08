package hash_table;

/**
 * @author 马祥
 * @Package hash_table
 * @date 2023-02-27 11:03
 * @Copyright © 2024未来可期
 * 349、两个数组的交集
 */

import java.util.HashSet;

/**
 * 思路：nums1的元素使用HashSet存储，再遍历nums2看其中再nums1中是否存在，存在则加入结果数组
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)){
                res.add(num);
            }
        }

        //转换一下返回数据
        int[] falRes = new int[res.size()];
        int j = 0;
        for (int n : res){
            falRes[j++] = n;
        }
        return falRes;
    }
}
