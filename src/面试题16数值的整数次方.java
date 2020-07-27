/**
 * @ClassName: 面试题16数值的整数次方
 * @Author: 时间
 * @Description: 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 * 保证base和exponent不同时为0，不要使用库函数
 * 输入 2.00000,10
 * 输出 1024.00000
 * <p>
 * 输入 2.10000,3
 * 输出 9.26100
 * <p>
 * 输入 2.00000,-2
 * 输出 0.25000
 * @Date: 2020/7/26 23:55
 * @Version: 1.0
 */
public class 面试题16数值的整数次方 {
    public static void main(String[] args) {
        double result = Power(2, 5);
        System.out.println(result);
    }

    /**
     * 快速幂
     *
     * @param base
     * @param exponent 幂次方
     * @return
     */
    public static double Power(double base, int exponent) {
        // exponent用二进制表示
        if (base == 0) {
            return 0;
        }
        long n = exponent;
        double result = 1.0;
        if (n < 0) {
            n = -n;
            base = 1 / base;
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                result *= base;
            }
            base *= base;
            n >>= 1;
        }
        return result;
    }
}
