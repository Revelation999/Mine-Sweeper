
public class Check
	{
		public static char checkSurrounding(char[][] board, int r, int c, char target)
		{
			if (board[r][c] != target)
				{
				int num = 0;
				if (r !=0 && c!=0)
				{
				if (board[r-1][c-1] == target)
				{
					num++;
				}
				}
				if (r!=0)
				{
				if (board[r-1][c] == target)
				{
					num++;
				}
				}
				if (r!=0 && c!= board[0].length-1)
				{
				if (board[r-1][c+1] == target)
				{
					num++;
				}
				}
				if (c!=0)
				{
				if (board[r][c-1] == target)
				{
					num++;
				}
				}
				if (c!=board[0].length-1)
				{
				if (board[r][c+1] == target)
				{
					num++;
				}
				}
				if (r!=board.length-1 && c!=0)
				{
				if (board[r+1][c-1]==target)
				{
					num++;
				}
				}
				if (r!=board.length-1)
				{
				if (board[r+1][c]==target)
				{
					num++;
				}
				}
				if (r!=board.length-1 && c!=board[0].length-1)
				{
				if (board[r+1][c+1]==target)
				{
					num++;
				}
				}
				return (char)(num+48);
				}
			return target;
		}
		public static boolean checkMine(char[][] board)
		{
			for (int r = 0; r < board.length; r++)
				{
					for (int c = 0; c < board[0].length; c++)
						{
							if (board[r][c]=='*')return true;
						}
				}
			return false;
		}
		public static void checkZero(char[][] vis, char[][] boa)
			{
				int check = 10000000;
				do{
					for (int r = 0; r < vis.length; r++)
					{
						for (int c = 0; c < vis[0].length; c++)
						{
							if (vis[r][c]== '0')
							{
								if(r>0&&c>0){vis[r-1][c-1]=boa[r-1][c-1];}if(r>0)vis[r-1][c]=boa[r-1][c];if(r>0&&c<vis[0].length-1){vis[r-1][c+1]=boa[r-1][c+1];}if(c>0){vis[r][c-1]=boa[r][c-1];}
								if(c<vis[0].length-1){vis[r][c+1]=boa[r][c+1];}if(r<vis.length-1&&c>0){vis[r+1][c-1]=boa[r+1][c-1];}if(r<vis.length-1){vis[r+1][c]=boa[r+1][c];}if(r<vis.length-1&&c<vis[0].length-1){vis[r+1][c+1]=boa[r+1][c+1];}
							}
							else if (vis[r][c]!='0')
							{
								check--;
							}
							
						}
					}
				}while (check > 0);
			}
	}
