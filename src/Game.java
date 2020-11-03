/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 1.0, Dec 2019
 * @author joeyzhao
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Game2048 Main class that specifies the frame and widgets of the GUI
 */
public class Game implements Runnable {
	public void run() {
    	// Instructions Window
    	final JFrame instructionsFrame = new JFrame("Instructions");
    	instructionsFrame.setLocation(50, 100);
    	final JPanel instructionsPanel = new JPanel();
    	instructionsFrame.getContentPane().add(instructionsPanel);
    	
        final JLabel body = new JLabel("<html>" + "Feel Good 2048 Instructions   <br>"
        								+ "<br>"
        								+ "HOW TO PLAY:                <br>" 
        								+"<br>"
        								+ "Use your arrow keys to move the tiles.            <br>"
        								+ "When two tiles with the same number touch, "
        								+ "they merge into one!        <br>"
        								+ "Win by reaching the 2048 tile. <br>"
        								+ "If the board is full and no tiles can merge, the game is"
        								+ " over. <br>"
        								+ "Feel free to save the game and return to it at anytime. "
        								+ "<br>"
        								+ "Close this window to begin the game. <br>"
        								+ "Have fun! <br>"
        								+ "<br>"
        								+ "A game designed by a Penn student for Penn students.<br>"
        								+ "<br>"
        								+ "CIS 120 Game HW <br>"
        								+ "(c) University of Pennsylvania <br>"
        								+ "@version 1.0, Dec 2019 <br>"
        								+ "@author joeyzhao <br>"
        								+ "<br>"
        								+ "<html/>");
        instructionsPanel.add(body);
		
        // Top-level frame in which game components live
        final JFrame frame = new JFrame("Feel Good 2048");
        frame.setLocation(500, 300);
        
        // Status panel
        final JPanel status_panel = new JPanel();
        frame.add(status_panel, BorderLayout.SOUTH);
        final JLabel status = new JLabel("Running...");
        status_panel.add(status);

        // Main playing area
        final GameBoard board = new GameBoard(status);
        frame.add(board, BorderLayout.CENTER);
        
        // New game button
        final JPanel control_panel = new JPanel();
        frame.add(control_panel, BorderLayout.NORTH);

        // Note here that when we add an action listener to the reset button, we define it as an
        // anonymous inner class that is an instance of ActionListener with its actionPerformed()
        // method overridden. When the button is pressed, actionPerformed() will be called.
        final JButton reset = new JButton("New Game");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.reset();
            }
        });
        control_panel.add(reset);
        
        // Save game button
        final JButton save = new JButton("Save Game");
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.save();
            }
        });
        control_panel.add(save);
        
        // Resume game button
        final JButton resume = new JButton("Resume Game");
        resume.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.resume();
                board.repaint();
            }
        });
        control_panel.add(resume);
        
        // Instructions button
        final JButton instructionsButton = new JButton("Instructions");
        instructionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//Put the instructions frame on the screen
                instructionsFrame.pack();
                instructionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                instructionsFrame.setVisible(true);
                // Start game
                board.reset();
            }
        });
        control_panel.add(instructionsButton);

        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Start game
        board.reset();
    
        }
	
        /**
         * Main method run to start and run the game. Initializes the GUI elements specified in Game and
         * runs it. IMPORTANT: Do NOT delete! You MUST include this in your final submission.
         */
        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Game());
        }
}
