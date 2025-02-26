public class AddFractions {
    public static void main(String[] args) {
        double result = 0;
        for(int i=1;i<=100;i+=2){
            result += 1.0/i;
        }
        for(int i=2;i<=100;i+=2){
            result -= 1.0/i;
        }
        System.out.println(result);
    }
}
