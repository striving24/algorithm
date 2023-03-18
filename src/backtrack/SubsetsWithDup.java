package backtrack;

import com.sun.jmx.snmp.agent.SnmpMibOid;
import com.sun.xml.internal.ws.addressing.v200408.MemberSubmissionWsaClientTube;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.invoke.VolatileCallSite;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 马祥
 * @Package backtrack
 * @date 2023-03-18 12:42
 * @Copyright © 2024未来可期
 * 90,子集II
 */
public class SubsetsWithDup {
    //记录结果
    List<List<Integer>> res = new LinkedList<>();
    //记录回溯算法中递归的路径
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //先将数字进行排序
        Arrays.sort(nums);
        backtrack(nums,0);
        return res;
    }

    //回溯算法框架
    void backtrack(int[] nums,int start){
        //前序位置，每一个节点的值都是子集
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            //剪枝逻辑，把值相同的树枝减去
            if (i > start && nums[i] == nums[i-1]){
                continue;//跳过
            }
            //做选择
            track.addLast(nums[i]);
            //递归进入下一个
            backtrack(nums,i+1);
            //回溯，选择撤销
            track.removeLast();
        }
    }
}
