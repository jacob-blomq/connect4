import java.util.Random; 

public class Board {
	
	char playerOne;
	char playerTwo;
	int cplayer;
	
	int[] colCount;
	
	char[][] boardArray;
	
	public Board(char playerOne, char PlayerTwo){
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
		return colCount[col - 1];
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
	}
	
	//executes turn by prompting player to place piece
	public void turn(int player, int column, Board b){
		if(player == 1) 
		{
			if(b.getColCount(column) < 7)
			{
				getBoard(b)[5 - b.getColCount(column)][column - 1] = b.playerOne;
				b.colCount[column - 1]++;
			}
			
		}
		if(player == 2) 
		{
			if(b.getColCount(column) < 7)
			{
				getBoard(b)[5 - b.getColCount(column)][column - 1] = b.playerOne;
				b.colCount[column - 1]++;
			}
			
		}
		
	}
	
	public int currentplayer() {
		return(cplayer);
	}
	
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
	
}
