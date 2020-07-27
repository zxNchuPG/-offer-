/**
 * @ClassName: 面试题17打印从1到最大的n位数
 * @Author: 时间
 * @Description: 输入数字n，按顺序打印出从1到最大的n位十进制(最大的n位十进制， 10的n次方减1)
 * 比如输入3，则打印出1、2、3一直到最大的3位数999
 * 示例：
 * 输入 n = 1
 * 输出 [1,2,3,4,5,6,7,8,9]
 * <p>
 * 说明：用返回一个整数列表来代替打印
 * n为正整数
 * @Date: 2020/7/27 20:39
 * @Version: 1.0
 */
public class 面试题17打印从1到最大的n位数 {
    public static void main(String[] args) {
        int[] res = printNumbers(2);
        for (int number : res) {
            System.out.println(number);
        }
    }

    /**
     * 先根据快速幂求出10的n次方
     *
     * @param n
     * @return
     */
    public static int[] printNumbers(int n) {
        int result = 1;
        int base = 10;
        while (n != 0) {
            if ((n & 1) == 1) {
                result *= base;
            }
            base *= base;
            n >>= 1;
        }
        int[] res = new int[result - 1];
        for (int i = 0; i < result - 1; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
