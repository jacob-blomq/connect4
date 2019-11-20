package connect4;

import java.util.*;

public class play {
	
	
	
	public static void Main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			
			System.out.println("Player 1 Select a Piece (any Character)");
			char pO = scan.next().charAt(0);
			System.out.println("Player 2 Select a Piece (any Character)");
			char pT = scan.next().charAt(0);
			Board board = new Board(pO, pT);
			System.out.println("Setting up Board...");
			System.out.println(Board.clearBoard(board)); //getting static reference error (will need to change approach)
		}
	}

}
