package binary_search;

/**
 * @author 马祥
 * @Package binary_search
 * @date 2023-02-08 17:27
 * @Copyright © 2024未来可期
 * 1011、在D天内送达包裹的能力
 */
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days){
        //2、确定x的取值范围，左右边界[left,right]
        //分析：x为运送能力，最小值应该为weight[i]的最大值，最大载重就是一次性载完weight[i]之和
        int left = 0,right = 1;
        for (int num :
                weights) {
            left = Math.max(left, num);
            right += num;
        }
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (f(weights,mid) <= days) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    //1、确定x f(x) target 分别代表什么
    //分析：根据题目可知，x为运算能力，f(x)为运算天数,即f(x)是关于x的单调递减函数
    //函数如下：
    int f(int[] weights,int x) {
        int days = 0;
        for (int i = 0; i < weights.length;){
            int cap = x;
            while (i < weights.length){
                if (cap < weights[i]) break;
                else cap -= weights[i];
                i++;
            }
            days++;
        }
        return days;
    }
}
