/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 1.0, Dec 2019
 * @author joeyzhao
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Tile
 * 
 * A tile that stores a value and is moved throughout the game.
 *
 */
public class Tile{
	private int value;
	
	public static final String EMPTY_FILE = "files/emptytile.png";
	public static final String TWO_FILE = "files/2.png";
	public static final String FOUR_FILE = "files/4.png";
	public static final String EIGHT_FILE = "files/8.png";
	public static final String SIXTEEN_FILE = "files/16.png";
	public static final String THIRTYTWO_FILE = "files/32.png";
	public static final String SIXTYFOUR_FILE = "files/64.png";
	public static final String ONETWOEIGHT_FILE = "files/128.png";
	public static final String TWOFIVESIX_FILE = "files/256.png";
	public static final String FIVEONETWO_FILE = "files/512.png";
	public static final String ONEZEROTWOFOUR_FILE = "files/1024.png";
	public static final String TWENTYFOURTYEIGHT_FILE = "files/2048.png";
	
    private static BufferedImage empty;
    private static BufferedImage two;
    private static BufferedImage four;
    private static BufferedImage eight;
    private static BufferedImage sixteen;
    private static BufferedImage thirtytwo;
    private static BufferedImage sixtyfour;
    private static BufferedImage onetwoeight;
    private static BufferedImage twofivesix;
    private static BufferedImage fiveonetwo;
    private static BufferedImage onezerotwofour;
    private static BufferedImage twentyfortyeight;
	
	public Tile() {
		
		// empty tile image
		try {
            if (empty == null) {
                empty = ImageIO.read(new File(EMPTY_FILE));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
		
		// 2 tile image
		try {
		     if (two == null) {
		         two = ImageIO.read(new File(TWO_FILE));
		     }
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
		
		// 4 tile image
		try {
			if (four == null) {
				four = ImageIO.read(new File(FOUR_FILE));
				}
			} catch (IOException e) {
				System.out.println("Internal Error:" + e.getMessage());
				}
				
		// 8 tile image
		try {
			if (eight == null) {
				eight = ImageIO.read(new File(EIGHT_FILE));
				}
			} catch (IOException e) {
				System.out.println("Internal Error:" + e.getMessage());
				}
		
		// 16 tile image
		try {
			if (sixteen == null) {
				sixteen = ImageIO.read(new File(SIXTEEN_FILE));
				}
			} catch (IOException e) {
				System.out.println("Internal Error:" + e.getMessage());
				}
		
		// 32 tile image
		try {
			if (thirtytwo == null) {
				thirtytwo = ImageIO.read(new File(THIRTYTWO_FILE));
				}
			} catch (IOException e) {
				System.out.println("Internal Error:" + e.getMessage());
				}
		
		// 64 tile image
		try {
			if (sixtyfour == null) {
				sixtyfour = ImageIO.read(new File(SIXTYFOUR_FILE));
				}
			} catch (IOException e) {
				System.out.println("Internal Error:" + e.getMessage());
				}
		
		// 128 tile image
		try {
			if (onetwoeight == null) {
				onetwoeight = ImageIO.read(new File(ONETWOEIGHT_FILE));
				}
			} catch (IOException e) {
				System.out.println("Internal Error:" + e.getMessage());
				}
		
		// 256 tile image
		try {
			if (twofivesix == null) {
				twofivesix = ImageIO.read(new File(TWOFIVESIX_FILE));
				}
			} catch (IOException e) {
				System.out.println("Internal Error:" + e.getMessage());
				}
		
		// 512 tile image
		try {
			if (fiveonetwo == null) {
				fiveonetwo = ImageIO.read(new File(FIVEONETWO_FILE));
				}
			} catch (IOException e) {
				System.out.println("Internal Error:" + e.getMessage());
				}
		
		// 1024 tile image
		try {
			if (onezerotwofour == null) {
				onezerotwofour = ImageIO.read(new File(ONEZEROTWOFOUR_FILE));
				}
			} catch (IOException e) {
				System.out.println("Internal Error:" + e.getMessage());
				}
		
		// 2048 tile image
		try {
			if (twentyfortyeight == null) {
				twentyfortyeight = ImageIO.read(new File(TWENTYFOURTYEIGHT_FILE));
				}
			} catch (IOException e) {
				System.out.println("Internal Error:" + e.getMessage());
				}
		
		// randomly assigns the value 2 or 4 to a new tile
		double random = Math.random();
		if (random > 0.4) {
			this.value = 2;
		} else {
			this.value = 4;
		}
	}
	
	/** Drawing purposes **************************************************************************/
	public BufferedImage getImg() {
		
		// returns the corresponding image with the value
		if (getValue() == 2) {
			return two;
		} else if (getValue() == 4) {
			return four;
		} else if (getValue() == 8) {
			return eight;
		} else if (getValue() == 16) {
			return sixteen;
		} else if (getValue() == 32) {
			return thirtytwo;
		} else if (getValue() == 64) {
			return sixtyfour;
		} else if (getValue() == 128) {
			return onetwoeight;
		} else if (getValue() == 256) {
			return twofivesix;
		} else if (getValue() == 512) {
			return fiveonetwo;
		} else if (getValue() == 1024) {
			return onezerotwofour;
		} else if (getValue() == 2048) {
			return twentyfortyeight;
			} else {
			return empty;
		}
		
    }
	
	/** GETTER ***********************************************************************************/
	public int getValue() {
		return this.value;
	}
	
	/** SETTER ***********************************************************************************/
	public void setValue(int val) {
		this.value = val;
	}


}
