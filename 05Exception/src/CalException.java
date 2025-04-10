public class CalException {
    /*
    计算两个数相除，要求使用方法cal(int n1，int n2)
    编写应用程序EcmDef.java，接收命令行的两个参数(整数)，计算两数相除。
    对数据格式不正确(NumberFormatException)、缺少命令行参数(ArrayIndex0ut0fBoundsException)、除0(ArithmeticException) 进行异常处理
     */
    public static void main(String[] args) {
        try {
            //先验证输入的参数的个数是否正确两个参数
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("参数个数不对");
            }
            //先把接收到的参数，转成整数
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            double res = cal(n1, n2);////该方法可能抛出ArithmeticException
            System.out.println("n1 / n2 = " + res);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("参数格式不正确，需要输出整数");
        } catch (ArithmeticException e){
            System.out.println("出现了除以0的异常");
        }

    }

    //编写cal方法，就是两个数的商
    public static double cal(int n1, int n2) {
        return n1 / n2;
    }
}
