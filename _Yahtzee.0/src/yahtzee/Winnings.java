package yahtzee;

import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

class Winnings {
	
	// Instance Variables
    private int score;
    private int choice;
    
    int lstraight = 0;
	int sstraight = 0;
	int fh = 0;
	int ones1 = 0;
	int twos1 = 0;
	int threes1 = 0;
	int fours1 = 0;
	int fives1 = 0;
	int sixes1 = 0;
	int fourkind = 0;
	int threekind = 0;
	int yaht1 = 0;
	int cchance = 0;
		
	static int endGame = 0;
		
    private static final String[] Choose = { "[1]", "[2]", "[3]", "[4]", "[5]", "[6]", "[7]", "[8]", "[9]", "[10]", "[11]", "[12]", "[13]"};
    public static ImageIcon Dice = new ImageIcon(Main.class.getResource("tn-huge-yahtzeesingleplayer.png"));
    
    // Getter
 	public int getEnd() {
 		return endGame;
 	}
 	
 	// Constructor
    public Winnings() {
        score = 0;
    }

    // calculates all of the different possible winnings and compares it to the players roll, it then determines if the
    // players selected winnings are available to the player. If not the game will let them know and ask them to pick again.
    // Otherwise it will award them their points and display it to the screen in a JOptionPane message dialogue box
    public void checkWinnings(int[] aDice, int[] wins, boolean xd) {
    	
        Window w = new Window(); 
        while(xd) {
        int s = w.option(Choose, "Select your Winnings:\n"
        		+ "1 - Number of 1's\n"
        		+ "2 - Number of 2's\n"
        		+ "3 - Number of 3's\n" 
        		+ "4 - Number of 4's\n"
        		+ "5 - Number of 5's\n"
        		+ "6 - Number of 6's\n"
        		+ "7 - Three of a Kind\n"
        		+ "8 - Four of a Kind\n"
        		+ "9 - Full House\n"
        		+ "10 - Small straight\n"
        		+ "11 - Large Straight\n" 
        		+"12 - Chance\n"
        		+ "13 - Yahtzee"
        		
        		,"Yahtzee", JOptionPane.INFORMATION_MESSAGE, Dice);
       
        choice = s + 1;

        int x = 0, y = 0, winings = 0, winingsa = 0;
        int ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0;
        Arrays.sort(aDice);

        //Numbers
        for (y = 0; y < 5; y++) {
            if (aDice[y] == 1) {
                ones++;
            }
            if (aDice[y] == 2) {
                twos++;
            }
            if (aDice[y] == 3) {
                threes++;
            }
            if (aDice[y] == 4) {
                fours++;
            }
            if (aDice[y] == 5) {
                fives++;
            }
            if (aDice[y] == 6) {
                sixes++;
            }
        }

        //Straights
        if ((aDice[0] == aDice[1] - 1) && (aDice[1] == aDice[2] - 1)
                && (aDice[2] == aDice[3] - 1) && (aDice[3] == aDice[4] - 1)
                && (choice == 3)) {
            winingsa = 1;
        } else if ((ones > 0) && (twos > 0) && (threes > 0) && (fours > 0)) {
            winingsa = 2;
        } else if ((threes > 0) && (fours > 0) && (fives > 0) && (sixes > 0)) {
            winingsa = 2;
        } else if ((twos > 0) && (threes > 0) && (fours > 0) && (fives > 0)) {
            winingsa = 2;
        }

        //Pairs
        for (x = 0; x < 5; x++) {
            if (x != 0) {
                if ((aDice[0] == aDice[x])) {
                    winings++;
                }
            }
            if ((x != 0) && (x != 1)) {
                if ((aDice[1] == aDice[x])) {
                    winings++;
                }
            }
            if ((x != 0) && (x != 1) && (x != 2)) {
                if ((aDice[2] == aDice[x])) {
                    winings++;
                }
            }
            if ((x != 0) && (x != 1) && (x != 2) && (x != 3)) {
                if ((aDice[3] == aDice[x])) {
                    winings++;
                }
            }
        }
  	  
        //Winnings
        if ((choice == 11)) {
        	if(lstraight == 0) {
        		if((winingsa == 1)) {
        	 JOptionPane.showMessageDialog(null, "Large Straight.", "Large Straight", JOptionPane.INFORMATION_MESSAGE);
            score = 40;
            lstraight++;
            endGame++;
            xd = false;
        	}
        		else {
        			JOptionPane.showMessageDialog(null, "You don't have this winning one and will therefore recieve zero points");
        			score = 0;
        			lstraight++;
        	        endGame++;
        	        xd = false;
        		}
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "You've already chosen this winning, pick a different one.", "Yahtzee", JOptionPane.INFORMATION_MESSAGE);
        	}
        } 
        else if ((choice == 10)) {
        	if(sstraight == 0) {
        		if((winingsa == 2)) {
        			 JOptionPane.showMessageDialog(null, "Small Straight.", "Small Straight", JOptionPane.INFORMATION_MESSAGE);
        			 score = 30;
        			 sstraight++;
        			 endGame++;
        			 xd = false;
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "You don't have this winning one and will therefore recieve zero points");
        			score = 0;
        			sstraight++;
        	        endGame++;
        	        xd = false;
        		}
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "You've already chosen this winning, pick a different one.", "Yahtzee", JOptionPane.INFORMATION_MESSAGE);
        	}
        } 
        
        else if ((choice == 13)) {
        	if(yaht1 == 0) {
        		if((winings == 10)) {
        			 JOptionPane.showMessageDialog(null, "Yahtzee!", "Yahtzee", JOptionPane.INFORMATION_MESSAGE);
        			 score = 50;
        			 yaht1++;
        			 endGame++;
        			 xd = false;
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "You don't have this winning one and will therefore recieve zero points");
        			score = 0;
        			yaht1++;
        	        endGame++;
        	        xd = false;
        		}
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "You've already chosen this winning, pick a different one.", "Yahtzee", JOptionPane.INFORMATION_MESSAGE);
        	}
        } 
        
        else if ((choice == 7)) {
        	if(threekind == 0) {
        		if((winings >= 3)) {
        	 JOptionPane.showMessageDialog(null, "Three of a Kind.", "Three of a Kind", JOptionPane.INFORMATION_MESSAGE);
            score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4];
            threekind++;
            endGame++;
            xd = false;
        	}
        		else {
        			JOptionPane.showMessageDialog(null, "You don't have this winning one and will therefore recieve zero points");
        			score = 0;
        			threekind++;
        	        endGame++;
        	        xd = false;
        		}
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "You've already chosen this winning, pick a different one.", "Yahtzee", JOptionPane.INFORMATION_MESSAGE);
        	}
        } else if ((choice == 9)) {
        	if(fh == 0) {
        		if((winings == 4)) {
        	JOptionPane.showMessageDialog(null, "Full House.", "Full House", JOptionPane.INFORMATION_MESSAGE);
            score = 25;
            fh++;
            endGame++;
            xd = false;
        	}
        		else {
        			JOptionPane.showMessageDialog(null, "You don't have this winning one and will therefore recieve zero points");
        			score = 0;
        			fh++;
        	        endGame++;
        	        xd = false;
        		}
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "You've already chosen this winning, pick a different one.", "Yahtzee", JOptionPane.INFORMATION_MESSAGE);
        	}
        } else if ((choice == 8)) {
        	if(fourkind == 0) {
        		if((winings >= 6)) {
        	JOptionPane.showMessageDialog(null, "Four of a Kind.", "Four of a Kind", JOptionPane.INFORMATION_MESSAGE);
            score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4];
            fourkind++;
            endGame++;
            xd = false;
        	}
        		else {
        			JOptionPane.showMessageDialog(null, "You don't have this winning one and will therefore recieve zero points");
        			score = 0;
        			fourkind++;
        	        endGame++;
        	        xd = false;
        		}
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "You've already chosen this winning, pick a different one.", "Yahztee", JOptionPane.INFORMATION_MESSAGE);
        	}
        	
        	
        	
        } else if (choice == 1) {
        	if(ones1 == 0) {
        	JOptionPane.showMessageDialog(null, "You have: " + ones + " ones.", "Ones", JOptionPane.INFORMATION_MESSAGE);
            score = ones;
            ones1++;
            endGame++;
            xd = false;
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "You've already chosen this winning, pick a different one.", "Yahztee", JOptionPane.INFORMATION_MESSAGE);
        	}
        } else if (choice == 2) {
        	if(twos1 == 0) {
        	JOptionPane.showMessageDialog(null, "You have: " + twos + " twos.", "Twos", JOptionPane.INFORMATION_MESSAGE);
            score = twos * 2;
            twos1++;
            endGame++;
            xd = false;
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "You've already chosen this winning, pick a different one.", "Yahztee", JOptionPane.INFORMATION_MESSAGE);
        	}
        } else if (choice == 3) {
        	if(threes1 == 0) {
        	JOptionPane.showMessageDialog(null, "You have: " + threes + " threes.", "Threes", JOptionPane.INFORMATION_MESSAGE);
            score = threes * 3;
            threes1++;
            endGame++;
            xd = false;
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "You've already chosen this winning, pick a different one.", "Yahztee", JOptionPane.INFORMATION_MESSAGE);
        	}
        } else if (choice == 4) {
        	if(fours1 == 0) {
        	JOptionPane.showMessageDialog(null, "You have: " + fours + " fours.", "Fours", JOptionPane.INFORMATION_MESSAGE);
            score = fours * 4;
            fours1++;
            endGame++;
            xd = false;
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "You've already chosen this winning, pick a different one.", "Yahztee", JOptionPane.INFORMATION_MESSAGE);
        	}
        } else if (choice == 5) {
        	if(fives1 == 0) {
        	JOptionPane.showMessageDialog(null, "You have: " + fives + " fives.", "Fives", JOptionPane.INFORMATION_MESSAGE);
            score = fives * 5;
            fives1++;
            endGame++;
            xd = false;
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "You've already chosen this winning, pick a different one.", "Yahztee", JOptionPane.INFORMATION_MESSAGE);
        	}
        } else if (choice == 6) {
        	if(sixes1 == 0) {
        	JOptionPane.showMessageDialog(null, "You have: " + sixes + " sixes.", "Sixes", JOptionPane.INFORMATION_MESSAGE);
            score = sixes * 6;
            sixes1++;
            endGame++;
            xd = false;
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "You've already chosen this winning, pick a different one.", "Yahztee", JOptionPane.INFORMATION_MESSAGE);
        	}
        } else if (choice == 12) {
        	if(cchance == 0) {
            score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4];
            JOptionPane.showMessageDialog(null, "You have: " + score + " points.", "Yahztee", JOptionPane.INFORMATION_MESSAGE);
            cchance++;
            endGame++;
            xd = false;
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "You've already chosen this winning, pick a different one.", "Yahztee", JOptionPane.INFORMATION_MESSAGE);
        	}
        } else {
        	JOptionPane.showMessageDialog(null, "You gained no points", "Yahztee", 0);
    		score = 0;
    		xd = false;
        }
        }
    }

    // Getters
    public int score() {
        return (score);
    }

    public int choice() {
        return (choice);
    }
}