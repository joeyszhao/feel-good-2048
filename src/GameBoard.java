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
 * GameBoard class stores the key listeners and when to stop the game when the game is lost/won.
 * In addition to desplaying the status of the game and the current score as well as the level when
 * a certain score is reached.
 */
@SuppressWarnings("serial")
public class GameBoard extends JPanel {

	private Board board;
	public boolean playing = false; // whether the game is running 
	private JLabel status; // Current status text, i.e. "Running..."
	
	// Game constants
    public static final int COURT_WIDTH = 800;
    public static final int COURT_HEIGHT = 800;
    
    public GameBoard(JLabel status) {
    	// creates border around the court area, JComponent method
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        // update the display
        repaint();
        
        // Enable keyboard focus on the court area.
        // When this component has the keyboard focus, key events are handled by its key listener.
        setFocusable(true);

        // This key listener allows the square to move as long as an arrow key is pressed, by
        // changing the square's velocity accordingly. (The tick method below actually moves the
        // square.)
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                	board.slideLeft();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                	board.slideRight();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                	board.slideDown();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                	board.slideUp();
                }
                repaint();
                if (board.getLevel() == 1) {
            		status.setText("Beep! Level 1!"); 
            	} else if (board.getLevel() == 2) {
    				status.setText("Boop! Level 2!"); 
    			} else if (board.getLevel() == 3) {
    				status.setText("Bop! Level 3!"); 
    			} else if (board.getLevel() == 4) {
    				status.setText("You're on a streak here! Level 4!"); 
    			} else if (board.getLevel() == 5) {
    				status.setText("Beep! Level 5!"); 
    			} else if (board.getLevel() == 6) {
    				status.setText("Boop! Level 6!"); 
    			} else if (board.getLevel() == 7) {
    				status.setText("Bop! Level 7!"); 
    			} else if (board.getLevel() == 8) {
    				status.setText("Yas, use that Penn education! Level 8!"); 
    			} else if (board.getLevel() == 9) {
    				status.setText("Beep! Level 9!"); 
    			} else if (board.getLevel() == 10) {
    				status.setText("Wowza, you're a champion! Level 10!"); 
    			} else if (board.getLevel() == 26) {
    				status.setText("Do good and good will come to you!");
    			} else if (board.getLevel() == 83) {
    				status.setText("You can't live a positive life with a negative mind!");
    			} else if (board.getLevel() == 11) {
    				status.setText("All limitations are self-imposed! You will succeed!");
    			} else if (board.getLevel() == 23) {
    				status.setText("Strive for progress, not perfection!");
    			} else {
    				
    			}
            	if (board.checkForLost()) {
            		status.setText("You lose!"); 
            	} else if (board.checkForWin()) {
            		status.setText("You win!");
            	}
            }
            
            public void keyReleased(KeyEvent e) {
            	return;
            }
            
      });
        this.status = status;
        
    }
    
    /**
     * (Re-)set the game to its initial state.
     */
    public void reset() {
    	board = new Board();
    	
    	playing = true;
        status.setText("Running...");
        
        // Make sure that this component has the keyboard focus
        requestFocusInWindow();
    }
    
    public void save() {
    	board.save();
    	playing = true;
        status.setText("Saved!");
        
        // Make sure that this component has the keyboard focus
        requestFocusInWindow();
    }
    
    public void resume() {
    	board.load();
    	playing = true;
        status.setText("Running...");
        
        // Make sure that this component has the keyboard focus
        requestFocusInWindow();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        board.draw(g);
        
        // draws score
        Font myFont = new Font("Tahoma", Font.BOLD, 50);
        g.setFont(myFont);
        g.drawString("" + board.getScore(), 350, 65);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(COURT_WIDTH, COURT_HEIGHT);
    }
}
