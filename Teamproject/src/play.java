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
			cp = board.getStartingPlayer();
			System.out.println("\nPlayer " + (cp) + " your turn first!");	
			System.out.println(board.printBoard(board.getBoard(board)));
			
			//Game Loop
			for(int i = 0; i < 42; i++)
			{ 
				System.out.print("Player " + (cp) + " Pick a Column: ");
				col = scan.nextInt();
				if(col > 7)
				{
					System.out.println("Please Pick a Column 1-7!");
					col = scan.nextInt();
				}
				else
				{
					valid = board.turn(cp, col, board);
					System.out.println(board.printBoard(board.getBoard(board)));
					while(valid == false)
					{
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
							System.out.println(board.printBoard(board.getBoard(board)));
						}	
					}
				}
				boolean status = board.checkWin(cp);
				if(status == true)
				{
					System.out.println("Player: " + cp + " Wins!");
					break;
				}
				if(cp == 1)
				{
					cp = 2;
				}
				else if(cp == 2)
				{
					cp = 1;
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
