public class MathCommonMethod {
    public static void main(String[] args) {
        System.out.println("绝对值 "+Math.abs(-3));   //3
        System.out.println("幂 " + Math.pow(2,4)); //16.0 返回类型为double
        System.out.println("向上取整 "+Math.ceil(-3.1));   // -3.0 返回类型为double
        System.out.println("向下取整 "+Math.floor(-3.3));   // -4.0 返回类型为double
        System.out.println("开方 "+Math.sqrt(4));  //2.0  返回类型为double
        System.out.println("比较哪个大 "+Math.max(3,4));
        System.out.println("比较哪个小 "+Math.min(3.3,-1.0));
        System.out.println("四舍五入 "+Math.round(3.3));  //返回类型为long
        System.out.println("======随机数：");
        for (int i = 0; i < 5; i++) {
            System.out.println(Math.random());
        }
        System.out.println("============");

    }
}
