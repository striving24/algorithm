package difference;

/**
 * @author 马祥
 * @Package day_by_day.prefix_and.difference
 * @date 2023-02-13 19:44
 * @Copyright © 2024未来可期
 * 340、区间加法
 */
public class DifferenceArray {
    int[] getModifiedArray(int length, int[][] updates){
        //初始化数组为0
        int[] nums = new int[length];
        Difference df = new Difference(nums);

        //根据updates得到i,j,val
        for(int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int value = update[2];
            df.setNum(i,j,value);
        }
        return df.getNum();
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
