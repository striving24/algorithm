package tree;

import java.util.LinkedList;

/**
 * @author 马祥
 * @Package tree
 * @date 2023-03-11 13:47
 * @Copyright © 2024未来可期
 */
public class Codec {
     public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
    //序列化得到字符串需要的辅助遍历
     String SPE = ",";
     String NULL = "#";
 //序列化 ： 遍历二叉树以字符串的形式返回
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    //辅助方法：将二叉树遍历结果存入StringBuild
    void serialize(TreeNode root,StringBuilder sb){
        if (root == null){
            sb.append(NULL).append(SPE);
            return;
        }
        //---前序位置----
        sb.append(root.val).append(SPE);
        //递归左右子树
        serialize(root.left, sb);
        serialize(root.right,sb);
    }
    //反序列化 ： 将字符串的形式以二叉树的形式返回
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(SPE)){
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    //辅助方法：通过链表构造二叉树
    TreeNode deserialize(LinkedList<String> nodes){
        if (nodes.isEmpty()){
            return null;
        }
        //-----前序位置------
        //链表左侧第一个就是根节点
        String first = nodes.removeFirst();
        if (NULL.equals(first)) return null;
        //先构造出根节点
        TreeNode root = new TreeNode(Integer.parseInt(first));

        //递归子节点
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}
