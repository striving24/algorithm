package string;

import sun.nio.cs.ext.JIS_X_0201;

/**
 * @author 马祥
 * @Package string
 * @date 2023-02-25 9:59
 * @Copyright © 2024未来可期
 * 28. 找出字符串中第一个匹配项的下标
 * 经典算法KMP
 */
public class StrStr {

    class KMP{
        private int[][] dp;
        private String pat;

        public KMP(String pat){
            this.pat = pat;
            int M = pat.length();
            //dp[状态][字符] = 下一个状态
            dp = new int[M][256];
            //base case
            dp[0][pat.charAt(0)] = 1;
            //初始化影子状态
            int X = 0;
            //构建状态转移图
            for (int j = 1; j < M; j++) {
                for (int c = 0; c < 256; c++) {
                    if (pat.charAt(j) == c ){
                        dp[j][c] = j+1;
                    }else{
                        dp[j][c] = dp[X][c];
                    }
                    //更新影子的状态
                    X = dp[X][pat.charAt(j)];
                }
            }
        }

        public int search(String txt) {
            int M = pat.length();
            int N = txt.length();
            //pat的初始状态为0
            int j = 0;
            for (int i = 0; i < N; i++) {
                //计算pat的下一个状态
                j = dp[j][txt.charAt(i)];
                //如到达终止状态则返回suoyin
                if (j == M) return i - M + 1;
            }
            //没到达则匹配失败
            return -1;
        }
    }
    public int strStr1(String txt, String pat) {
        KMP kmp = new KMP(pat);
        return kmp.search(txt);
    }

    //方式二：有助于理解清楚next[]数组的实现与作用
    public int strStr(String txt, String pat) {
        //如果pat为空则返回0；
        int n = pat.length();
        if (n == 0) return 0;
        //构造next[]数组
        int[] next = new int[n];
        //定义左右指针，left为最长相同前缀的下一个，同时也是其长度，同理right
        //为后缀的下一个
        for (int right = 1,left = 0; right < n; right++) {
            //在for循环中初始化i=0,j=1,i总在j的后面
            while (left > 0 && pat.charAt(left) != pat.charAt(right)){
                //不相等就将left回退，到0则停
                left = next[left-1];//回退操作
            }
            if (pat.charAt(left) == pat.charAt(right)){
                left++;
            }
            next[right] = left;
        }

        //开始进行匹配
        for (int i = 0,j = 0; i < txt.length(); i++) {
            while (j > 0 && txt.charAt(i) != pat.charAt(j)){
                //回退
                j = next[j-1];
            }
            if (txt.charAt(i) == pat.charAt(j)){
                j = j+1;//前进
            }
            if (j == n) return i-n+1;
        }
        return -1;
    }
}
