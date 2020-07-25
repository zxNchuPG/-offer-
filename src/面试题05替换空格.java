/**
 * @ClassName: 面试题05替换空格
 * @Author: 时间
 * @Description: 实现一个函数，把字符串 s 中的每个空格替换成 “%20”
 * 示例：输入 s = "We are happy"
 * 输出 “We20%are20%happy”
 * @Date: 2020/7/24 21:29
 * @Version: 1.0
 */
public class 面试题05替换空格 {
    public static void main(String[] args) {
        String str = "We are happy";
        System.out.println(replaceSpaceMethod_1(str));
        System.out.println(replaceSpaceMethod_2(str));
    }

    /**
     * 思路：创建一个新数组，循环旧字符串进行赋值
     *
     * @param str
     * @return
     */
    public static String replaceSpaceMethod_1(String str) {
        int length = str.length();
        // 新建数组，“ ” 替换成 %20，长度增长3倍
        char[] array = new char[length * 3];

        // 新数组的下标
        int index = 0;

        // 遍历旧字符串
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                array[index++] = '%';
                array[index++] = '2';
                array[index++] = '0';
            } else {
                array[index++] = c;
            }
        }

        return String.copyValueOf(array);
    }

    /**
     * 思路：在原字符串上做操作
     * 1.首先遍历一遍字符串，统计空格数量
     * 2.反向遍历字符串，将字符向后移动
     *
     * @param str
     * @return
     */
    public static String replaceSpaceMethod_2(String str) {
        StringBuffer s = new StringBuffer(str);
        int spaceCount = 0; //空格数量
        int length = str.length(); //字符串长度

        // 计算空格数量
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        // 扩容
        s.setLength(length + 2 * spaceCount);

        // 执行替换操作
        // "w_e"  扩容后"w_e__"
        // "w_e"反向遍历 读取到 s[2] = e ,  需要移动到 s[4] 的位置, 也就是 "w___e" 下标为 [2 + 空格数 * 2]
        // "w___e" 此时下标 s[1] = '_' ,执行插入字符操作
        for (int i = length - 1; i > 0; i--) {
            if (s.charAt(i) == ' ') {
                s.setCharAt(i + 2 * spaceCount - 2, '%');
                s.setCharAt(i + 2 * spaceCount - 1, '2');
                s.setCharAt(i + 2 * spaceCount, '0');
                spaceCount--;
            } else {
                s.setCharAt(i + 2 * spaceCount, str.charAt(i));
            }
        }
        return s.toString();
    }
}
