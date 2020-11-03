/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 1.0, Dec 2019
 * @author joeyzhao
 */
import static org.junit.Assert.*;
import org.junit.Test;

/** 
 *  Used to test the implementation of the game logic in my board class.
 */

public class BoardTest {

	@Test
	public void testSlideUp() {
		Board b = new Board();
		b.slideUp();
		System.out.println();
		b.print();
		b.slideUp();
		System.out.println();
		b.print();
		b.slideUp();
		System.out.println();
		b.print();
		System.out.println();
		b.slideUp();
		System.out.println();
		b.print();
		System.out.println();
		System.out.print(b.getScore());
		System.out.println();
	}
	
	@Test
	public void testSlideDown() {
		Board b = new Board();
		b.slideDown();
		System.out.println();
		b.print();
		b.slideDown();
		System.out.println();
		b.print();
		b.slideDown();
		System.out.println();
		b.print();
		System.out.println();
		b.slideDown();
		System.out.println();
		b.print();
		System.out.println();
		System.out.print(b.getScore());
		System.out.println();
	}
	
	@Test
	public void testSlideRight() {
		Board b = new Board();
		b.slideRight();
		System.out.println();
		b.print();
		b.slideRight();
		System.out.println();
		b.print();
		b.slideRight();
		System.out.println();
		b.print();
		System.out.println();
		b.slideRight();
		System.out.println();
		b.print();
		System.out.println();
		System.out.print(b.getScore());
		System.out.println();
	}
	
	@Test
	public void testSlideLeft() {
		Board b = new Board();
		b.slideLeft();
		System.out.println();
		b.print();
		b.slideLeft();
		System.out.println();
		b.print();
		b.slideLeft();
		System.out.println();
		b.print();
		System.out.println();
		b.slideLeft();
		System.out.println();
		b.print();
		System.out.println();
		System.out.print(b.getScore());
		System.out.println();
	}
	
	@Test
	public void testWinPass() {
		Board b = new Board();
		b.addSpecificRanTile(2048);
		System.out.println();
		b.print();
		assertEquals(true, b.checkForWin());
	}
	
	@Test
	public void testLoseFail() {
		Board b = new Board();
		// still able to merge
		b.addSpecificTile(2, 0, 0);
		b.addSpecificTile(2, 0, 1);
		b.addSpecificTile(3, 0, 2);
		b.addSpecificTile(4, 0, 3);
		b.addSpecificTile(5, 1, 0);
		b.addSpecificTile(6, 1, 1);
		b.addSpecificTile(7, 1, 2);
		b.addSpecificTile(8, 1, 3);
		b.addSpecificTile(9, 2, 0);
		b.addSpecificTile(10, 2, 1);
		b.addSpecificTile(11, 2, 2);
		b.addSpecificTile(12, 2, 3);
		b.addSpecificTile(13, 3, 0);
		b.addSpecificTile(14, 3, 1);
		b.addSpecificTile(15, 3, 2);
		b.addSpecificTile(16, 3, 3);
		System.out.println();
		b.print();
		assertEquals(false, b.checkForLost());
	}
	
	@Test
	public void testLosePass() {
		Board b = new Board();
		b.addSpecificTile(1, 0, 0);
		b.addSpecificTile(2, 0, 1);
		b.addSpecificTile(3, 0, 2);
		b.addSpecificTile(4, 0, 3);
		b.addSpecificTile(5, 1, 0);
		b.addSpecificTile(6, 1, 1);
		b.addSpecificTile(7, 1, 2);
		b.addSpecificTile(8, 1, 3);
		b.addSpecificTile(9, 2, 0);
		b.addSpecificTile(10, 2, 1);
		b.addSpecificTile(11, 2, 2);
		b.addSpecificTile(12, 2, 3);
		b.addSpecificTile(13, 3, 0);
		b.addSpecificTile(14, 3, 1);
		b.addSpecificTile(15, 3, 2);
		b.addSpecificTile(16, 3, 3);
		System.out.println();
		b.print();
		assertEquals(true, b.checkForLost());
	}
	
	@Test
	public void testMergeUp() {
		Board b = new Board();
		b.emptyBoard();
		b.addSpecificTile(2, 0, 0);
		b.addSpecificTile(2, 0, 1);
		b.addSpecificTile(4, 0, 2);
		b.addSpecificTile(4, 0, 3);
		b.print();
		b.mergeUp();
		System.out.println();
		b.print();
		assertEquals(12, b.getScore());
	}
	
	@Test
	public void testMergeDown() {
		Board b = new Board();
		b.emptyBoard();
		b.addSpecificTile(2, 0, 0);
		b.addSpecificTile(2, 0, 1);
		b.addSpecificTile(4, 0, 2);
		b.addSpecificTile(4, 0, 3);
		b.print();
		b.mergeDown();
		System.out.println();
		b.print();
		assertEquals(12, b.getScore());
	}
	
	@Test
	public void testMergeLeft() {
		Board b = new Board();
		b.emptyBoard();
		b.addSpecificTile(2, 0, 0);
		b.addSpecificTile(2, 1, 0);
		b.addSpecificTile(4, 2, 0);
		b.addSpecificTile(4, 3, 0);
		b.print();
		b.mergeLeft();
		System.out.println();
		b.print();
		assertEquals(12, b.getScore());
	}
	
	@Test
	public void testMergeRight() {
		Board b = new Board();
		b.emptyBoard();
		b.addSpecificTile(2, 0, 0);
		b.addSpecificTile(2, 1, 0);
		b.addSpecificTile(4, 2, 0);
		b.addSpecificTile(4, 3, 0);
		b.print();
		b.mergeRight();
		System.out.println();
		b.print();
		assertEquals(12, b.getScore());
	}
	
	@Test
	public void testSaveGame() {
		Board b = new Board();
		b.addSpecificTile(1, 0, 0);
		b.addSpecificTile(2, 0, 1);
		b.addSpecificTile(3, 0, 2);
		b.addSpecificTile(4, 0, 3);
		b.addSpecificTile(5, 1, 0);
		b.addSpecificTile(6, 1, 1);
		b.addSpecificTile(7, 1, 2);
		b.addSpecificTile(8, 1, 3);
		b.addSpecificTile(9, 2, 0);
		b.addSpecificTile(10, 2, 1);
		b.addSpecificTile(11, 2, 2);
		b.addSpecificTile(12, 2, 3);
		b.addSpecificTile(13, 3, 0);
		b.addSpecificTile(14, 3, 1);
		b.addSpecificTile(15, 3, 2);
		b.addSpecificTile(16, 3, 3);
		b.save();
		System.out.println();
		b.print();
	}
	
	@Test 
	public void testLoad() {
		Board b = new Board(); 
		b.load(); 
		b.print();
	}

}
