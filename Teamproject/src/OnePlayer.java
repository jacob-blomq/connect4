package cn5;


import java.util.Random;
import java.util.Scanner;

public class OnePlayer {
	void play()
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
			System.out.println("Please Select a Piece (any Character)");
			pO = scan.next().charAt(0);
			
			//Board Initialization
			Board board = new Board(pO, '!');
			System.out.println("-------------Setting up Board-------------");
			board.clearBoard(board);
			
			//Deciding First Player
			System.out.println("--------Let's chose who goes first---------");
			board.decideturn();
			cp = board.getStartingPlayer();
			System.out.println("\nPlayer " + (cp) + " your turn first!");	
			System.out.println(board.printBoard(board.boardArray));
			
			//Game Loop
			for(int i = 0; i < 42; i++)
			{ 
				if (cp == 1) {
					System.out.print("Player " + (cp) + " Pick a Column: ");
					col = scan.nextInt();
					if(col > 7)
					{
						System.out.println("Please Pick a Column 1-7!");
						col = scan.nextInt();
					}
					else
					{
						
						valid = board.turn(cp, col);
						System.out.println(board.printBoard(board.boardArray));
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
								valid = board.turn(cp, col);
								System.out.println(board.printBoard(board.boardArray));
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
				else {
					col = 0;
					System.out.print("AI picking a column: ");
					char current = board.playerOne;
					char AI = board.playerTwo;
					
					Random rand = new Random();
					col = rand.nextInt(7) + 1;
					// AI blocks if 3 enemy horizontal pieces seen in a row
					for (int row = 0; row < board.boardArray.length; row++){
						for (int column = 0; column < board.boardArray[row].length - 3; column++){
							if (board.boardArray[row][column] == current && board.boardArray[row][column+1] == current && board.boardArray[row][column+2] == current){
								if (column + 5 < 7) {
									col = column - 1;
								}
								else {
									col = column + 4;
								}
							}							
						}
					}
					// AI places if three friendly pieces are seen in a row
					col = rand.nextInt(7) + 1;
					for (int row = 0; row < board.boardArray.length; row++){
						for (int column = 0; column < board.boardArray[row].length - 3; column++){
							if (board.boardArray[row][column] == AI && board.boardArray[row][column+1] == AI && board.boardArray[row][column+2] == AI){
								if (column + 4 > 7) {
									System.out.println("Found a win on the left");
									col = column;
								}
								else {
									System.out.println("Found a win on the right");
									col = column + 4;
								}
							}
							
						}
					}
					if(col > 7)
					{
						System.out.println("col bigger than 7, doing rand");
						col = rand.nextInt(7) + 1;
					}
					else
					{
						System.out.println(col);
						valid = board.turn(cp, col);
						System.out.println(board.printBoard(board.boardArray));
						while(valid == false)
						{
							System.out.print("Player " + (cp+1) + " Pick a Column: ");
							System.out.print("here");
							col = rand.nextInt(7) + 1;
							if(col > 7)
							{
								System.out.println("going here");
								col = rand.nextInt(7) + 1;
							}
							else
							{
								valid = board.turn(cp, col);
								System.out.println(board.printBoard(board.boardArray));
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
