/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 1.0, Dec 2019
 * @author joeyzhao
 */

import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
//import java.util.LinkedList;
//import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;

/**
 * Board
 * 
 * This class holds the primary game logic for how the board interacts.
 */
public class Board {
	// images of the empty tile and empty grid
	public static final String EMPTY_FILE = "files/emptytile.png";
    private static BufferedImage empty;
    public static final String IMG_FILE = "files/emptygrid.png";
    private static BufferedImage img;
    
	private final int target_score = 2048;
	private Tile[][] grid;
	private int col;
	private int row;
	private int score; 
	
	// buffer reader and file writer to save the current game state to a file
	private Writer fileWriter;
	private BufferedReader breader;
	private static File curr;
	
//	private int currLevel;
//	private List<Integer> levels = new LinkedList<Integer>();
    
	public Board() {
		
		// draws a new board
		try {
            if (img == null) {
                img = ImageIO.read(new File(IMG_FILE));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
		
		// creates 4 by 4 tile grid
		grid = new Tile[4][4];
		
		if (curr != null) {
			load();
		} else {
			
		// generates two tiles
		Tile t1 = new Tile();
		Tile t2 = new Tile();
				
		// randomly places one tile
		int randomCol = (int) (Math.random() * 4);
		int randomRow = (int) (Math.random() * 4);
		grid[randomRow][randomCol] = t1;
				
		// randomly places the other tile
		randomCol = (int) (Math.random() * 4);
		randomRow = (int) (Math.random() * 4);
		grid[randomRow][randomCol] = t2;
		
		// initializes score to zero
		score = 0;
		
		try {
            if (empty == null) {
                empty = ImageIO.read(new File(EMPTY_FILE));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
		
		}
	}
	
	public void addTile() {
		// generates a new tile to the board
		Tile newTile = new Tile();
		
		int randomCol = (int) (Math.random() * 4);
		int randomRow = (int) (Math.random() * 4);
		
		// randomly places one tile at an empty slot
		while (this.grid[randomRow][randomCol] != null) {
			randomCol = (int) (Math.random() * 4);
			randomRow = (int) (Math.random() * 4);
		}
		grid[randomRow][randomCol] = newTile;
	}
	
	/** SlideUp ***********************************************************************************/
	/**
	 * Helper method to slide up
	 */
	private void slideUpHelper() {
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				
				// checks if there exists a tile
				if (this.grid[y][x] != null && y != 0) {
					
					// moves as high the tile can possibly move
					while (this.grid[y-1][x] == null) {
						
						// moves the tile up
						this.grid[y-1][x] = this.grid[y][x];
						this.grid[y][x] = null;
						if (y - 1 <= 0) {
							break;
						} 
						y--;
					}
				}
			}
		}
	}
	
	public void mergeUp() {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 4; x++) {
				if(this.grid[y][x] != null && this.grid[y+1][x] != null) {
					if (this.grid[y][x].getValue() == this.grid[y+1][x].getValue()) {
						this.grid[y][x].setValue(2 * this.grid[y][x].getValue());
						this.grid[y+1][x] = null;
						score += this.grid[y][x].getValue();
					}
				}
			}
		}
	}
	
	public void slideUp() {
		slideUpHelper();
		mergeUp();
		slideUpHelper();
		addTile();
	}
	
