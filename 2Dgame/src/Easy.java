import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Easy {
public static void gameEasy(int a, int b, double difficulty)
{
	Scanner userInput= new Scanner(System.in);
	char board[][] = new char[a][b];
	int count = 0;
	while (count < a*b*difficulty)
	{
		int row = (int)(Math.random()*a);
		int col = (int)(Math.random()*b);
		if (board[row][col]!='*')
		{
		board[row][col]='*';
		count++;
		}
		else if (board[row][col]=='*')
		{
			continue;
		}
	}
	for (int r = 0; r < a; r++)
	{
		for (int c = 0; c < b; c++)
		{
			board[r][c] = Check.checkSurrounding(board, r, c, '*');
		}
	}
	boolean finish = false;
	int win = 0;
	int mineNum = (int) (a*b*difficulty);
	char vision[][] = new char [a][b];
	for (int r = 0; r < a; r++)
	{
		for (int c = 0; c < b; c++)
		{
			vision[r][c] = '-';
		}
	}
	do{
		showVision(vision);
		//System.out.println("Mine or not?");
		Object pc[] = {"mine", "not"};
		int choice = JOptionPane.showOptionDialog(null, "Mine or Not","Steve's minesweeper",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null,pc, pc[1]);
		if (choice == 0)
		{
			int row = askRow();
			int col = askCol();
			vision[row][col] = 'f';
			if (board[row][col] == '*')
			{
				mineNum--;
			}
			System.out.println(mineNum+" mines left.");
			if (mineNum==0)
			{
				win =2;
                                finish = true;
			}
		}
		else if (choice == 1)
		{
			int row = askRow();
			int col = askCol();
			vision[row][col] = board[row][col];
			Check.checkZero(vision, board);
			boolean what = Check.checkMine(vision);
			if(what)
			{
				finish = true;
				win = 1;
			}
		}
	} while (!finish);
	if(finish)
	{
		if(win == 2)
		{
			System.out.println("Congratulation! You beat easy!");
		}
		else if (win == 1)
		{
			System.out.println("You lose!");
			showVision(board);
		}
	}
}
public static void showVision (char[][] vis)
{
	System.out.print("   ");
	for(int i = 1; i <= vis.length;  i++) {
		System.out.printf("%3s", i);
	}
	System.out.println();
	for (int r = 0; r < vis.length; r++)
	{
		System.out.printf("%-3s" ,(r+1));
		for (int c = 0; c < vis[0].length; c++)
		{
			System.out.printf("%3c" ,vis[r][c]);
		}
		System.out.println();
	}
}
public static int askRow()
{
	Scanner userInput= new Scanner(System.in);
	System.out.println("Which row?");
	int answer = userInput.nextInt() -1;
	return answer;
}
public static int askCol()
{
	Scanner userInput= new Scanner(System.in);
	System.out.println("Which column?");
	int answer = userInput.nextInt() -1;
	return answer;
}


}