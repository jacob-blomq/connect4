import java.util.Scanner;

public class play {
	public static void main(String[] args)
	{
		while(true)
		{
			int choice = 0;
			Scanner scan = new Scanner(System.in);
			System.out.println("Please pick a mode (1 = 1 player 2 = 2 player):");
			choice = scan.nextInt();
			
			if(choice == 1)
			{
				OnePlayer Oneplayer = new OnePlayer();
				Oneplayer.play();
			}
			if(choice == 2)
			{
				TwoPlayer Twoplayer = new TwoPlayer();
				Twoplayer.play();
			}
			
		}
	}		
}
