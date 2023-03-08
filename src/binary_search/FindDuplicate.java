package binary_search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.CheckedOutputStream;

/**
 * @author 马祥
 * @Package binary_search
 * @date 2023-02-06 22:30
 * @Copyright © 2024未来可期
 * 287、寻找重复数
 */
public class FindDuplicate {
    //方法一；哈希表
    public int findDuplicate1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.get(num) == null) {
                map.put(num, 1);
            }
            else {
                return num;
            }
        }
        return -1;
    }

    //方法二：哈希优化
    public int findDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)){
                return num;
            }
            else {
                set.add(num);
            }
        }
        return -1;
    }

    //方法三：排序遍历
    public int findDuplicate3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }

    //方法四：二分查找
    public int findDuplicate4(int[] nums) {
        /**
         * 思路分析：抽屉原理（思想切入是难点所在）
         * 如果重复数（比如叫做target）只出现两次，那么其实就是1~N所有数都出现了一次，然后再加一个target；
         * 如果重复数target出现多次，那在情况1的基础上，它每多出现一次，就会导致1~N中的其它数少一个。
         * 以target为界，
         * 对于比target小的数i，数组中所有小于等于它的数，最多出现一次（有可能被多出现的target占用了），
         * 所以总个数不会超过i。
         * 对于比target大的数j，如果每个元素都只出现一次，那么所有小于等于它的元素是j个；
         * 而现在target会重复出现，所以总数一定会大于j。
         */
        int left = 1;
        int right = nums.length-1;
        while (left <= right) {
            int count = 0;
            int mid = left + (right-left)/2;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] <= i)
                    count++;
                }
                //判断count[i]和i 的关系
                if (count <= mid){
                    left = mid + 1;
                }
                else
                    right = mid;
                //找到target
                if (left == right) {
                    return left;
                }
        }
        return -1;
    }
}
