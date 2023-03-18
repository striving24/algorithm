package search_tree;

/**
 * @author 马祥
 * @Package binary_search
 * @date 2023-03-15 17:06
 * @Copyright © 2024未来可期
 */
public class DeleteNode {
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


/*
分析：本题又三种情况，1、该节点已经没有子节点
                 2、该节点只有左右子节点的其中一个
                 3、该节点有两个子节点（删除时需要维护搜搜树的特征结构）
 */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key){
            //情况一和二
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            //情况三：
            //1、先找到该节点右子树的最小值
            TreeNode minNode = minTreeNode(root.right);
            //2、当前节点替换为右子树的最小值
            root.val = minNode.val;
            //3、将右子树最小值所在的节点删除
            root.right = deleteNode(root.right,minNode.val);
        } else if (root.val < key) {
            root.right = deleteNode(root.right,key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left,key);
        }
        return root;
    }

    //获取树中的最小值
    TreeNode minTreeNode(TreeNode node){
        //BST中最左边的节点val就是最小值
        if (node.left != null) node = node.left;
        return node;
    }
}
