/**
 * @ClassName: 二叉树中的下一个节点
 * @Author: 时间
 * @Description: 给定一个二叉树和其中的一个结点，请找出中序（左根右）遍历顺序的下一个结点并且返回,如果给定的节点是中序遍历序列的最后一个，则返回空节点
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
 * 假定二叉树层序遍历是：[2,1,3,null,null,null]
 * __2
 * 1___3
 * 给出的值事等于2的节点
 * 则返回值等于3的节点
 * @Date: 2020/7/25 23:43
 * @Version: 1.0
 */
public class 面试题08二叉树中的下一个节点 {
    public static void main(String[] args) {
        TreeLinkNode head = new TreeLinkNode(2);
        TreeLinkNode leftNode = new TreeLinkNode(1);
        TreeLinkNode rightNode = new TreeLinkNode(3);
        leftNode.left = null;
        leftNode.right = null;
        leftNode.father = head;
        rightNode.left = null;
        rightNode.right = null;
        rightNode.father = head;
        head.left = leftNode;
        head.right = rightNode;
        head.father = null;
        TreeLinkNode result = GetNext(head);
        System.out.println(result.val.toString());
    }

    /**
     * 思路：根据中序（左根右）遍历特点
     *
     * @param pNode
     * @return
     */
    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        // 若给定节点 有右子树， 则返回的一定是 右子树 最左边的节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }

        // 若没有右子树 则返回的是 父亲节点
        while (pNode.father != null) {
            if (pNode.father.left == pNode) { // 父亲节点的左节点等于本身，且本身没有右节点，那么直接返回父节点
                return pNode.father;
            }
            pNode = pNode.father; // 父亲节点的左节点不等于本身，说明本身在父节点的右子节点，继续遍历父亲节点的父节点
        }
        return null;
    }
}

class TreeLinkNode {
    Integer val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode father = null;

    TreeLinkNode(Integer val) {
        this.val = val;
    }
}
