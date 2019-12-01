import java.util.Random; 

public class Board {
	
	char playerOne;
	char playerTwo;
	int cplayer;
	int winner = 0;
	int turnCount = 0;
	int[] colCount;
	boolean turnValid;
	char[][] boardArray;
	
	public Board(char playerOne, char playerTwo){
		boardArray = new char[6][7];
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		colCount = new int[7];
	}
	
	public char getPlayerOne()
	{
		return playerOne;
	}
	
	public char getPlayerTwo()
	{
		return playerTwo;
	}
	
	public int getColCount(int col)
	{
		return colCount[col];
	}
	
	
	//clears board and fills it with emptyPiece variable
	public char[][] clearBoard(Board b){
		char emptyP = 'O';
		for(int i = 0; i < boardArray.length; i++)
		{
			for(int j = 0; j < boardArray[i].length; j++)
			{
				boardArray[i][j] = emptyP;
			}
		}
		boardArray = getBoard(b);
		return boardArray;
	}
	
	public void printBoard(char[][] boardArray)
	{
		System.out.println(" ");
		for(int i = 0; i < boardArray.length; i++)
		{
			for(int j = 0; j < boardArray[i].length; j++)
			{
				if(j == 6)
				{
					System.out.println("|" + boardArray[i][j] + "|");
				}
				else
				{
					System.out.print("|" + boardArray[i][j] + "|");
				}
			}
		}
		System.out.println(" 1  2  3  4  5  6  7");
	}
	
	//executes turn by prompting player to place piece
	public boolean turn(int player, int column, Board b){
		column--;
		if(player == 0) 
		{
			if(b.getColCount(column) <= 5)
			{
				getBoard(b)[5 - b.getColCount(column)][column] = b.playerOne;
				b.colCount[column]++;
				this.turnValid = true;
				return true;
			}
			System.out.println("This column is full! Pick another Column");
			this.turnValid = false;
			return false;
		}

		if(b.getColCount(column) <= 5)
		{
			getBoard(b)[5 - b.getColCount(column)][column] = b.playerTwo;
			b.colCount[column]++;
			this.turnValid = true;
			return true;
		}
		System.out.println("This column is full! Pick another Column");
		this.turnValid = false;
		return false;
	}
	
	public int currentplayer() { return(cplayer); }
	
	public void decideturn() {
		Random rand = new Random();
		cplayer = rand.nextInt(1 + 2);
	}
	
	//checks whether p1 or p2 has won the game
	public boolean checkWin(char[][]board, char playerOne, char playerTwo) {
		//if row is found return true
		if(true)
		{ 
			return true;
		}
		else //if no rows found return false
		{
			return false;
		}
	}
	
	//used for printing our board array
	public char[][] getBoard(Board b)
	{
		return boardArray;
	}

	public void endGame() {
		if (this.winner == 1) {
			System.out.println("Congratulations! Player 1 wins!");
		}

		if (this.winner == 2) {
			System.out.println("Congratulations! Player 2 wins!");
		}

		if (this.winner == 0) {
			System.out.println("It's a tie!");
		}	
	}
	
}