package lanqiao.java2017_b;

/**
 * @author 马祥
 * @Package lanqiao.java2017_b
 * @date 2023-03-07 15:23
 * @Copyright © 2024未来可期
 */
public class Test5 {
    static int len(int x){	// 返回多少位
        if(x<10) return 1;
        return len(x/10)+1;
    }
    // 取x的第k位数字
    static int f(int x, int k){	//数字 第几位数23513
        if(len(x)-k == 0) return x%10;	//如果是最后一位数
        return f(x/10,k); //填空(如果不是最后一位，将最后一位数去除，递归操作)
    }
    public static void main(String[] args) {
        int x = 295631;
        System.out.println(f(x,4));//6
    }
}
