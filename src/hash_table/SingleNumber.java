package hash_table;

import java.util.HashMap;

/**
 * @author 马祥
 * @Package hash_table
 * @date 2023-02-27 9:30
 * @Copyright © 2024未来可期
 * 136、只出现一次的数据
 */
public class SingleNumber {
    public int singleNumber1(int[] nums) {
        /**
         * 方法一；哈希表查找
         */
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer num : nums) {
            if (map.get(num) != null) {
                map.remove(num);
            }
            else {
                map.put(num, 1);
            }
        }
        return map.keySet().iterator().next();
    }

    //方法二：位运算
    /**
     * 分析：a ^ a = 0;a ^ 0 = a
     * 所以遍历结束后之剩下出现一次的数字
     */
    public int singleNumber(int[] nums){
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
