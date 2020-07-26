/**
 * @ClassName: 面试题11旋转数组的最小数字
 * @Author: 时间
 * @Description: 旋转给定一个数组，将数组中的元素向右移动k 个位置，其中k 是非负数
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。（等价于寻找{3,4,5,1,2}的最小值）
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 * <p>
 * 注：题设的旋转数组条件，想描述的是该数组不是有序，所以对旋转数组来讲，有序数组使用二分法会多一个判断，判断最小值在分界值的左边还是右边
 * @Date: 2020/7/26 12:17
 * @Version: 1.0
 */
public class 面试题11旋转数组的最小数字 {
    public static void main(String[] args) {
        int[] array = {3, 4, 5, 1, 2};
        int[] array1 = {1, 0, 1, 1, 1};
        int num = minNumberInRotateArray(array);
        System.out.println(num);
        num = minNumberInRotateArray(array1);
        System.out.println(num);
    }

    /**
     * 思路：考察二分法
     *
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > array[right]) { // 说明最小值在右边数组
                left = mid + 1;
            } else if (array[mid] == array[right]) { // 不能确定在左边或者右边 类似 [1,0,1,1,1] 或者[1,1,1,0,1]
                right = right - 1;
            } else { // 说明最小值在左边数组
                //注意这里有个坑：如果待查询的范围最后只剩两个数，那么mid 一定会指向下标靠前的数字
                //比如 array = [4,6]
                //array[low] = 4 ;array[mid] = 4 ; array[high] = 6 ;
                //如果high = mid - 1，就会产生错误， 因此high = mid
                right = mid;
            }
        }
        return array[left];
    }
}
