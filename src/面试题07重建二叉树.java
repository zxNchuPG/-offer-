import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName: 面试题07重建二叉树
 * @Author: 时间
 * @Description: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 * 例如输入前序（根左右）遍历序列{3,9,20,15,7}和中序（左根右）遍历序列{9,3,15,20,7}
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
        // 用递归的方法反转链表
        Node head = new Node(1);
        Node node2 = new Node(2);
        head.next = node2;
        Node node3 = new Node(3);
        node2.next = node3;
        Node node4 = new Node(4);
        node3.next = node4;
        Node node5 = new Node(5);
        node4.next = node5;
        Node newNode = reverseList2(head);
        while (newNode != null) {
            System.out.println(newNode.date);
            newNode = newNode.next;
        }

        // 重建二叉树
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        TreeNode node = reConstructBinaryTree(pre, in);
    }

    /**
     * 思路：树 首先想到的是递归
     *
     * @param pre
     * @param in
     * @return
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    /**
     * 前序遍历{3,9,20,15,7}和中序遍历序列{9,3,15,20,7}
     * <p>
     * 每次将左右两颗子树当成新的子树进行处理，中序的左右子树索引很好找
     * 前序的开始结束索引通过计算中序中左右子树的大小来计算，然后递归求解，直到startPre>endPre||startIn>endIn说明子树整理完到。方法每次返回左子树活右子树的根节点
     *
     * @param pre
     * @param startPre
     * @param endPre
     * @param in
     * @param startIn
     * @param endIn
     * @return
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }

    //用递归的方法反转链表
    public static Node reverseList2(Node head) {
        // 1.递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
        // 递归反转 子链表
        Node newList = reverseList2(head.next);
        // 改变 1，2节点的指向。
        // 通过 head.next获取节点2
        Node t1 = head.next;
        // 让 2 的 next 指向 2
        t1.next = head;
        // 1 的 next 指向 null.
        head.next = null;
        // 把调整之后的链表返回。
        return newList;
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

class Node {
    int date;
    Node next;

    Node(int d) {
        date = d;
    }
}