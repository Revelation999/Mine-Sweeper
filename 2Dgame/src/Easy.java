import java.util.Scanner;
//123455678

public class Easy {
	static Scanner userInput= new Scanner(System.in);
public static void gameEasy()
{
	char board[][] = new char[10][10];
	int count = 0;
	while (count < 10)
	{
		int row = (int)(Math.random()*10);
		int col = (int)(Math.random()*10);
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
	for (int r = 0; r < 10; r++)
	{
		for (int c = 0; c < 10; c++)
		{
			if (board[r][c] != '*')
			{
			int num = 0;
			if (r !=0 && c!=0)
			{
			if (board[r-1][c-1] == '*')
			{
				num++;
			}
			}
			if (r!=0)
			{
			if (board[r-1][c] == '*')
			{
				num++;
			}
			}
			if (r!=0 && c!= 9)
			{
			if (board[r-1][c+1] == '*')
			{
				num++;
			}
			}
			if (c!=0)
			{
			if (board[r][c-1] == '*')
			{
				num++;
			}
			}
			if (c!=9)
			{
			if (board[r][c+1] == '*')
			{
				num++;
			}
			}
			if (r!=9 && c!=0)
			{
			if (board[r+1][c-1]=='*')
			{
				num++;
			}
			}
			if (r!=9)
			{
			if (board[r+1][c]=='*')
			{
				num++;
			}
			}
			if (r!=9 && c!=9)
			{
			if (board[r+1][c+1]=='*')
			{
				num++;
			}
			}
			board[r][c] = (char) (num+48);
			}
		}
	}
	boolean finish = false;
	int win = 0;
	int mineNum = 10;
	char vision[][] = new char [10][10];
	for (int r = 0; r < 10; r++)
	{
		for (int c = 0; c < 10; c++)
		{
			vision[r][c] = '-';
		}
	}
	do{
		showVision(vision);
		System.out.println("Mine or not?");
		Scanner userInput2= new Scanner(System.in);
		String answer = userInput2.nextLine();
		//boolean mine = userInput.nextLine().equalsIgnoreCase("mine");
		if (answer.equalsIgnoreCase("mine"))
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
		else if (answer.equalsIgnoreCase("not"))
		{
			int row = askRow();
			int col = askCol();
			if(board [row][col] =='*')
			{
				finish = true;
				win = 1;
			}
			else
			{
				vision[row][col] = board[row][col];
				checkZero(vision, board);
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
	for(int i = 1; i < 10;  i++) {
		System.out.print(i+" ");
	}
	System.out.println("A");
	
	for (int r = 0; r < 10; r++)
	{
		if(r != 9)
		System.out.print((r+1)+"  ");
		else
			System.out.print("A  ");
		for (int c = 0; c < 10; c++)
		{
			System.out.print(vis[r][c]+" ");
		}
		System.out.println();
	}
}
public static int askRow()
{
	System.out.println("Which row?");
	int answer = userInput.nextInt() -1;
	return answer;
}
public static int askCol()
{
	System.out.println("Which column?");
	int answer = userInput.nextInt() -1;
	return answer;
}
public static void checkZero(char[][] vis, char[][] boa)
{
	int check = 100;
	do{
		for (int r = 0; r < 10; r++)
		{
			for (int c = 0; c < 10; c++)
			{
				if (vis[r][c]== '0')
				{
					if(r>0&&c>0){vis[r-1][c-1]=boa[r-1][c-1];}if(r>0)vis[r-1][c]=boa[r-1][c];if(r>0&&c<9){vis[r-1][c+1]=boa[r-1][c+1];}if(c>0){vis[r][c-1]=boa[r][c-1];}
					if(c<9){vis[r][c+1]=boa[r][c+1];}if(r<9&&c>0){vis[r+1][c-1]=boa[r+1][c-1];}if(r<9){vis[r+1][c]=boa[r+1][c];}if(r<9&&c<9){vis[r+1][c+1]=boa[r+1][c+1];}
					//check--;
				}
				else if (vis[r][c]!='0')
				{
					check--;
				}
				
			}
		}
	}while (check > 0);
}
public static void main(String[] args){
	gameEasy();
}
}