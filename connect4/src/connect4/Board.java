package connect4;

import java.util.Random; 

public class Board {
	
	char playerOne;
	char playerTwo;
	int cplayer;
	
	int[] colCount;
	
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
				return true;
			}
			System.out.println("This column is full! Pick another Column");
			return false;
		}

		if(b.getColCount(column) <= 5)
		{
			getBoard(b)[5 - b.getColCount(column)][column] = b.playerTwo;
			b.colCount[column]++;
			return true;
		}
		System.out.println("This column is full! Pick another Column");
		return false;
	}
	
	public int currentplayer() { return(cplayer); }
	
	public void decideturn() {
		Random rand = new Random();
		cplayer = rand.nextInt(1);
	}
	
	//checks whether p1 or p2 has won the game
	public boolean checkWin() {
		//check horizantal 
		for (int row = 0; row < boardArray.length; row++){
			for (int col = 0; col < boardArray[row].length - 3; col++){
				if (boardArray[row][col] != '□' && boardArray[row][col] == boardArray[row][col+1] && boardArray[row][col] == boardArray[row][col+2] && boardArray[row][col] == boardArray[row][col +3]){
					return true;
				}
			}
		}
		//check vertical
		for (int col = 0; col < boardArray[0].length; col++){
			for (int row = 0; row < boardArray.length - 3; row++){
				if (boardArray[row][col] != '□' && boardArray[row][col] == boardArray[row+1][col] && boardArray[row][col] == boardArray[row+2][col] && boardArray[row][col] == boardArray[row+3][col]){
					return true;
				}
			}
		}
		//check first diagonal 
		for (int row = 0; row < boardArray.length - 3; row++){
			for (int col = 0; col < boardArray[row].length - 3; col++){
				if (boardArray[row][col] != '□' && boardArray[row][col] == boardArray[row+1][col +1] && boardArray[row][col] == boardArray[row+2][col+2] && boardArray[row][col] == boardArray[row+3][col+3]){
					return true;
				}
			}
		}
		//check second diagonal
		for (int row = 0; row < boardArray.length - 3; row++){ 
			for (int col = 3; col < boardArray[row].length; col++){
				if (boardArray[row][col] != '□' && boardArray[row][col] == boardArray[row+1][col-1] && boardArray[row][col] == boardArray[row+2][col-2] && boardArray[row] [col] == boardArray[row+3][col-3]){
					return true;
				}
			}
		}
		return false;
		
			
	}
	
	//used for printing our board array
	public char[][] getBoard(Board b)
	{
		return boardArray;
	}
	
}
