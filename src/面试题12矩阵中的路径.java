/**
 * @ClassName: 面试题12矩阵中的路径
 * @Author: 时间
 * @Description: 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子
 * [a b c e]
 * [s f c s]
 * [a d e e]
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子
 * @Date: 2020/7/26 13:30
 * @Version: 1.0
 */
public class 面试题12矩阵中的路径 {
    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e' };
        char[] str = {'b', 'c', 'c', 'e', 'd' };
        char[] str2 = {'a', 'b', 'c', 'd' };
        boolean result = hasPath(matrix, 3, 4, str);
        System.out.println(result);
        result = hasPath(matrix, 3, 4, str2);
        System.out.println(result);
    }

    /**
     * 思路：回溯法
     *
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // 先对传入值合法性校验
        if (matrix == null || matrix.length == 0 || str == null || str.length == 0 || matrix.length != rows * cols || rows <= 0 || cols <= 0 || rows * cols < str.length) {
            return false;
        }

        // 创建和矩阵长度相同的标志位
        boolean[] visited = new boolean[matrix.length];

        // 开始遍历矩阵
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 广度优先
                if (dfs(matrix, rows, cols, str, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 广度优先
     *
     * @param matrix  矩阵
     * @param rows    矩阵行
     * @param cols    矩阵列
     * @param str     要判断的路径
     * @param visited 访问标志位
     * @param curRows 当前行
     * @param curCols 当前列
     * @param k       str要判断的路径的下标
     * @return
     */
    public static boolean dfs(char[] matrix, int rows, int cols, char[] str, boolean[] visited, int curRows, int curCols, int k) {
        // 根据行列，计算matrix当前值的下标
        int matrixIndex = curRows * cols + curCols;
        // 递归终止条件
        if (curRows < 0 || curCols < 0 || curRows >= rows || curCols >= cols || matrix[curRows * cols + curCols] != str[k] || visited[matrixIndex]) {
            return false;
        }
        //若k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
        // 因为上面的if已经判断了matrix[curRows * cols + curCols] != str[k] ，说明末尾值是匹配上的，所以这里直接返回true
        if (k == str.length - 1) {
            return true;
        }
        //要走的第一个位置置为true，表示已经走过了
        visited[matrixIndex] = true;

        if (dfs(matrix, rows, cols, str, visited, curRows - 1, curCols, k + 1) || // 左
                dfs(matrix, rows, cols, str, visited, curRows + 1, curCols, k + 1) || // 右
                dfs(matrix, rows, cols, str, visited, curRows, curCols - 1, k + 1) || //上
                dfs(matrix, rows, cols, str, visited, curRows, curCols + 1, k + 1)) // 下
        {
            return true;
        }
        //走到这，说明这一条路不通，还原，再试其他的路径
        visited[matrixIndex] = false;
        return false;
    }
}
