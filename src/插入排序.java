/**
 * @ClassName: 插入排序
 * @Author: 时间
 * @Description: 时间复杂度O(n ^ 2)，空间复杂度O(1)，稳定
 * 插入排序，一般也被称为直接插入排序。对于少量元素的排序，它是一个有效的算法
 * 将第一个元素看作有序序列，后续元素当作无需序列，依次将无序序列元素插入有序序列当中
 * 在其实现过程使用双层循环，外层循环对除了第一个元素之外的所有元素，内层循环对当前元素前面有序表进行待插入位置查找，并进行移动
 * InsertionSort 和打扑克牌时，从牌桌上逐一拿起扑克牌，在手上排序的进程相同。举例：
 * Input:` {4, 3, 8, 5, 2, 6, 1, 7}`
 * 首先拿起第一张牌, 手上有 `{4}`。
 * 拿起第二张牌 3, 把 3 insert 到手上的牌 `{4}`, 得到 `{3 ，4}`
 * 拿起第三张牌 8, 把 8 insert 到手上的牌 `{3，4 }`, 得到 `{3 ，4，8}`
 * <p>
 * 插入排序由N-1趟排序组成。对于p=1到N-1趟排序后，插入排序保证从位置0到位置p上的元素为已排序状态
 * 即插入排序利用了从位置0到p-1位置上已经有序的条件，将位置p上的元素向前查找适当的位置插入此元素
 * @Date: 2020/7/31 22:49
 * @Version: 1.0
 */
public class 插入排序 {
    public static void main(String[] args) {
        int[] array = {3, 4, 1, 2, 5, 8, 0};
        insertionSort2(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void insertionSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        // i = 0 默认有序，所以从 i = 1 开始遍历
        for (int i = 1; i < array.length; i++) {
            // 其实就是一个往后插入的逆向冒泡排序的过程
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                swap(array, j, j + 1);
            }
        }
    }

    // 为后面的希尔排序铺垫
    public static void insertionSort2(int[] array) {
        if (array.length <= 1) {
            return;
        }
        // 待插入元素，array[0]默认排号序，作为前序子数组
        int i = 1;
        while (i < array.length) {
            // 起始位置：获取前序子数组最后一位
            int j = i - 1;
            int waitInsert = array[i];
            while (j >= 0 && array[j] > waitInsert) {
                // j-- 遍历，找到需要插入的位置
                array[j + 1] = array[j];
                j--;
            }
            // 插入前序子数组的末尾
            array[j + 1] = waitInsert;
            i++;
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
