/**
 * @ClassName: 面试题10_2青蛙跳台阶问题
 * @Author: 时间
 * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 * @Date: 2020/7/26 11:47
 * @Version: 1.0
 */
public class 面试题10_2青蛙跳台阶问题 {
    public static void main(String[] args) {
        int num = JumpFloor(7);
        System.out.println(num);
        num = JumpFloor(2);
        System.out.println(num);
        num = JumpFloor(1);
        System.out.println(num);
        num = JumpFloor(3); // 答案是4 ，实际输出3，有问题
        System.out.println(num);
    }

    /**
     * 思路：
     * 每次跳的时候，小青蛙可以跳一个台阶，也可以跳两个台阶，也就是说，每次跳的时候，小青蛙有两种跳法
     * 第一种跳法：第一次跳了一个台阶，那么还剩下n-1个台阶还没跳，剩下的n-1个台阶的跳法有f(n-1)种
     * 第二种跳法：第一次跳了两个台阶，那么还剩下n-2个台阶还没，剩下的n-2个台阶的跳法有f(n-2)种
     * 所以，小青蛙的全部跳法就是这两种跳法之和了，即 f(n) = f(n-1) + f(n-2)
     * <p>
     * 牛客网 f(0) = 1 , 代码不通过，需要改
     *
     * @param target
     * @return
     */
    public static int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    // 第二种做法
    public static int JumpFloor2(int target) {
        if (target <= 0) return 0;
        return (int) Math.pow(2, target - 1);
    }
}
