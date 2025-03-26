public class Registration {
    public static void main(String[] args) {
        String name = "jack";
        String pwd = "123456";
        String email = "jack@sohu.com";
        try {
            userRegister(name, pwd, email);
            System.out.println("恭喜你，注册成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void userRegister(String name, String pwd, String email) {
        // 第一关 检验名字长度
        int userLength = name.length();
        if (!(userLength >= 2 && userLength <= 4))
            throw new RuntimeException("用户名长度不正确");

        // 第二关 检验密码
        if (!(pwd.length() == 6 && isDigital(pwd))) {
            throw new RuntimeException("密码长度要求为6，并且全是数字");
        }

        //第三关 检验邮箱
        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if (!(i > 0 && j > i)) {
            throw new RuntimeException("邮箱中包含@和.并且@在.的前面");
        }
    }

    //单独的写一个方法，判断密码是否全部是数字字符
    public static boolean isDigital(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
