package difference;

/**
 * @author 马祥
 * @Package difference
 * @date 2023-02-13 22:56
 * @Copyright © 2024未来可期
 * 1109、航班预定统计
 */

/**
 * 分析：题目表达意思其实就是一道百标准的差分数组即：nums[]初始化为0，booking[i]中的每一个元数组即为对nums[i,j]加value
 */
public class CorpFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n){
        //初始化数组为0
        int[] res = new int[n+1];
        Difference df = new Difference(res);
        //遍历得到i,j,value
        for (int[] book : bookings) {
            int i = book[0]-1;
            int j = book[1]-1;
            int value = book[2];
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
