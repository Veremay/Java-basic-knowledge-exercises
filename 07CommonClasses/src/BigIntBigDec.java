import java.math.BigDecimal;
import java.math.BigInteger;

public class BigIntBigDec {
    public static void main(String[] args) {
        BigInteger integer = new BigInteger("2109421848201");
        BigInteger integer1 = new BigInteger("100");

        System.out.println("==========BigInteger==========");
        BigInteger add = integer.add(integer1);
        System.out.println("加法 " + add);

        BigInteger subtract = integer.subtract(integer1);
        System.out.println("除法 " + subtract);

        BigInteger multiply = integer.multiply(integer1);
        System.out.println("乘法 " + multiply);

        BigInteger divide = integer.divide(integer1);
        System.out.println("除法 " + divide);

        System.out.println("==========BigDecimal==========");
        BigDecimal bigDecimal = new BigDecimal("19.1111111111111111199999999");
        BigDecimal bigDecimal1 = new BigDecimal("1.2");
        //加上BigDecimal.ROUND_CEILING，可将结果精度变为和除数的小数精度相同
        BigDecimal divide2 = bigDecimal.divide(bigDecimal1, BigDecimal.ROUND_CEILING);
        System.out.println(divide2);

    }
}