	/** SlideDown *********************************************************************************/
	/**
	 * Helper method to slide down
	 */
	private void slideDownHelper() {
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				
				// checks if there exists a tile
				if (this.grid[y][x] != null && y != 3) {
					
					// moves as down the tile can possibly move
					while (this.grid[y+1][x] == null) {
						
						// moves the tile down
						this.grid[y+1][x] = this.grid[y][x];
						this.grid[y][x] = null;
						if (y + 1 >= 3) {
							break;
						} 
						y++;
					}
				}
			}
		}
	}
	
	public void mergeDown() {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 4; x++) {
				if(this.grid[y][x] != null && this.grid[y+1][x] != null) {
					if (this.grid[y][x].getValue() == this.grid[y+1][x].getValue()) {
						this.grid[y+1][x].setValue(2 * this.grid[y][x].getValue());
						this.grid[y][x] = null;
						score += this.grid[y+1][x].getValue();
					}
				}
			}
		}
	}
	
	public void slideDown() {
		slideDownHelper();
		mergeDown();
		slideDownHelper();
		addTile();
	}
	
	/** SlideLeft *********************************************************************************/
	/**
	 * Helper method to slide left
	 */
	private void slideLeftHelper() {
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				
				// checks if there exists a tile
				if (this.grid[y][x] != null && x != 0) {
					
					// moves as left the tile can possibly move
					while (this.grid[y][x-1] == null) {
						
						// moves the tile left
						this.grid[y][x-1] = this.grid[y][x];
						this.grid[y][x] = null;
						if (x - 1 <= 0) {
							break;
						} 
						x--;
					}
				}
			}
		}
	}
	
	public void mergeLeft() {
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 3; x++) {
				if(this.grid[y][x] != null && this.grid[y][x+1] != null) {
					if (this.grid[y][x].getValue() == this.grid[y][x+1].getValue()) {
						this.grid[y][x].setValue(2 * this.grid[y][x].getValue());
						this.grid[y][x+1] = null;
						score += this.grid[y][x].getValue();
					}
				}
			}
		}
	}
	
	public void slideLeft() {
		slideLeftHelper();
		mergeLeft();
		slideLeftHelper();
		addTile();
	}
	
	/** SlideRight ********************************************************************************/
	/**
	 * Helper method to slide right
	 */
	private void slideRightHelper() {
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				
				// checks if there exists a tile
				if (this.grid[y][x] != null && x != 3) {
					
					// moves as right the tile can possibly move
					while (this.grid[y][x+1] == null) {
						
						// moves the tile right
						this.grid[y][x+1] = this.grid[y][x];
						this.grid[y][x] = null;
						if (x + 1 >= 3) {
							break;
						} 
						x++;
					}
				}
			}
		}
	}
	
	public void mergeRight() {
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 3; x++) {
				if(this.grid[y][x] != null && this.grid[y][x+1] != null) {
					if (this.grid[y][x+1].getValue() == this.grid[y][x].getValue()) {
						this.grid[y][x+1].setValue(2 * this.grid[y][x+1].getValue());
						this.grid[y][x] = null;
						score += this.grid[y][x+1].getValue();
					}
				}
			}
		}
	}
	
	public void slideRight() {
		slideRightHelper();
		mergeRight();
		slideRightHelper();
		addTile();
	}
	
	/** Game State ********************************************************************************/
	/*
	 * Helper function to check if adjacent columns have tiles of the same value
	 */
	private boolean checkAdjCol() {
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 3; x++) {
				if (this.grid[y][x] != null && this.grid[y][x+1] != null) {
					if (this.grid[y][x].getValue() == this.grid[y][x+1].getValue()) {
						return true;
					} 
				}
			} 
		}
		return false;
	}
	
	/*
	 * Helper function to check if adjacent rows have tiles of the same value
	 */
	private boolean checkAdjRow() {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 4; x++) {
				if (this.grid[y][x] != null && this.grid[y+1][x] != null) {
					if (this.grid[y][x].getValue() == this.grid[y+1][x].getValue()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean checkForWin() {
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				if (this.grid[y][x] != null) {
					// if there exists a 2048 tile in the board
					if (this.grid[y][x].getValue() == target_score) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean checkForLost() {
		int tileCount = 0;
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				if (this.grid[y][x] != null) {
					tileCount++;
				}
			}
		}
		
		return tileCount == 16 && !checkAdjRow() && !checkAdjCol();
	}
	
	/** GETTERS ***********************************************************************************/
	public Tile[][] getGrid() {
		return this.grid;
	}
	
	public int getCol() {
		return this.col;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getScore() {
		return this.score;
	}
	
	/** For testing purposes **********************************************************************/
	public void print() {
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				if (this.grid[y][x] == null) {
					System.out.print(0);
				} else {
					System.out.print(this.grid[y][x].getValue());
				}
			}
			System.out.println(); 
		}
	}
	
	public void addSpecificTile(int val, int col, int row) {
		// generates a new tile to the board
		Tile newTile = new Tile();
		newTile.setValue(val);
		grid[row][col] = newTile;
	}
	
	public void addSpecificRanTile(int val) {
		// generates a new tile to the board
		Tile newTile = new Tile();
		newTile.setValue(val);
		
		int randomCol = (int) (Math.random() * 4);
		int randomRow = (int) (Math.random() * 4);
		
		// randomly places one tile at an empty slot
		while (this.grid[randomRow][randomCol] != null) {
			randomCol = (int) (Math.random() * 4);
			randomRow = (int) (Math.random() * 4);
		}
		grid[randomRow][randomCol] = newTile;
	}
	
	public void emptyBoard() {
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				Tile empty = new Tile();
				empty.setValue(0);
				grid[y][x] = empty;
			}
		}
	}

	/** Saving purposes **************************************************************************/
	public void save() {
		try {
			// writes the current tiles into file
			fileWriter = new FileWriter("files/currentboard");
			for (int y = 0; y < 4; y++) {
				for (int x = 0; x < 4; x++) {
					if (this.grid[y][x] == null) {
						fileWriter.write("" + 0);
						fileWriter.flush();
						fileWriter.write(System.getProperty( "line.separator" ));
					} else {
						fileWriter.write("" + this.grid[y][x].getValue());
						fileWriter.flush();
						fileWriter.write(System.getProperty( "line.separator" ));
					}
				}
			}
			// writes the current score into file
			fileWriter.write("" + getScore());
		} catch (IOException e) {
			System.out.println();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				System.out.println();
			}
		}
	}
	
	public void load() {
		try {
			// reads the tiles
			breader = new BufferedReader(new FileReader("files/currentboard"));
			String l = breader.readLine();
			for (int y = 0; y < 4; y++) {
				for (int x = 0; x < 4; x++) {
					int val = Integer.parseInt(l);
					if (val == 0) {
						this.grid[y][x] = null;
					} else {
						Tile tile = new Tile();
						tile.setValue(val);
						this.grid[y][x] = tile;
					}
					l = breader.readLine();
				}
			}
			// reads the score
			int val = Integer.parseInt(l);
			score = val;
		} catch (IOException e) {
			System.out.println("IOE Exception");
		} finally {
			try {
				breader.close();
			} catch (IOException e) {
				System.out.println();
			}
		}
	}
	
	/** Leveling purposes *************************************************************************/
	public int getLevel() {
		Map<Integer, Integer> scores = new TreeMap<Integer, Integer>();
		scores.put(100, 1);
		scores.put(500, 2);
		scores.put(1000, 3);
		scores.put(2000, 4);
		scores.put(5000, 5);
		scores.put(9000, 6);
		scores.put(10000, 7);
		scores.put(20000, 8);
		scores.put(50000, 9);
		scores.put(100000, 10);
		
		for (int score : scores.keySet()) {
			if (getScore() <= score) {
				return scores.get(score);
			}
		}
	
		// for special messages
		scores.put(26, 26);
		scores.put(526, 26);
		scores.put(5260, 26);
		scores.put(52600, 26);
		scores.put(526000, 26);
		scores.put(830, 83);
		scores.put(8300, 83);
		scores.put(83000, 83);
		scores.put(830000, 83);
		scores.put(1126, 11);
		scores.put(11260, 11);
		scores.put(112600, 11);
		scores.put(230, 23);
		scores.put(5230, 23);
		scores.put(52300, 23);
		scores.put(523000, 23);
		
		for (int score : scores.keySet()) {
			if (getScore() == score) {
				return scores.get(score);
			}
		}
		return 0;
	}
	
	/** Drawing purposes **************************************************************************/
    public void draw(Graphics g) {
        g.drawImage(img, 100, 100, 600, 600, null);
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				if (this.grid[y][x] == null) {
					g.drawImage(empty, x * 150 + 100, y * 150 + 100, 150, 150, null);

				} else {
					g.drawImage(grid[y][x].getImg(), x * 150 + 100, y * 150 + 100, 150, 150, null);
				}
			}

		}
	}
    
}
