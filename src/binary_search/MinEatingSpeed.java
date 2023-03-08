package binary_search;
/**
 * @author 马祥
 * @Package binary_search
 * @date 2023-02-08 16:25
 * @Copyright © 2024未来可期
 * 875、爱吃香蕉的珂珂
 *
 */
public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h){
        //2、确定自变量的取值范围，明确[left,right]
        //分析：根据题目珂珂最小速度是1，而最大速度没有明确，但是题目又说到<100000000
        int left = 1,right = 1000000000+1;
        //3、根据题目要求可知求左边界（最小速度）
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(piles,mid) >= h) {
                right = mid;
            }else
            left = mid+1;
        }
        return left;
    }
    //1、确定 x f(x) target分别是什么，并写出f函数
    //分析可知：该题中珂珂吃香的速度K越快，所需要的时间x越少,即k为关于x单调递减的函数
    int f(int[] piles,int x) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i]/x;
            if (piles[i] % x > 0)
                hours++;
        }
        return hours;
    }
}
