package yahtzee;
import java.util.Random;

class Die {
	
	// Instance Variables
    private int value;
    private Random rand;

    // Constructor
    public Die() {
        value = 0;
        rand = new Random();
    }

    // sets value to a number between 1 and 6 (inclusive)
    public void roll() {
        value = 1 + rand.nextInt(6);
    }
    
    // getter (for value)
    public int get() {
        return (value);
    }
}