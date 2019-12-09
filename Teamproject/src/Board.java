import java.util.Random; 

public class Board {
	
	char playerOne;
	char playerTwo;
	int startingPlayer;
	
	int[] colCount;
	
	char[][] boardArray;
	
	public Board(char playerOne, char playerTwo){
		boardArray = new char[6][7];
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		colCount = new int[7];
		startingPlayer = 0;
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
	
	public String printBoard(char[][] boardArray)
	{
		String boardString = "";
		System.out.println(" ");
		for(int i = 0; i < boardArray.length; i++)
		{
			for(int j = 0; j < boardArray[i].length; j++)
			{
				if(j == 6)
				{
					boardString+= "|" + boardArray[i][j] + "|" + "\n";
				}
				else
				{
					boardString+= "|" + boardArray[i][j] + "|";
				}
			}
		}
		boardString+= " 1  2  3  4  5  6  7";
		return boardString;
	}
	
	//executes turn by prompting player to place piece
	public boolean turn(int player, int column, Board b){
		column--;
		if(player == 1) 
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
	
	public int getStartingPlayer() { return(startingPlayer); }
	
	public void decideturn() {
		Random rand = new Random();
		startingPlayer = rand.nextInt(2) + 1;
	}
	
	
	public boolean checkWin(int cp) {
		char current = 0;
		
		if(cp == 1)
		{
			current = getPlayerOne();
		}
		if(cp == 2)
		{
			current = getPlayerTwo();
		}
		//check horizontal 
		for (int row = 0; row < boardArray.length; row++){
			for (int col = 0; col < boardArray[row].length - 3; col++){
				if (boardArray[row][col] == current && boardArray[row][col] == boardArray[row][col+1] && boardArray[row][col] == boardArray[row][col+2] && boardArray[row][col] == boardArray[row][col +3]){
					return true;
				}
			}
		}
		//check vertical
		for (int col = 0; col < boardArray[0].length; col++){
			for (int row = 0; row < boardArray.length - 3; row++){
				if (boardArray[row][col] == current && boardArray[row][col] == boardArray[row+1][col] && boardArray[row][col] == boardArray[row+2][col] && boardArray[row][col] == boardArray[row+3][col]){
					return true;
				}
			}
		}
		//check first diagonal 
		for (int row = 0; row < boardArray.length - 3; row++){
			for (int col = 0; col < boardArray[row].length - 3; col++){
				if (boardArray[row][col] == current && boardArray[row][col] == boardArray[row+1][col +1] && boardArray[row][col] == boardArray[row+2][col+2] && boardArray[row][col] == boardArray[row+3][col+3]){
					return true;
				}
			}
		}
		//check second diagonal
		for (int row = 0; row < boardArray.length - 3; row++){ 
			for (int col = 3; col < boardArray[row].length; col++){
				if (boardArray[row][col] == current && boardArray[row][col] == boardArray[row+1][col-1] && boardArray[row][col] == boardArray[row+2][col-2] && boardArray[row] [col] == boardArray[row+3][col-3]){
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
