package tree;
/**
 * @author 马祥
 * @Package tree
 * @date 2023-03-08 16:24
 * @Copyright © 2024未来可期
 */
import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 */
public class PreorderTraversal {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root,res);
        return res;
    }
    //1、确定递归函数的参数和返回值：因为要遍历得到节点的数值（val）,即节点和它的值是需要处理的，传入节点和一个结果
    //数组来保存节点的数值，不需要由返回值
    public void traverse(TreeNode root, List<Integer> result) {
        //2、确定终止条件：显而易见，节点为null时就终止
        if (root == null){
            return;
        }
        result.add(root.val);//中
        //3、单次递归的逻辑：前序遍历就顺序为 中 左 右
        traverse(root.left,result);//左
        traverse(root.right,result);//右
    }
}
