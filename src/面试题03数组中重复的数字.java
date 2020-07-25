import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: 数组中重复的数字
 * @Author: 时间
 * @Description: 找出数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在0 ~ n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复，也不知道每个数字重复几次，
 * 请找出数组中任意一个重复的数字
 * <p>
 * 示例：[2，3，1，0，2，5，3]
 * 输出：2 或 3
 * @Date: 2020/7/23 1:06
 * @Version: 1.0
 */
public class 面试题03数组中重复的数字 {
    public static void main(String[] args) {
        int[] nums = {2, 5, 4, 6, 3, 7, 3};
        System.out.println(findRepeatNumberByHash(nums));
        System.out.println(findRepeatNumberByIndex(nums));
    }

    /**
     * 第一种实现，利用hash表
     * 没有找到输出-1
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumberByHash(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = -1;
        for (int num : nums) {
            if (!set.add(num)) { // add失败，返回false，说明找到了元素
                res = num;
                break;
            }
        }
        return res;
    }

    /**
     * 数组下标实现
     * 利用0 ~ n-1 与数组下标 0 ~ n-1 条件
     * 如果没有重复，则所有下标应该与对应的值相等，即nums[i] = i;
     * 如果不相等，则把当前位置的值放在其对应的位置，比如位置0的值为2，则与下标2进行交换，把2放到下标2的位置上，然后继续比较下标0
     * 直到要交换的值与对应对应位置的值相等，则说明出现重复值
     *
     * @return
     */
    public static int findRepeatNumberByIndex(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            if (num < 0 || num >= n) {
                return -1;
            }

            for (int i = 0; i < n; i++) {
                System.out.println("i:" + i);
                while (nums[i] != i && nums[nums[i]] != nums[i]) {
                    swap(nums, i, nums[i]);
                }
                if (nums[i] != i && nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        System.out.println("交换前:" + Arrays.toString(nums) + " i: " + i + " j: " + j);
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        System.out.println(Arrays.toString(nums) + " i: " + i + " j: " + j);
    }
}
