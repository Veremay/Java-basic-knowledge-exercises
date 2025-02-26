public class AddtoHundred {
    public static void main(String[] args) {
        int sum = 0;

        for (int i=1;i<=100;i++) {
            int sum_temp = 0;
            for (int j=1;j<=i;j++) {
                sum_temp += j;
            }
            sum += sum_temp;
        }
        System.out.println(sum);
    }
}
