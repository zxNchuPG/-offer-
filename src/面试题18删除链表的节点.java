/**
 * @ClassName: 面试题18删除链表的节点
 * @Author: 时间
 * @Description: 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点，返回删除后的链表的头节点
 * 示例：
 * 输入head=[4,5,1,9] val = 5
 * 输出 [4,1,9]
 * @Date: 2020/7/27 21:10
 * @Version: 1.0
 */
public class 面试题18删除链表的节点 {
    public static void main(String[] args) {
        ListNode1 head = new ListNode1(4);
        ListNode1 node2 = new ListNode1(5);
        ListNode1 node3 = new ListNode1(1);
        ListNode1 node4 = new ListNode1(9);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode1 result = deleteNode(head, 5);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    /**
     * 前一个节点指向当前节点的下一个节点
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode1 deleteNode(ListNode1 head, int val) {
        // 第一个节点单独讨论
        if (head.val == val) {
            return head.next;
        }
        ListNode1 pre = head;
        ListNode1 cur = head.next;
        // 遍历链表
        while (cur.val != val && cur != null) {
            pre = cur;
            cur = cur.next;
        }

        // 找到了val 或者 走到了头
        if (cur != null) {
            pre.next = cur.next;
        }
        return head;
    }
}

class ListNode1 {
    int val;
    ListNode1 next = null;

    ListNode1(int val) {
        this.val = val;
    }
}
