/**
 * @ClassName: 面试题13机器人的运动范围
 * @Author: 时间
 * @Description: 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子
 * <p>
 * 示例1：
 * 输入 m = 2,n = 3,k = 1
 * 输出 3
 * <p>
 * 示例2：
 * 输入 m = 3,n = 1,k = 0
 * 输出 1
 * @Date: 2020/7/26 19:56
 * @Version: 1.0
 */
public class 面试题13机器人的运动范围 {
    public static void main(String[] args) {
        int result = movingCount(1, 2, 3);
        System.out.println(result);
        result = movingCount(0, 3, 1);
        System.out.println(result);
    }

    /**
     * 思路：:回溯法
     * 1.从(0,0)开始走，每成功走一步标记当前位置为true,然后从当前位置往四个方向探索，
     * 返回1 + 4 个方向的探索值之和。
     * 2.探索时，判断当前节点是否可达的标准为：
     * 1）当前节点在矩阵内；
     * 2）当前节点未被访问过；
     * 3）当前节点满足阈值限制。
     *
     * @param threshold 阈值，也就是输入的k值
     * @param rows
     * @param cols
     * @return
     */
    public static int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return dfs(threshold, rows, cols, 0, 0, visited);
    }

    private static int dfs(int threshold, int rows, int cols, int curRows, int curCols, boolean[][] visited) {
        // 判断当前节点合法性
        if (curRows < 0 || curCols < 0 || curRows >= rows || curCols >= cols || visited[curRows][curCols] || verifyThreshold(curRows, curCols, threshold)) {
            return 0;
        }
        visited[curRows][curCols] = true;
        return dfs(threshold, rows, cols, curRows - 1, curCols, visited)
                + dfs(threshold, rows, cols, curRows + 1, curCols, visited)
                + dfs(threshold, rows, cols, curRows, curCols - 1, visited)
                + dfs(threshold, rows, cols, curRows, curCols + 1, visited)
                + 1;
    }

    /**
     * 校验阈值
     *
     * @param curRows
     * @param curCols
     * @param threshold
     * @return
     */
    private static boolean verifyThreshold(int curRows, int curCols, int threshold) {
        int rowsCount = 0;
        while (curRows != 0) {
            rowsCount += curRows % 10;
            curRows /= 10;
        }
        int colsCount = 0;
        while (curCols != 0) {
            colsCount += curCols % 10;
            curCols /= 10;
        }
        return rowsCount + colsCount > threshold;
    }

}
