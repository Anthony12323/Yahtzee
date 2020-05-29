package yahtzee;

import javax.swing.*;

public class Main {
	
	// Initializing Images
	public static ImageIcon yaht = new ImageIcon(Main.class.getResource("tn-huge-yahtzeesingleplayer.png"));
	public static ImageIcon title = new ImageIcon(Main.class.getResource("tn-huge-yahtzeesingleplayer.png"));
	public static ImageIcon winscreen = new ImageIcon(Main.class.getResource("tn-huge-yahtzeesingleplayer.png"));
	public static ImageIcon Dice = new ImageIcon(Main.class.getResource("tn-huge-yahtzeesingleplayer.png"));
    
	// Instance Variables
	private static final String[] DiceChanger = { "[0]", "[1]", "[2]", "[3]", "[4]", "[5]", "[Help]", "[Exit]"};
	private static final String[] DicePicker = { "[1]", "[2]", "[3]", "[4]", "[5]"};
	// private static final String[] options = { "Yes", "No"};
	
	static boolean game = true;
	
	// checks if the user types in exit to leave the game, otherwise returns their input
	public static String CheckStr(String input) {
	    try {
	        Integer.parseInt(input);
	    } catch (Exception e) {
	        if(input.equalsIgnoreCase("exit")) {
	            System.exit(0);
	        }
	        return "-2000";
	    }
	    return input;
	}
	  
	// runs the game with the title, tutorial, followed by the game logic which involves rolling the dice, giving the player a set amount of tries(3)
	// to re-roll a certain amount of dice, (allowing them to choose which ones) and then calculating which winnings apply to them and letting them choose
	// also presents the end screen and winnings screen.
    public static void main(String[] args) {
        Window wi2 = new Window();
        Winnings prize = new Winnings();
        	int play = 1, scorea = 0, sum = 0;
        int[] wins = new int[15];
        JOptionPane.showMessageDialog(null, "", "Yahtzee", JOptionPane.INFORMATION_MESSAGE, title);
        JOptionPane.showMessageDialog(null, "The objective is as simple as most games, to get as many points as possible\n"
        		+ "you will roll 5 dice and will get diffirent patterns/combinations of dice.\n"
        		+ "Depending on the combination of dice you get, you will get a certain amount of points.\n"
        		+ "To win, you must simply acuire or attempt at aquiring all different possible combinations of dice.\n"
        		+ "some possible combinations include, Ones, Twoes, Threes, Large Straight, Small Straight, and Full House.\n"
        		+ "If you ever wish to leave, click 'exit'", "Yhatzee",  JOptionPane.INFORMATION_MESSAGE);
        while ((play == 1) && (sum < 15)) {
            sum = 0;
            int[] aDice = new int[] { 0, 0, 0, 0, 0 }; // creates an array
            int roll = 0;
            int x, y, w, z;
            int rerolla = 0, rerollb = 03;
            Die die = new Die();
            for (x = 0; x < 5; x++) {
                die.roll();
                aDice[x] = die.get();// sets the dice values
            }
            
            do {
                 int b = wi2.option(DiceChanger, "Die 1: " + aDice[0] +"\nDie 2: " + aDice[1] +"\nDie 3: " + aDice[2] +"\nDie 4: " + aDice[3] +"\nDie 5: " + aDice[4]+ "\nHow many dice would you like to reroll?", "Dice Rolls", JOptionPane.INFORMATION_MESSAGE, Dice);
                 rerolla = b;
                 if(rerolla == 6) {
                	 wi2.msg("Combination Rulebook:\n"
                	 		+ "Three of a Kind: at least three of the same dice faces\n"
                	 		+ "Four of a Kind: at least four of the same dice faces\n"
                	 		+ "Small Straight: four of the same faces\n"
                	 		+ "Large Straight: five of the same faces\n"
                	 		+ "Full House: Three of a kind, and a pair of two matching faces\n"
                	 		+ "Yahtzee: five of the same faces\n"
                	 		+ "Chance: The total of all the face values\n"
                	 		+ "Ones through Sixes: The Ones, Twos, Threes, Fours, Fives and Sixes are all simply the sum of that many number faces.\n"
                	 		+ "For example: count the amount of ones and then sum them, or count the number of sixes and sum them.");
                 }
                 if(rerolla == 7) {
                	 System.exit(0);
                 }
                if (rerolla > 0 && rerolla < 6) {
                    int[] reroll = new int[rerolla];
	                  for(y = 0; y < rerolla; y++) {
	                	  int a = wi2.option(DicePicker, "Which dice would you like the change?", "Yahtzee", JOptionPane.INFORMATION_MESSAGE, winscreen);
                    		rerollb = a+1;
                    		reroll[y] = rerollb;
                    	}
                    for (w = 0; w < rerolla; w++) {
                        if (reroll[w] == 1) {
                            die.roll();
                            aDice[0] = die.get();
                        }
                        if (reroll[w] == 2) {
                            die.roll();
                            aDice[1] = die.get();
                        }
                        if (reroll[w] == 3) {
                            die.roll();
                            aDice[2] = die.get();
                        }
                        if (reroll[w] == 4) {
                            die.roll();
                            aDice[3] = die.get();
                        }
                        if (reroll[w] == 5) {
                            die.roll();
                            aDice[4] = die.get();
                        }
                    }
                    roll++;
                    JOptionPane.showMessageDialog(null,"Die (1): " + aDice[0] +"\nDie (2): " + aDice[1] +"\nDie (3): " + aDice[2] +"\nDie (4): " + aDice[3] +"\nDie (5): " + aDice[4], "Dice Rolls", JOptionPane.INFORMATION_MESSAGE, Dice);
                }
            } while ((roll < 2) && (rerolla > 0));
            prize.checkWinnings(aDice, wins, game);
            
            wins[prize.choice() - 1] = 1;
            for (z = 0; z < 15; z++) {
                sum += wins[z];
            }
            scorea += prize.score();
            wi2.msg("This is your total score: " + scorea);
            if(prize.getEnd() == 13) {
            	JOptionPane.showMessageDialog(null, "Game Over!\n"
            			+ "See you next time!", "Yahtzee - Hope you Enjoyed!", JOptionPane.INFORMATION_MESSAGE, winscreen);
            	System.exit(0);
            }
        }
    }

    // converts inputed String number to an int and returns it
    static int inputInt(String Prompt) {
        int result = 0;
        try {
            result = Integer.parseInt(input(Prompt).trim());
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }
    
    // reads and prints the promt inputed and returns the line responded in the console
    static String input(String prompt) {
        String inputLine = "";
        System.out.print(prompt);
        try {
            java.io.InputStreamReader sys = new java.io.InputStreamReader(System.in);
            java.io.BufferedReader inBuffer = new java.io.BufferedReader(sys);
            inputLine = inBuffer.readLine();
        } catch (Exception e) {
            String err = e.toString();
            System.out.println(err);
        }
        return inputLine;
    }
}