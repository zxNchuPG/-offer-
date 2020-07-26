/**
 * @ClassName: 面试题14_1剪绳子
 * @Author: 时间
 * @Description: 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
 * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 示例：
 * 输入8
 * 输出：18
 * @Date: 2020/7/26 21:30
 * @Version: 1.0
 */
public class 面试题14_1剪绳子 {
    public static void main(String[] args) {
        int result = cutRope(8);
        System.out.println(result);
    }

    /**
     * 思路：DP动态规划算法
     * 题设（2 <= n <= 60）
     *
     * @param target 绳子长度
     * @return
     */
    public static int cutRope(int target) {
        if (target < 2) return 0;
        // 初始化一个大小为 target+1 的数组，初始值为 -1 ， 也可以-2， 反正是不可能得到的值
        int[] dp = new int[target + 1];
        if (target == 3) {  // 这里返回2，是因为题设剪成 > 1 段
            return 2;
        }
        // 长度target小于4之前，答案都是已知的
        // 先给dp数组赋值
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        for (int i = 5; i <= target; ++i) { // 长度5开始
            for (int j = 1; j < i; ++j) { // 第一段1，一直到长度target
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
        }
        return dp[target];
    }
}
