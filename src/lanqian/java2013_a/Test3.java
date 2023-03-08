package lanqian.java2013_a;

/**
 * @author 马祥
 * @Package lanqian.java2013_a
 * @date 2023-02-04 21:45
 * @Copyright © 2024未来可期
 */
//振兴中华
public class Test3 {
    /**
     * 思路：从左上角出发只能往又或者往下走，dps简单的深度优先搜索：
     * 先从下移动到边界为止，再从右边移动到边界为止
     * 递归思想：重复，变化，边界
     * 代码入下
     */
    public static void main(String[] args) {
        System.out.println(f(0, 0));//答案为：35种
    }

    /**
     * @param i
     * @param j
     * @return 路线种数
     */
    private static int f(int i, int j) {
        if (i == 4 || j == 3) return 1;
        return f(i+1,j) + f(i,j+1);
    }
}
