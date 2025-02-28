import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the target score to win: ");
        int targetScore = scanner.nextInt();
        // IMPORTANT!!!
        scanner.nextLine();

        Game game = new Game(targetScore);
        boolean isPlaying = true;
        while(isPlaying){
            System.out.println("Press 'r' to roll the dice, 's' to stop: ");
            String choice = scanner.nextLine();
            if(Objects.equals(choice, "r")){
                game.rollDice();
                game.displayScore();
                if(game.isTargetReached()){
                    System.out.println("Congrats, you won!");
                    isPlaying = false;
                }
            } else if (Objects.equals(choice, "s")) {
                System.out.println("You chose to stop, have a good day!");
                game.displayScore();
                isPlaying = false;

            }else{
                System.out.println("Invalid choice, please try again");
            }
        }

        scanner.close();
    }
}
