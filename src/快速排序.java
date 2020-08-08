/**
 * @ClassName: 快速排序 是对冒泡排序的一种改进
 * @Author: 时间
 * @Description: 最差时间复杂度为`O(n^2)`，最优时间复杂度`O(nlogn)`，空间复杂度`O(logn)` 不稳定
 * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序
 * @Date: 2020/8/1 20:09
 * @Version: 1.0
 */
public class 快速排序 {
    public static void main(String[] args) {
        int[] array = {3, 4, 1, 2, 5, 8, 0};
        int[] result = quicksort(array);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    // 简易版，选数组的第一个元素作为基准
    public static int[] quicksort(int[] array) {
        return quicksort(array, 0, array.length - 1);
    }

    public static int[] quicksort(int[] array, int left, int right) {
        int basic = array[left];
        int i = left;
        int j = right;
        // 第一趟排序，根据基准划分左右序列
        while (i < j) {
            while (i < j && array[j] > basic) { // 说明右值大于基准值，指针向前移动
                j--;
            }
            while (i < j && array[i] < basic) { // 说明左值大于基准值，指针后移
                i++;
            }
            if (i < j && array[i] == array[j]) {
                i++;
            } else {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        if (i - 1 > left) {
            array = quicksort(array, left, i - 1);
        }
        if (j + 1 < right) {
            array = quicksort(array, j + 1, right);
        }
        return array;
    }
}
