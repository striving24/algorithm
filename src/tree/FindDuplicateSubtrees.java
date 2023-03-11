package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 马祥
 * @Package tree
 * @date 2023-03-11 14:40
 * @Copyright © 2024未来可期
 * 652. 寻找重复的子树
 */
public class FindDuplicateSubtrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
    分析：根据上一题拓展思维，需要知道每一个以自己为根节点的树的具体情况（遍历）
    而具体情况就可以序列化实现存入一个数据结构中再来判断结果
     */
    //记录所有子树出现的次数
    HashMap<String, Integer> alltree = new HashMap<>();
    //记录重复的子树节点（结果集）
    LinkedList<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }
    //后续遍历框架
    String traverse(TreeNode root){
        if (root == null){
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        //连接起来
        String sub = left + "," + right + "," + root.val;
        //默认值
        int num = alltree.getOrDefault(sub,0);
        //只要多出现就加入结果集，只加一次
        if (num == 1){
            res.add(root);
        }
        alltree.put(sub,num+1);
        return sub;
    }
}
