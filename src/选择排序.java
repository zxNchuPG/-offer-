/**
 * @ClassName: 选择排序
 * @Author: 时间
 * @Description: 时间复杂度O(n^2)，空间复杂度O(1)，不稳定
 * 选择排序（Selection sort）是一种简单直观的排序算法。
 * 第一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，
 * 然后再从剩余的未排序元素中寻找到最小（大）元素，然后放到已排序的序列的末尾。
 * 以此类推，直到全部待排序的数据元素的个数为零。
 * 选择排序是不稳定的排序方法
 * @Date: 2020/7/31 21:38
 * @Version: 1.0
 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] array = {3, 4, 1, 2, 5, 8, 0};
        selectSort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void selectSort(int array[]) {
        // 每次遍历将最小值放到在下标 i 上
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    // 选出出最小值的下标
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(array, i, minIndex);
            }
        }
    }

    /**
     * 交换元素位置
     *
     * @param array
     * @param index
     * @param nextIndex
     */
    private static void swap(int[] array, int index, int nextIndex) {
        int temp = array[index];
        array[index] = array[nextIndex];
        array[nextIndex] = temp;
    }
}
