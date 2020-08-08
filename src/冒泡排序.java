/**
 * @ClassName: 冒泡排序
 * @Author: 时间
 * @Description: 时间复杂度O(n^2)，空间复杂度O(1)，稳定
 * 从头开始，每次两个相邻的元素，若大者在前，则交换两元素
 * 直至数组末尾，此时最大元素为数组最后的元素；重复以上步骤，从头开始至上一轮比较的末尾元素
 * @Date: 2020/7/31 0:52
 * @Version: 1.0
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        int[] array = {3, 4, 1, 2, 5, 8, 0};
        bubbleSort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }

        int[] array1 = {3, 4, 1, 2, 5, 8, 0};
        bubbleSort2(array1);

        System.out.println();
        for (int num : array1) {
            System.out.print(num + " ");
        }
    }

    public static void bubbleSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        // 每轮询一遍，都将最大的元素移到最后一位，所以end--
        for (int end = array.length - 1; end > 0; end--) {
            // 每次都从数组的第一位开始遍历
            for (int i = 0; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }
    }

    public static void bubbleSort2(int[] array) {
        if (array.length < 2) {
            return;
        }
        // 每轮询一遍，都将最大的元素移到最后一位，所以end--
        for (int end = array.length - 1; end > 0; end--) {
            // 这样当一轮比较结束后如果flag仍为false，即：这一轮没有发生交换，说明数据的顺序已经排好，没有必要继续进行下去。
            boolean ixExchanged = false;
            // 每次都从数组的第一位开始遍历
            for (int i = 0; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    ixExchanged = true;
                }
            }
            if (!ixExchanged) {
                break;
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
