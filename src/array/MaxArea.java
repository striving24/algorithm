package array;

/**
 * @author 马祥
 * @Package array
 * @date 2023-03-06 15:10
 * @Copyright © 2024未来可期
 * 11、盛水最多的容器
 */

/**
 * 此题相比接雨水问题更直观一些，翻译过来其实就是求解面积的最大值
 * 同样对应左右指针和接雨水思路大题一致
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int res= 0;
        int left =0,right = height.length-1;
        while (left < right){
            //当前的面积
            int curArea = Math.min(height[left],height[right]) * (right-left);
            res = Math.max(res,curArea);
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }
}
