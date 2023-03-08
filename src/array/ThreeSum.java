package array;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author 马祥
 * @Package array
 * @date 2023-02-04 19:28
 * @Copyright © 2024未来可期
 * 力扣第15题：三数之和
 */
public class ThreeSum {
    /*
    * 方法一：暴力
    * 三层for循环遍历相加判断结果即可，时间复杂度为O三次方，还需要做去重处理
    * 逻辑比较清晰，但复杂度较高，不建议使用此方法
    * */

    //方法二：双指针法
    //思路；先将整个数组进行排序（复杂度：nlogn），遍历数组i指针下的数分别作为参照数，定义左右指针，分别指向i+1、nums.length
    //根据结果来移动指针，直到找到结果，并满足循环结束的条件

    public List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;
        //结果数组
        List<List<Integer>> result = new ArrayList<>();
        //1、数组排序
        Arrays.sort(nums);
        //2、遍历数组，以nums[i]分别作为计算结果的参照数，（最小数依次增加）
        for (int i = 0; i < n; i++) {
            //2.1特殊情况1：如果nums[i]大于0，则直接结束
            if (nums[i] > 0) break;
            //2.2特殊情况2：如果nums[i]=nums[i-1],则跳过继续遍历
            if (i > 0 && nums[i] == nums[i-1]) continue;
            //2.3正常情况：
            //2.3.1定义左右两个指针
            int lp = i+1;//i之后
            int rp = n-1;//最后
            while (lp < rp) {
                int sum = nums[i] + nums[lp] + nums[rp];
                //2.3.2判断结果
                if(sum == 0){
                    result.add(Arrays.asList(nums[i] , nums[lp] , nums[rp]));
                    lp++;
                    rp--;
                    //注意判断一下，如果移动之后和前一个数相同则跳过,即指针继续移动
                    while (lp < rp && nums[lp] == nums[lp-1]) lp++;
                    while (lp < rp && nums[rp] == nums[rp+1]) rp--;
                } else if (sum < 0) {
                    //和较小，左指针右移动，增大
                    lp++;
                }
                else
                    rp--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //测试
        int[] nums = {-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> list = threeSum.threeSum(nums);
        System.out.println(list);//结果[[-1, -1, 2], [-1, 0, 1]]
    }
}
