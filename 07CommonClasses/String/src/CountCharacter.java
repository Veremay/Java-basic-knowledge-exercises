public class CountCharacter {
    public static void main(String[] args) {
        String str = "hU(f_HEyt7fcy7d8a0";
        countChar(str);
    }

    public static void countChar(String str) {
        char[] chars = str.toCharArray();
        int numCount = 0;
        int lowerCount = 0;
        int upperCount = 0;
        int otherCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                numCount++;
            } else if (chars[i] >= 'a' && chars[i] <= 'z') {
                lowerCount++;
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                upperCount++;
            } else {
                otherCount++;
            }
        }

        System.out.println("数字有 " + numCount);
        System.out.println("小写字母有 " + lowerCount);
        System.out.println("大写字母有 " + upperCount);
        System.out.println("其他字符有 " + otherCount);
    }
}
