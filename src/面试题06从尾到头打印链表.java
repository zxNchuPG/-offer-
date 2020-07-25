import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: 面试题06从尾到头打印链表
 * @Author: 时间
 * @Description: 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 * 示例：输出 [1,3,2]
 * 输出[2,3,1]
 * @Date: 2020/7/24 22:52
 * @Version: 1.0
 */
public class 面试题06从尾到头打印链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node2;
        ListNode node3 = new ListNode(1);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;

        System.out.println("===================== 解法一 用栈 ====================");
        List<Integer> list = printListFromTailToHeadUseStack(head);
        list.forEach(obj -> System.out.println(obj));

        System.out.println("===================== 解法二 不用栈====================");
        list = printListFromTailToHeadIgnoreStack(head);
        list.forEach(obj -> System.out.println(obj));

        System.out.println("===================== 解法三 用递归====================");
        list = printListFromTailToHeadUseRecursion(head);
        list.forEach(obj -> System.out.println(obj));
    }

    /**
     * 思路：压栈
     *
     * @param head
     * @return
     */
    public static List<Integer> printListFromTailToHeadUseStack(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        List<Integer> list = new ArrayList<Integer>(stack.size());
        while (!stack.empty()) {
            list.add(stack.pop().val);
        }
        return list;
    }

    /**
     * 思路：不使用栈
     * 先记录listNode的元素个数
     * 新建ArrayList链表，从后往前插入
     *
     * @param head
     * @return
     */
    public static List<Integer> printListFromTailToHeadIgnoreStack(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        Integer[] res = new Integer[size];
        // 从头开始遍历ListNode
        temp = head;
        for (int i = size - 1; i >= 0; i--) {
            res[i] = temp.val;
            temp = temp.next;
        }
        return Arrays.asList(res);
    }

    /**
     * 思路：递归
     *
     * @param head
     * @return
     */
    public static List<Integer> printListFromTailToHeadUseRecursion(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        ListNode temp = head;
        recursion(list, temp);
        return list;
    }

    private static void recursion(List<Integer> list, ListNode temp) {
        if (temp != null) {
            recursion(list, temp.next);
            list.add(temp.val);
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

}