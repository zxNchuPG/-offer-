/**
 * @ClassName: 归并排序
 * @Author: 时间
 * @Description: 时间复杂度`O(nlogn)`，空间复杂度`O(n)`，稳定
 * 归并排序（Merge Sort）是建立在归并操作上的一种有效，稳定的排序算法
 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用
 * 将已有序的子序列合并，得到完全有序的序列
 * 即先使每个子序列有序，再使子序列段间有序
 * 基本思想：
 * 分解（Divide）：将n个元素分成个含n/2个元素的子序列。
 * 解决（Conquer）：用合并排序法对两个子序列递归的排序。
 * 合并（Combine）：合并两个已排序的子序列已得到排序结果
 * <p>
 * 2. 实现逻辑
 * 2.1 迭代法
 * <p>
 * ① 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 * ② 设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * ③ 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 * ④ 重复步骤③直到某一指针到达序列尾
 * ⑤ 将另一序列剩下的所有元素直接复制到合并序列尾
 * 2.2 递归法
 * <p>
 * ① 将序列每相邻两个数字进行归并操作，形成floor(n/2)个序列，排序后每个序列包含两个元素
 * ② 将上述序列再次归并，形成floor(n/4)个序列，每个序列包含四个元素
 * ③ 重复步骤②，直到所有元素排序完毕
 * <p>
 * 两两合并，先比较左右子数组头部元素（大或小），将小的头部元素移动到新数组（此时移动的旧子数组头部因为已经为空，所以下一个元素晋升为新的头元素）
 * 当一个子数组为空的时候，依次将另一个子数组剩余元素移动到新数组末尾
 * @Date: 2020/8/1 11:06
 * @Version: 1.0
 */
public class 归并排序 {
    public static void main(String[] args) {
        int[] array = {6, 4, 8, 9, 2, 3, 1};
        mergeSort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        int[] array1 = {9, 8, 6, 4, 3, 2, 1};
        mergeSortIteration(array1);
//        for (int num : array1) {
//            System.out.print(num + " ");
//        }
    }

    // 递归版，入口方法-1
    public static void mergeSort(int[] array) {
        // 先开辟一个大小相同的空数组，防止频繁申请空间
        int[] tempArray = new int[array.length];
        mergeSort(array, 0, array.length - 1, tempArray);
    }

    // 递归版 方法-2
    public static void mergeSort(int[] array, int left, int rigth, int[] tempArray) {
        if (left < rigth) {
            int mid = (left + rigth) >> 1;
            // 分为左右两个子数组
            // { 6, 4, 8, 9, 2, 3, 1}  left = 0 ,right = 6 , mid = 3
            // {6,4,8,9} left = 0, right = 3, mid = 1; {2,3,1} left = 4, right = 6, mid = 5;
            // {6，4} {8，9} {2，3} {1}
            // {6} {4} {8} {9} {2} {3} {1} 本应该分成这样，但此时left = right, 不满足 if 条件，所以执行上面的merge合并操作
            // 上一步merger操作的 left = 0;right = 1; mid = 0
            mergeSort(array, left, mid, tempArray);
            mergeSort(array, mid + 1, rigth, tempArray);
            merge(array, left, mid, rigth, tempArray);
        }
    }

    // 递归版 方法-3
    // 子数组合并实现
    public static void merge(int[] array, int left, int mid, int rigth, int[] tempArray) {
        int i = left; // 左数组头元素
        int j = mid + 1; // 右数组头元素
        int k = 0; // 中间数组有序存储合并后的元素
        // 将小的头部元素移动到新数组（此时移动的旧子数组头部因为已经为空，所以下一个元素晋升为新的头元素）
        // 合并[left,mid]、[mid+1,right]两个数组
        // 所以 i 的边界是 = mid,大于mid表示左数组遍历完毕（为空）
        // j 的边界是 = right，大于 right 表示右数组遍历完毕（为空）
        while (i <= mid && j <= rigth) {
            // 比较两个子数组的头部元素，小的移动到中间数组，下标 ++ 表示后一位晋升为头部元素
            if (array[i] < array[j]) {
                tempArray[k++] = array[i++];
            } else {
                tempArray[k++] = array[j++];
            }
        }
        // 将未遍历完的子数组，依次添加到中间数组
        while (i <= mid) {
            tempArray[k++] = array[i++];
        }

        while (j <= rigth) {
            tempArray[k++] = array[j++];
        }

        // 将合并的有序中间数组替换到原数组位置中
        // 因为每次中间数组都是以 0 下标开始，所以先对 k 作初始化
        k = 0;
        while (left <= rigth) {
            array[left++] = tempArray[k++];
        }
    }

    // 迭代版本
    // 第一次比2个元素，第二次4个元素，第三次8个元素，第四次16个元素，两两归并
    // { 6, 4, 8, 9, 2, 3, 1}
    // 第一次比较 {6,4} {8,9} {2,3} {1},步长2
    public static void mergeSortIteration(int[] array) {
        int length = array.length;
        // 创建一个大小和目标数组相同大小的中间数组
        int[] tempArray = new int[length];
        for (int block = 1; block < length; block *= 2) {
            for (int leftMin = 0; leftMin < length - 1; leftMin += block) {
                System.out.print("交换前：");
                for (int num : array) {
                    System.out.print(num + " ");
                }
                System.out.println();
                int leftMax = leftMin + block; // 左子数组的边界
                int rightMin = leftMin + block; // 右子数组的起始位
                int rightMax = rightMin + block; // 右子数组的边界
                if (rightMax > length) { // 右子数组的边界不能超过原数组长度
                    rightMax = length;
                }
                System.out.println("block:" + block + " leftMin:" + leftMin + " leftMax:" + leftMax + " rightMin:" + rightMin + " rightMax:" + rightMax);
                // 中间数组下标
                int k = 0;
                while (leftMin < leftMax && rightMin < rightMax) {
                    if (array[leftMin] < array[rightMin]) { // 左右两子数组头部元素比较
                        tempArray[k++] = array[leftMin++];
                    } else {
                        tempArray[k++] = array[rightMin++];
                    }
                }
                while (leftMin < leftMax) { // 左子数组没遍历完
                    tempArray[k++] = array[leftMin++];
                }

                while (rightMin < rightMax) { // 右子数组没遍历完
                    tempArray[k++] = array[rightMin++];
                }
                // 重置中间数组下标，将中间数组元素复制到目标数组[leftMin,rightMax]
                while (k > 0) {
                    array[--rightMax] = tempArray[--k];
                }
                System.out.print("交换后");
                for (int num : array) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
}
