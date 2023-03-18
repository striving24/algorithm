package day_by_day;

import org.junit.Test;

/**
 * @author 马祥
 * @Package day_by_day
 * @date 2023-03-16 17:18
 * @Copyright © 2024未来可期
 * 超级质数
 */
public class Test10 {
    public static void main(String[] args) {
        for (int i = 1000; i > 2; i--) {
            if (isAllPrime(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    //判断是否是超级质数
    static boolean isAllPrime(int n){
        if (!isPrime(n)) return false;
        while (n > 0){
            //依次取出最后一位来判断
            if (!isPrime(n%10)){
                return false;
            }
            n /= 10;
        }
        return true;
    }
    //判断一个数字是否是质数
    static boolean isPrime(int k){
        if (k == 1) return false;
        for (int i = 2; i < k/2; i++) {
            if (k%i == 0) return false;
        }
        return true;
    }
}
