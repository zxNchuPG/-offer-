/**
 * @ClassName: 面试题15二进制中1的个数
 * @Author: 时间
 * @Description: 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示
 * 输入 00000000000000000000000000001011
 * 输出 3
 * @Date: 2020/7/26 23:24
 * @Version: 1.0
 */
public class 面试题15二进制中1的个数 {
    public static void main(String[] args) {
        int count = NumberOf1(11);
        System.out.println(count);
    }

    /**
     * 思路：位运算
     * n & (n-1)
     * 每执行一次，最右边的1变成0
     * val :1101000
     * val-1: 1100111
     * 那么val & （val-1） : 1100000
     *
     * @param n
     * @return
     */
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
