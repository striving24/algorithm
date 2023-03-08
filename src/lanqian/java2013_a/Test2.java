package lanqian.java2013_a;

import com.sun.xml.internal.messaging.saaj.soap.ver1_1.Detail1_1Impl;
import org.junit.Test;

/**
 * @author 马祥
 * @Package lanqian.java2013_a
 * @date 2023-02-04 20:32
 * @Copyright © 2024未来可期
 */
public class Test2 {
    /**
     * 思路：答案只需要求出有几钟组合即可
     * 暴力递推即可，注意a b c d e五个数不能相同且不包含0
     * 解题代码如下
     */
    public static void main(String[] args) {
        int result = 0;
        for (int a = 1; a < 10; a++) {
            for (int b = 1; b < 10; b++) {
                if(b!=a)
                    for (int c = 1; c < 10; c++) {
                        if (c != b && c != a)
                            for (int d = 1; d < 10; d++) {
                                if (d!=c && d!=b && d!=a)
                                    for (int e = 1; e < 10; e++) {
                                        if (e != d && e != c && e!=b && e!=a)
                                            if ((a*10+b) * (c*100+d*10+e) == (a*100+d*10+b) * (c*10+e)){
                                                result++;
                                            }
                                    }
                            }
                    }
            }
        }
        System.out.println(result);
    }
}
