import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: 面试题10斐波那契数列
 * @Author: 时间
 * @Description: 现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1） n<=39
 * 斐波那契定义如下：
 * F(0) = 0,F(1) = 1
 * F(N) = F(N-1) + F(N-2)
 * 其中 N > 1
 * @Date: 2020/7/26 11:18
 * @Version: 1.0
 */
public class 面试题10_1斐波那契数列 {
    public static void main(String[] args) {
        int sum = Fibonacci(4);
        System.out.println("==================递归====================");
        System.out.println(sum);
        sum = Fibonacci2(4);
        System.out.println("==================递推====================");
        System.out.println(sum);
    }

    /**
     * 自上而下递归
     *
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    /**
     * 自下而上递推
     *
     * @param n
     * @return
     */
    public static int Fibonacci2(int n) {
        if (n < 2) {
            return n;
        }
        int f1 = 0;
        int f2 = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }
        return result;
    }
}
