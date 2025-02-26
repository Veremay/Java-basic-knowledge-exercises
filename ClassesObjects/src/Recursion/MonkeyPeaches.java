package Recursion;

import java.util.Scanner;

public class MonkeyPeaches {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many days? ");
        int n = sc.nextInt();

        System.out.println(LeavePeaches(n));
    }

    public static int LeavePeaches(int n) {
        if(n == 1){
            return 1;
        }else{
            return (LeavePeaches(n-1) + 1) * 2;
        }
    }
}
