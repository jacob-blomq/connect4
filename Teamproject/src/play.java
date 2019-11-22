import java.util.Scanner;

public class play {
	
	
	
	public static void main(String[] args)
	{	
			Scanner scan = new Scanner(System.in);
			System.out.println("Player 1 Select a Piece (any Character)");
			char pO = scan.next().charAt(0);
			System.out.println("Player 2 Select a Piece (any Character)");
			char pT = scan.next().charAt(0);
			Board board = new Board(pO, pT);
			System.out.println("Setting up Board");
			System.out.println(board.clearBoard(board));
			System.out.println("--------Let's chose who goes first---------");
			board.decideturn();
			int cp = board.currentplayer();
			System.out.print("\nPlayer " + cp + " your turn first!");			
			
		
	}

}
