package lanqian.java2013_a;

/**
 * @author 马祥
 * @Package lanqian.java2013_a
 * @date 2023-02-05 16:16
 * @Copyright © 2024未来可期
 * 第六题：三部排序
 */
public class Test6 {
    static void sort(int[] x){
        int p = 0;
        int left = 0;
        int right = x.length - 1;

        while (p <= right) {
            if (x[p] < 0){
                int t = x[left];
                x[left] = x[p];
                x[p] = t;
                left++;
                p++;
            }
            else if (x[p] > 0) {
                int t = x[right];
                x[right] = x[p];
                x[p] = t;
                right--;//所填答案
            }
            else{
                p++;
            }
        }
    }

    public static void main(String[] args) {
        int[] x = {23,45,1,3,-23,-1,0,12,23,-9};
        sort(x);
        for (int res :x) {
            System.out.print(res+"\t");
        }
    }
}
