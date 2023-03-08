package lanqiao.java2017_b;

/**
 * @author 马祥
 * @Package lanqiao.java2017_b
 * @date 2023-03-01 23:06
 * @Copyright © 2024未来可期
 * 2、纸牌三角形
 * 标签：三角形
 */
public class Test2 {
    static int res = 0;
    public static void DFS(int[] arr,int k){
        if (k == arr.length-1){
            //判断三边和是否相等
            if (arr[0] + arr[1] + arr[2] + arr[3] == arr[3] + arr[4] + arr[5] + arr[6] && arr[0] + arr[1] + arr[2] + arr[3] == arr[6] + arr[7] + arr[8] + arr[0]){
                res++;
            }
        }
        int temp = 0;
        //k为代表要与后面元素交换的当前位置
        for (int i = k; i < arr.length; i++) {
            temp = arr[k];
            arr[k] = arr[i];
            arr[i] = temp;
            //递归
            DFS(arr, k + 1);
            //回溯
            {
                temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        DFS(arr, 0);
        System.out.println(res/6);//除去旋转3钟，镜像2钟
    }
}
