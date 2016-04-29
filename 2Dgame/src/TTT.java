
public class TTT
	{
		static char grid[][] = new char[3][3];
		public static void setGrid()
		{
			for (int r = 0; r < 3; r++)
				{
					for (int c = 0; c < 3; c++)
						{
							grid[r][c] = '-';
						}
				}
		}
		public static void showGame()
		{
			System.out.print("   ");
			for(int i = 1; i < 4;  i++) {
				System.out.print(i+" ");
			}
			
			for (int r = 0; r < 3; r++)
				{
					for (int c = 0; c < 3; c++)
						{
							System.out.print(grid[r][c]+" ");
						}
				}
		}

		public static void main(String[] args)
			{
				// TODO Auto-generated method stub

			}

	}
