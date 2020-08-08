/**
 * @ClassName: 希尔排序
 * @Author: 时间
 * @Description: 希尔排序(Shell ' s Sort)是插入排序的一种又称“缩小增量排序”（Diminishing Increment Sort）
 * 是直接插入排序算法的一种更高效的改进版本
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
 * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至 1 时，整个文件恰被分成一组，算法便终止
 * @Date: 2020/8/1 1:04
 * @Version: 1.0
 */
public class 希尔排序 {
    public static void main(String[] args) {
        int[] array = {3, 4, 1, 2, 5, 8, 0};
        shellSort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void shellSort(int[] array) {
        int length = array.length;
        for (int gap = length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < length; i++) {
                // 使用插入排序算法，将元素依次插入所在小组的已排序列表中
                // 待插入元素
                int waitInsert = array[i];
                int j = i - gap;
                // 前序子数组已经排好序，反向遍历，找到合适的位置插入元素
                while (j >= 0 && array[j] >= waitInsert) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = waitInsert;
            }
        }
    }
}
