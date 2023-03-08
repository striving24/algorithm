package prefix_and;

import com.sun.imageio.plugins.common.I18N;

import java.beans.IntrospectionException;

/**
 * @author 马祥
 * @Package prefix_and
 * @date 2023-02-11 21:22
 * @Copyright © 2024未来可期
 * 238、除自身以外数组的乘积
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums){
        //思想和前缀和一样，假发变乘法即可
        //从做到右的前缀积，即nums[0,i-1]的积
        int n = nums.length;
        int[] preFix = new int[n];
        preFix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preFix[i] = preFix[i - 1] * nums[i];
        }
        //从右到左的前缀积，nums[i,n]的积
        int[] sufFix = new int[n];
        sufFix[n-1] = nums[n-1];
        for (int i = n-2; i >=0; i--) {
            sufFix[i] = sufFix[i+1] * nums[i];
        }

        //结果数组
        int[] res = new int[n];
        res[0] = sufFix[1];
        res[n-1] = preFix[n-2];
        for (int i = 1; i < n-1 ; i++) {
            //除自身外的前缀积和后缀积相乘即可
            res[i] = preFix[i-1] * sufFix[i+1];
        }
        return res;
    }
}
