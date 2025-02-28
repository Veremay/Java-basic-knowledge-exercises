public class TollCollection {
    public static void main(String[] args) {
        double initial = 100000;
        int times = 0;

        while(initial>=1000){
            if(initial>50000){
                initial -= initial * 0.05;
                times++;
            }else{
                initial -= 1000;
                times++;
            }
        }

        System.out.println("可以过" + times + "次路口");
    }
}
