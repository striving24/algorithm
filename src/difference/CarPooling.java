package difference;

/**
 * @author 马祥
 * @Package difference
 * @date 2023-02-14 0:20
 * @Copyright © 2024未来可期
 * 1094、拼车
 */

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity){
        //车间最长为1000
        int[] nums = new int[1001];
        Difference df = new Difference(nums);
        for(int[] num : trips){
            //乘客数量
            int value = num[0];
            //乘客上车
            int i = num[1];
            //乘客下车
            int j = num[2]-1;
            df.setNum(i,j,value);
        }
        int[] res = df.getNum();
        for (int i = 0; i < res.length; i++) {
            if (res[i] > capacity) return false;
        }
        return true;
    }

    //差分数组工具类
    class Difference {
        private int[] diff;
        //初始化数组得到差分数组
        public Difference(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++)
                diff[i] = nums[i] - nums[i - 1];
        }

        //对区间[i,j]进行操作：num[i,j]的数全部加value(正负数均可)

        public void setNum(int i,int j,int value) {
            diff[i] += value;
            if (j+1 < diff.length) diff[j+1] -= value;
        }

        //返回结果数组
        public int[] getNum() {
            int[] reNum = new int[diff.length];
            reNum[0] = diff[0];
            for (int i = 1; i < diff.length; i++){
                reNum[i] = reNum[i-1] + diff[i];
            }
            return reNum;
        }
    }
}
