import java.util.Scanner;

public class HollowPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入金字塔层数：");
        int layer = scanner.nextInt();

        int max = 2 * (layer-1) + 1;
        for(int i=0;i<layer;i++){
//            自己第一时间想到的for循环方法
            /*
            if(i == layer - 1){
                for(int j=1;j<=max;j++){
                    System.out.print("*");
                }

            }
            else{
                for(int k=1;k<=(max - (2 * i + 1))/2 ;k++){
                    System.out.print(" ");
                }
                for(int j=1;j<=2 * i + 1;j++){
                    if(j==1){
                        System.out.print("*");
                    }
                    else if(j==2 * i + 1){
                        System.out.print("*");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
                for(int k=1;k<=(max - (2 * i + 1))/2 ;k++){
                    System.out.print(" ");
                }
                System.out.println();
            }
            */

//            化繁为简后的方法

            for(int j=0;j<(layer-i-1);j++){
                System.out.print(" ");
            }

            for(int j=1;j<=2 * i + 1;j++){
                if(j == 1 || j == 2 * i + 1 || i == layer - 1){
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();



        }
    }
}
