import java.util.Scanner;

public class ScoreStatistics {
    public static void main(String[] args) {
        double score_total = 0;
        int pass_total = 0;

        Scanner input = new Scanner(System.in);

        for(int i=0; i < 3; i++){
            double score_sum = 0;
            int pass_sum = 0;
            for(int j=0; j < 5; j++){
                System.out.print("请输入第" + (i+1) + "的第" + (j+1) + "个同学的成绩：");
                double score = input.nextDouble();
                score_sum += score;
                score_total += score;
                if(score > 60){
                    pass_sum++;
                    pass_total++;
                }
            }

            System.out.println("第" + (i+1) + "个班的平均成绩为：" + (score_sum/5) + "\n" + "及格人数为：" + pass_sum);
        }

        System.out.println("三个班平均成绩为：" + (score_total/15) + "\n" + "及格人数为：" + pass_total);


    }
}
