package hash_table;

/**
 * @author 马祥
 * @Package hash_table
 * @date 2023-03-01 12:23
 * @Copyright © 2024未来可期
 * 202、快乐数
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 但我们遇到要判断一个数是否存在一个集合中时就考虑使用哈希表
 * 在此题中要不断的记录sum，若重复出现则说明不是快乐数，直到出现1为止即为快乐数
 */
public class IsHappy {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = nextNum(n);
        }
        return n==1;
    }

    //定义方法：得到下一个num
    public int nextNum(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}
