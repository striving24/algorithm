package queue_and_stack;

/**
 * @author 马祥
 * @Package queue_and_stack
 * @date 2023-03-06 11:50
 * @Copyright © 2024未来可期
 * 496、下一个更大元素I
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * 思路：与每日温度不一样的是，本题为两个数组，再另一个查找结果。本体可以翻译为吗，目标数组的每一个元素的下一个更大元素
 * 在另一个数组的是否出现，若出现则返回该值对应的下一个更大元素，此时就可想到用map存储另一个数组的信息，数组下标和对应的
 * 元素数值
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();
        //对应哈希表，存储nums1的索引和值
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums1[i],i);
        }

        //按照单调栈思路遍历nums2即可
        stack.push(0);//数组下标第一个数
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] < nums2[stack.peek()]){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && nums2[i] > stack.peek()){
                    if (map.containsKey(nums2[stack.peek()])){
                        Integer index = map.get(nums2[stack.peek()]);
                        res[index] = nums2[i];
                    }
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }
}
