package yahtzee;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Window {
	
	// displays a message dialogue box
    public void msg(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    // displays an input dialogue box
    public String in(String msg) {
        return JOptionPane.showInputDialog(null, msg);
    }
   // public int option(String[] options, String msg, String string, int informationMessage, ImageIcon dice) {
        // default option
   // }
    
    // prints a line containing msg
    public void println(String msg) {
        System.out.println(msg);
    }
    
    // displays an option dialogue box
	public int option(String[] options, String msg, String string, int informationMessage, ImageIcon dice) {
		return JOptionPane.showOptionDialog(
                null,
                msg, // my message
                "Click a button", // dialog box title
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options, // possible options
                options[0]);
	}
}