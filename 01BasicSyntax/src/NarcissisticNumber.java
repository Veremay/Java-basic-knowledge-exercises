import java.util.Scanner;
//import java.lang.Math;

public class NarcissisticNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int hundred = number / 100;
        int tens = (number - hundred * 100) / 10;
        int unit = number - hundred * 100 - tens * 10;

        if(number == Math.pow(hundred, 3) + Math.pow(tens, 3) + Math.pow(unit, 3)){
            System.out.println("是水仙花数");
        }else{
            System.out.println("不是水仙花数");
        }
    }
}
