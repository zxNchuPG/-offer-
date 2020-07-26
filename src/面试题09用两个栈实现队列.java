import java.util.Stack;

/**
 * @ClassName: 面试题09用两个栈实现队列
 * @Author: 时间
 * @Description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 * @Date: 2020/7/26 1:26
 * @Version: 1.0
 */
public class 面试题09用两个栈实现队列 {
    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}

class CQueue {
    Stack<Integer> stack1 = new Stack<Integer>(); // 存值
    Stack<Integer> stack2 = new Stack<Integer>(); // 辅助出队

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            return -1;
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
