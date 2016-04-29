import java.util.Scanner;
public class Normal {
	static Scanner userInput= new Scanner(System.in);
public static void gameNormal()
{
	char board[][] = new char[15][15];
	int count = 0;
	while (count < 30)
	{
		int row = (int)(Math.random()*15);
		int col = (int)(Math.random()*15);
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
	for (int r = 0; r < 15; r++)
	{
		for (int c = 0; c < 15; c++)
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
			if (r!=0 && c!= 14)
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
			if (c!=14)
			{
			if (board[r][c+1] == '*')
			{
				num++;
			}
			}
			if (r!=14 && c!=0)
			{
			if (board[r+1][c-1]=='*')
			{
				num++;
			}
			}
			if (r!=14)
			{
			if (board[r+1][c]=='*')
			{
				num++;
			}
			}
			if (r!=14 && c!=14)
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
	int mineNum = 30;
	char vision[][] = new char [15][15];
	for (int r = 0; r < 15; r++)
	{
		for (int c = 0; c < 15; c++)
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
			System.out.println("Congratulation! You beat normal!");
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
	for(int i = 1; i < 10; i++) {
		System.out.print(i+" ");
	}
	for(char i = 'A'; i < 'G'; i++) {
		System.out.print(i+" ");
	}
	System.out.println();
	for (int r = 0; r < 15; r++)
	{
		int potato = r+1;
		if(potato < 10) {
		System.out.print(potato+"  ");
		}
		else {
			switch(potato) {
			case 10:
				System.out.print('A'+"  ");
				break;
			case 11:
				System.out.print('B'+"  ");
				break;
			case 12:
				System.out.print('C'+"  ");
				break;
			case 13:
				System.out.print('D'+"  ");
				break;
			case 14:
				System.out.print('E'+"  ");
				break;
			case 15:
				System.out.print('F'+"  ");
				break;
				
			}
		}
		for (int c = 0; c < 15; c++)
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
	int check = 225;
	do{
		for (int r = 0; r < 15; r++)
		{
			for (int c = 0; c < 15; c++)
			{
				if (vis[r][c]== '0')
				{
					if(r>0&&c>0){vis[r-1][c-1]=boa[r-1][c-1];}if(r>0)vis[r-1][c]=boa[r-1][c];if(r>0&&c<14){vis[r-1][c+1]=boa[r-1][c+1];}if(c>0){vis[r][c-1]=boa[r][c-1];}
					if(c<14){vis[r][c+1]=boa[r][c+1];}if(r<14&&c>0){vis[r+1][c-1]=boa[r+1][c-1];}if(r<14){vis[r+1][c]=boa[r+1][c];}if(r<14&&c<14){vis[r+1][c+1]=boa[r+1][c+1];}
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
	gameNormal();
}
}