import java.util.Scanner;

public class play {
	

	
	public static void main(String[] args)
	{	
		int col;
		int cp;
		char pT;
		char pO;
		boolean valid;
		
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Player 1 Select a Piece (any Character)");
		pO = scan.next().charAt(0);
		System.out.println("Player 2 Select a Piece (any Character)");
		pT = scan.next().charAt(0);
		Board board = new Board(pO, pT);
		System.out.println("Setting up Board");
		board.clearBoard(board);
		board.printBoard(board.getBoard(board));
		
		System.out.println("--------Let's chose who goes first---------");
		
		board.decideturn();
		cp = board.currentplayer();
		System.out.print("\nPlayer " + cp + " your turn first!");			
		board.printBoard(board.getBoard(board));
		System.out.print("Pick a column: ");
		
		for(int i = 0; i < 42; i++)
		{ 
			col = scan.nextInt();
			valid = board.turn(cp, col, board);
			board.printBoard(board.getBoard(board));
			while(valid == false)
			{
				col = scan.nextInt();
				valid = board.turn(cp, col, board);
				board.printBoard(board.getBoard(board));
			}
			cp = (cp + 1) % 2;
			System.out.println(cp);
		}
		
		board.printBoard(board.getBoard(board));
	}

}
