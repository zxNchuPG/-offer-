/**
 * @ClassName: 面试题18_2删除链表中重复的节点
 * @Author: 时间
 * @Description: 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
 * 例如：
 * 链表1->2->3->3->4->4->5
 * 处理后为 1->2->5
 * @Date: 2020/7/27 22:07
 * @Version: 1.0
 */
public class 面试题18_2删除链表中重复的节点 {
    public static void main(String[] args) {
        ListNode2 pHead = new ListNode2(1);
        ListNode2 node2 = new ListNode2(2);
        ListNode2 node3 = new ListNode2(3);
        ListNode2 node4 = new ListNode2(3);
        ListNode2 node5 = new ListNode2(4);
        ListNode2 node6 = new ListNode2(4);
        ListNode2 node7 = new ListNode2(5);
        pHead.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode2 result = deleteDuplication(pHead);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode2 deleteDuplication(ListNode2 pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        if (pHead.val == pHead.next.val) {
            ListNode2 temp = pHead.next;
            while (temp != null && temp.val == pHead.val) {
                temp = temp.next;
            }
            return deleteDuplication(temp);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}

class ListNode2 {
    int val;
    ListNode2 next = null;

    ListNode2(int val) {
        this.val = val;
    }
}
