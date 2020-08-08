/**
 * @ClassName: 堆排序
 * @Author: 时间
 * @Description: 间复杂度`O(nlogn)`，空间复杂度`O(1)`，不稳定
 * 建立堆的过程是`O(n)`的时间复杂度。
 * 堆排序（Heapsort）是利用堆这种数据结构而设计的一种排序算法，堆排序是一种选择排序，它的最坏，最好，平均时间复杂度均为O(nlogn)，它也是不稳定排序
 * 堆是具有以下性质的完全二叉树：每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆
 * 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
 * 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
 * @Date: 2020/8/1 21:42
 * @Version: 1.0
 */
public class 堆排序 {
    public static void main(String[] args) {
//        int[] array = {3, 4, 1, 2, 5, 8, 0};
//        heapSort(array);
//        for (int num : array) {
//            System.out.print(num + " ");
//        }
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            // 插入，建立一个大根堆
            heapInsert(arr, i);
        }
        int size = arr.length;
        // 让第一个数和最后一个数交换位置
        // 最后一个元素不再动了
        swap(arr, 0, --size);
        // 重复调整大根堆
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        // 当前节点位置比父节点位置更大，则循环交换
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 跟自己的左右孩子比较，将大的数上移
    public static void heapify(int[] arr, int index, int size) {
        // 左孩子下标
        int left = index * 2 + 1;
        while (left < size) {
            // 在右孩子不越界，然后找到左右孩子中更大的孩子下标
            int largest = left + 1 < size && arr[left + 1] > arr[left]
                    ? left + 1
                    : left;
            // 获取左右孩子下标后，判断与父节点的大小，返回一个最大值的下标
            largest = arr[largest] > arr[index] ? largest : index;
            // 如果最大值为父节点，即无需调整，退出循环
            if (largest == index) {
                break;
            }
            // 需要调整大根堆
            swap(arr, largest, index);
            // 更换父节点的下标值，继续执行左右孩子的大小比较
            index = largest;
            left = index * 2 + 1;
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