package connect4;

import java.util.Scanner;

public class play {
	public static void main(String[] args)
	{	
		while(true)
		{
			//Variable Initialization
			int col;
			int cp;
			char pT;
			char pO;
			boolean valid;
			
			//Player Initialization
			Scanner scan = new Scanner(System.in);
			System.out.println("Player 1 Select a Piece (any Character)");
			pO = scan.next().charAt(0);
			System.out.println("Player 2 Select a Piece (any Character)");
			pT = scan.next().charAt(0);
			
			//Board Initialization
			Board board = new Board(pO, pT);
			System.out.println("-------------Setting up Board-------------");
			board.clearBoard(board);
			
			//Deciding First Player
			System.out.println("--------Let's chose who goes first---------");
			board.decideturn();
			cp = board.currentplayer();
			System.out.println("\nPlayer " + (cp+1) + " your turn first!");	
			board.printBoard(board.getBoard(board));
			
			//Game Loop
			for(int i = 0; i < 42; i++)
			{ 
					System.out.print("Player " + (cp+1) + " Pick a Column: ");
					col = scan.nextInt(); 
					board.printBoard(board.getBoard(board));
					if(col > 7)
					{
						System.out.println("Please Pick a Column 1-7!");
						col = scan.nextInt();
					}
					else {
						valid = board.turn(cp, col, board);
						while(valid == false)
						{	boolean res = board.checkWin();
							while(res == false) {
								System.out.print("Player " + (cp+1) + " Pick a Column: ");
								col = scan.nextInt();
								if(col > 7)
								{
									System.out.println("Please Pick a Column 1-7!");
									col = scan.nextInt();
								}
								else
								{
									valid = board.turn(cp, col, board);
									board.printBoard(board.getBoard(board));
								}	
								
							}
						cp = (cp + 1) % 2;
						}
					
				}
			}
			System.out.print("Play Again?: Y/N: ");
			String decision = scan.next();
			if(decision.equals("n") || decision.equals("N"))
			{
				break;
			}
		}
	}		
}