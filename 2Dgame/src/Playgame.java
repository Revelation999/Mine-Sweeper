import java.util.Scanner;
public class Playgame
	{

		public static void main(String[] args)
			{
				Scanner userInput= new Scanner(System.in);
				System.out.println("This game doesn't use hex, so please type \"10\" instead of \"A\"");
				System.out.println("What difficulties? Easy or Normal?");
				String answer = userInput.nextLine();
				if (answer.equalsIgnoreCase("easy"))
					{
						Easy.gameEasy();
					}
				else if (answer.equalsIgnoreCase("normal"))
					{
						Normal.gameNormal();
					}


			}

	}
