package array;

import java.util.HashMap;

/**
 * @author 马祥
 * @Package 数组.两数之和1
 * @date 2023-02-02 23:57
 * @Copyright © 2024未来可期
 */
public class TwoSum {
    /**
     * @param nums
     * @param target
     * @return
     * 暴力法
     * 时间复杂度：O二次方（不建议）
     */
    public int[] twoSum1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
    //方法二：哈希表两次遍历
    public int[] twoSum2(int[] nums, int target){
        //1、定义一个哈希表
        HashMap<Integer, Integer> map = new HashMap<>();
        //2、遍历数组，将所有数字信息保存在哈希表中
        for (int i = 0;i < nums.length;i++){
            map.put(nums[i],i);
        }
        //3、再次遍历数组，只需要找哈希表中是否存在target-nums[i]数即可（并且保证不重复）
        for (int j = 0;j < nums.length;j++){
            int resNum = target - nums[j];
            if(map.containsKey(resNum) && map.get(resNum) != j){
                return new int[]{j,map.get(resNum)};
            }
        }
        return new int[0];
    }

    //方法三：哈希表一次遍历（优化-最佳解法）
    public int[] twoSum(int[] nums, int target){
        //1、定义一个哈希表
        HashMap<Integer, Integer> map = new HashMap<>();
        //2、遍历数组，只需要找哈希表中是否存在target-nums[i]数即可,没有则将其放入哈希表中继续遍历即可
        for (int j = 0;j < nums.length;j++){
            int resNum = target - nums[j];
            if(map.containsKey(resNum) && map.get(resNum) != j){
                return new int[]{map.get(resNum),j};
            }
            map.put(nums[j],j);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,9,45};
        int target = 13;
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(nums, target);
        for (int res :ints) {
            System.out.println(res);
        }
    }
}
