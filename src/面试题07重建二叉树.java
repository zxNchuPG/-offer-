/**
 * @ClassName: 面试题07重建二叉树
 * @Author: 时间
 * @Description: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 * 例如输入前序遍历序列{3,9,20,15,7}和中序遍历序列{9,3,15,20,7}
 * 则重建二叉树并返回 （层序）
 * ___3
 * 9  ___20
 * ___15  __7
 * [3,9,20,null,null,15,7]
 * @Date: 2020/7/24 23:51
 * @Version: 1.0
 */
public class 面试题07重建二叉树 {
    public static void main(String[] args) {

    }

    /**
     * 思路：树 首先想到的是递归
     *
     * @param pre
     * @param in
     * @return
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return null;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}