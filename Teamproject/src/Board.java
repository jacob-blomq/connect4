import java.util.Random; 

public class Board {
	
	char playerOne;
	char playerTwo;
	int cplayer;
	
	char[][] boardArray;
	
	public Board(char playerOne, char PlayerTwo){
		boardArray = new char[6][7];
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}
	
	public char getPlayerOne()
	{
		return playerOne;
	}
	
	public char getPlayerTwo()
	{
		return playerTwo;
	}
	
	
	//clears board and fills it with emptyPiece variable
	public char[][] clearBoard(Board b){
		char emptyP = 'O';
		boardArray = b.getBoard(b);
		return boardArray;
	}
	
	//executes turn by prompting player to place piece
	public void turn(char player, int column ){
		
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
