import java.util.Random;

public class Dice {
    private int value;

    public Dice(){
        value = 1;
    }

    public void roll(){
        Random rnd = new Random();
        this.value = rnd.nextInt(6) + 1;
    }

    public int getValue(){
        return this.value;
    }
}
