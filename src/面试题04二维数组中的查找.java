import java.util.Collections;

/**
 * @ClassName: 面试题04二维数组中的查找
 * @Author: 时间
 * @Description: 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
 * 完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * 示例：[
 * [1,4,7,11,15],
 * [2,5,8,12,19],
 * [3,6,9,16,22],
 * [10,13,14,17,24],
 * [18,21,23,26,30]
 * ]
 * 给定targer = 5，返回true
 * 给定targer = 20，返回false
 * @Date: 2020/7/24 21:03
 * @Version: 1.0
 */
public class 面试题04二维数组中的查找 {
    public static void main(String[] args) {
        int[][] materix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(materix, 5));
        System.out.println(findNumberIn2DArray(materix, 20));
    }

    /**
     * 思路：根据行递增与列递增的规律
     * 如果target比右上角的值小，那么该列排除
     * 如果target比右上角的值大，那么该行排除
     *
     * @param materix 目标数组
     * @param target  查找的值
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] materix, int target) {
        // 数组判空
        // 数组地址为空 materix == null
        // 或者 {} 为空 materix.length == 0
        // 或者{{}} 为空，materix.length == 1 && materix[0].length == 0
        if (materix == null || materix.length == 0 || (materix.length == 1 && materix[0].length == 0)) {
            return false;
        }

        // 从数组的右上角开始遍历
        int i = 0, j = materix[0].length - 1;
        while (i < materix.length - 1 && j >= 0) {
            if (target == materix[i][j]) {
                return true;
            } else if (target > materix[i][j]) {
                i++;
            } else if (target < materix[i][j]) {
                j--;
            }
        }
        return false;
    }
}
