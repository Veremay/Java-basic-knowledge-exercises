public class FormatName {
    public static void main(String[] args) {
        String name = "William Jefferson Clinton";
        printName(name);
    }

    public static void printName(String name) {
        if (name == null) {
            System.out.println("姓名不能为空！");
            return;
        }

        String[] names = name.split(" ");
        if (names.length != 3) {
            System.out.println("输入的字符串格式不对");
            return;
        }

        String format = String.format("%s,%s .%c",
                names[2], names[0],
                names[1].toUpperCase().charAt(0));

        System.out.println(format);
    }
}
