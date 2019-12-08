import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {
	
	Board instance;
	@BeforeEach
	void setUp() throws Exception {
		instance = new Board('c','s');
	}

	@AfterEach
	void tearDown() throws Exception {
		instance = null;
	}

	@Test
	void testGetPlayerOne() {
		char actual = 'c';
		char result = instance.getPlayerOne();
		assertEquals(actual, result);
	}

	@Test
	void testGetPlayerTwo() {
		char actual = 's';
		char result = instance.getPlayerTwo();
		assertEquals(actual, result);
	}

	@Test
	  void testClearBoard() {
			char[][] boardarray = new char[6][7] ;
			char empty = 'O';
			for(int i = 0; i < 6; i++)
			{
				for(int j = 0; j < 7; j++)
				{
					boardarray[i][j] = empty;
				}
				
			}
			 char [][] result = instance.clearBoard(instance);
			assertEquals(boardarray[0][0], result[0][0]);
		  }
	  
	  @Test 
	  void testTurn() {
		  boolean result = instance.turn(1, 1, instance);
		  assertTrue(result);
		  }

	  @Test 
	  void testCheckWin() {
		  boolean result = instance.checkWin(1);
		  assertFalse(result);
		  }
	
	 @Test 
	  void testDecideTurn() {
		  instance.decideturn();
		  int result = instance.cplayer;
		  assertTrue(result.equals(1) || result.equals(2));
	  }
	
	 @Test
	  void testPrintBoard() {
		  String result = instance.printBoard(instance.boardArray);
		  String expected = ("|O||O||O||O||O||O||O|\n"
				   + "|O||O||O||O||O||O||O|\n"
		  		   + "|O||O||O||O||O||O||O|\n"
		  		   + "|O||O||O||O||O||O||O|\n"
		  		   + "|O||O||O||O||O||O||O|\n
				   + "|O||O||O||O||O||O||O|\n"
				   + " 1  2  3  4  5  6  7");
		  assertEquals(result, expected);
	  

}
