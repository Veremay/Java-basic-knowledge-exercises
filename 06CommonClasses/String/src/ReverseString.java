/**
 * (1)将字符串中指定部分进行反转。比如将"abcdef"反转为"aedcbf"
 */

public class ReverseString {
    public static void main(String[] args) {
        String str = "abcdef";
        try {
            str = reverse(str, 1, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(str);
    }

    public static String reverse(String str, int start, int end) {

        //对输入的参数做一个验证
        //重要的编程技巧分享!!!
        //(1)写出正确的情况
        //(2)然后取反即可
        if (str != null && start >= 0 && end > start && end < str.length()) {
            throw new RuntimeException("参数不正确");
        }


        char[] chars = str.toCharArray();
        char temp = ' ';
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        return new String(chars);
    }
}
