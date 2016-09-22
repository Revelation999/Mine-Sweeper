import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;
//123455678
public class DungeonGame
	{
		static Scanner userInput = new Scanner(System.in);
		static int health = 1000;
		static int attack = 10;
		static int defense = 10;
		static int keyNumber = 0;
		static int skeletonHealth = 100;
		static int slimeHealth = 50;
		static int skeletonAttack = 15;
		static int slimeAttack = 12;
		static int skeletonDefense = 5;
		static int slimeDefense = 3;
		static boolean potion1 = true;
		static boolean ruby = true;
		static boolean emerald = true;
		static boolean key1 = true;
		static boolean key2 = true;
		static boolean key3 = true;
		static boolean potion2 = true;
		static boolean sword = true;
		static boolean shield = true;
		static int level = 1;
		static boolean conversation = true;
		static int witchHealth = 200;
		static int witchAttack = 8;
		static int witchDefense = 5;
		static int knightHealth = 250;
		static int knightAttack = 16;
		static int knightDefense = 17;
		static int giantHealth = 1100;
		static int giantAttack = 30;
		static int giantDefense = 15;
		
		public static void main(String[] args)
		{
		String[][] DGArray = new String [12][12];
		for(int row = 0; row <12; row++)
			{
			
			for(int col = 0; col < 12; col++)
				{
				
				if(row == 0|| row == 11 || col == 0 || col == 11)
					{
					DGArray[row][col] = "wall ";
					}
				
				else
					{
					DGArray[row][col] = "     ";
					}
				}
			}
		
		DGArray[2][2] = DGArray[3][2] = DGArray[4][2] = DGArray[5][2] = DGArray[6][2] = DGArray[7][2] = DGArray[2][3] = DGArray[3][3] = DGArray[4][3] = DGArray[5][3] = DGArray[6][3] = DGArray[7][3] = DGArray[8][3] = DGArray[9][3] = DGArray[10][3] = DGArray[8][4] = DGArray[1][5] = DGArray[2][5] = DGArray[3][5] = DGArray[4][5] = DGArray[5][5] = DGArray[6][5] = DGArray[6][6] = DGArray[8][6] = DGArray[6][7] = DGArray[8][7] = DGArray[9][7] = DGArray[10][7] = DGArray[6][8] = DGArray[8][8] = DGArray[1][9] = DGArray[2][9] = DGArray[3][9] = DGArray[4][9] = DGArray[5][9] = DGArray[6][9] = DGArray[8][9] = "wall ";
		DGArray[7][1] = "door ";
		DGArray[8][2] = "key  ";
		DGArray[8][5] = "slime";
		DGArray[9][6] = "ruby ";
		DGArray[9][8] = "emer ";
		DGArray[9][9] = "potio";
		DGArray[8][10] = "skele";
		DGArray[1][10] = "stair";
		int charRow = 10;
		int charCol = 1;
		DGArray[charRow][charCol] = "char ";
		
		String[][] levelTwo = new String [10][12];
		for(int row = 0; row < 10; row++)
			{
			
			for(int col = 0; col < 12; col++)
				{
				
				if(row == 0|| row == 9 || col == 0 || col == 11)
					{
					levelTwo[row][col] = "wall ";
					}
				
				else
					{
					levelTwo[row][col] = "     ";
					}
				}
			}
		
		levelTwo[5][1] = levelTwo[5][3] = levelTwo[7][2] = levelTwo[8][2] = levelTwo[7][3] = levelTwo[8][3] = levelTwo[1][4] = levelTwo[3][4] = levelTwo[4][4] = levelTwo[5][4] = levelTwo[7][4] = levelTwo[6][4] = levelTwo[8][4] = levelTwo[3][5] = levelTwo[5][5] = levelTwo[1][6] = levelTwo[3][6] = levelTwo[5][6] = levelTwo[6][6] = levelTwo[8][6] = levelTwo[1][7] = levelTwo[1][8] = levelTwo[2][8] = levelTwo[3][8] = levelTwo[4][8] = levelTwo[5][8] = levelTwo[1][9] = levelTwo[2][9] = levelTwo[4][9] = levelTwo[5][9] = levelTwo[6][9] = levelTwo[7][9] = "wall ";
		levelTwo[8][1] = "port ";
		levelTwo[5][2] = "giant";
		levelTwo[2][4] = levelTwo[7][10] = "door ";
		levelTwo[1][5] = levelTwo[3][9] = "key  ";
		levelTwo[4][5] = "shiel";
		levelTwo[4][6] = "knite";
		levelTwo[6][5] = "potio";
		levelTwo[7][5] = "sword";
		levelTwo[7][6] = "witch";
		int charRow2 = 1;
		int charCol2 = 10;
		levelTwo[charRow2][charCol2] = "char ";
		
        while (health > 0 && level == 1)
        	{
		for(int row = 0; row <12; row++)
			{
			for(int col = 0; col < 12; col++)
				{
				System.out.print(DGArray[row][col] + " ");	
				}
			System.out.println();
			}
		System.out.println("Type W for up, A for left, D for right & S for down.");
		String input = userInput.nextLine();
	
		if(input.equals("w")) 
			{
			if(DGArray[8][1] == "char ")
				{
				if(keyNumber == 1)
					{
					System.out.println("Use the key to open the door");
					keyNumber--;
					DGArray[7][1] = "     ";
					}
				}
			if (DGArray[charRow-1][charCol] == "wall " ||(DGArray[charRow-1][charCol]== "door " && keyNumber == 0))
				{
				System.out.println("Don't hit the wall!");
				}
			else 
				{
				DGArray [charRow][charCol] = "     ";
				charRow--;
				DGArray [charRow][charCol] = "char ";
				}
			}
		else if(input.equals("a"))
			{
			if (DGArray[charRow][charCol-1] == "wall ")
				{
				System.out.println("Don't hit the wall!");
				}
			else
				{
				DGArray [charRow][charCol] = "     ";
				charCol--;
				DGArray [charRow][charCol] = "char ";
				}
			}
		else if(input.equals("s"))
			{
			if (DGArray[charRow+1][charCol] == "wall ")
				{
				System.out.println("Don't hit the wall!");
				}
			else
				{
				DGArray [charRow][charCol] = "     ";
				charRow++;
				DGArray [charRow][charCol] = "char ";
				}
			}
		else if(input.equals("d"))
			{
			if (DGArray[charRow][charCol+1] == "wall ")
				{
				System.out.println("Don't hit the wall!");
				}	
			else
				{
				DGArray [charRow][charCol] = "     ";	
				charCol++;
				DGArray [charRow][charCol] = "char ";
				}
			}
		System.out.println("health: " + health);
		System.out.println("attack: " + attack);
		System.out.println("defense: " + defense);
		
		if(DGArray[8][2] == "char " && key1)
			{
			System.out.println("You got the Key!");
			keyNumber++;
			key1 = false;
			}
		
		if(DGArray[9][6] == "char " && ruby)
			{
			System.out.println("You picked up the ruby, your attack increased by 2!");
			attack = attack + 2;
			ruby = false;
			}
		
		if(DGArray[9][8] == "char " && emerald)
			{
			System.out.println("You picked up the emerald, your defense increased by 2!");
			defense = defense + 2;
			emerald = false;
			}
		
		if(DGArray[9][9] == "char " && potion1)
			{
			System.out.println("You picked up the potion, your health increased by 400!");
			health = health + 400;
			potion1 = false;
			}
		
		if(DGArray[8][5] == "char ")
			{
			health = slimeBattle(health, attack, defense);
			if (health > 0)
				{
				System.out.println("You defeated the Slime!");
				}
			else if(health <= 0)
				{
				System.out.println("You lose.");
				break;
				}
			}
		
		if(DGArray[8][10] == "char ")
			{
			health = skeletonBattle(health, attack, defense);
			if (health > 0)
				{
				System.out.println("You defeated the Skeleton!");
				}
			else if(health <= 0)
				{
				System.out.println("You lose.");
				break;
				}
			}
		
		if(DGArray[1][10] == "char ")
			{
			level = 2;
			}
		
		}
        
        while (health > 0 && level == 2)
        	{
		for(int row = 0; row < 10; row++)
			{
			for(int col = 0; col < 12; col++)
				{
				System.out.print(levelTwo[row][col] + " ");	
				}
			System.out.println();
			}
		System.out.println("Type W for up, A for left, D for right & S for down.");
		String input = userInput.nextLine();
	
		if(input.equals("w")) 
			{ 
			if (levelTwo[charRow2-1][charCol2] == "wall ")
				{
				System.out.println("Don't hit the wall!");
				}
			else	
				{
				levelTwo [charRow2][charCol2] = "     ";
				charRow2--;
				levelTwo [charRow2][charCol2] = "char ";
				}
			}
		else if(input.equals("a"))
			{
				if(levelTwo[2][5] == "char ")
					{
					if(keyNumber >= 1)
						{
						System.out.println("Use the key to open the door");
						levelTwo[2][4] = "     ";
						keyNumber--;
						}
					}
				
			if (levelTwo[charRow2][charCol2-1] == "wall " ||(levelTwo[charRow2][charCol2-1]== "door " && keyNumber == 0))
				{
				System.out.println("Don't hit the wall!");
				}
			else
				{
				levelTwo [charRow2][charCol2] = "     ";
				charCol2--;
				levelTwo [charRow2][charCol2] = "char ";
				}
			}
		else if(input.equals("s"))
			{
			if(levelTwo[6][10] == "char ")
				{
				if(keyNumber >= 1)
					{
					System.out.println("Use the key to open the door");
					levelTwo[7][10] = "     ";
					keyNumber--;
					}
				}
				
			if (levelTwo[charRow2+1][charCol2] == "wall " ||(levelTwo[charRow2+1][charCol2]== "door " && keyNumber == 0))
				{
				System.out.println("Don't hit the wall!");
				}
			else
				{
				levelTwo [charRow2][charCol2] = "     ";
				charRow2++;
				levelTwo [charRow2][charCol2] = "char ";
				}
			}
		else if(input.equals("d"))
			{
			if (levelTwo[charRow2][charCol2+1] == "wall ")
				{
				System.out.println("Don't hit the wall!");
				}	
			else
				{
				levelTwo [charRow2][charCol2] = "     ";	
				charCol2++;
				levelTwo [charRow2][charCol2] = "char ";
				}
			}
		System.out.println("health: " + health);
		System.out.println("attack: " + attack);
		System.out.println("defense: " + defense);
		
		if(levelTwo[3][9] == "char " && key2)
			{
			System.out.println("You got the Key!");
			keyNumber++;
			key2 = false;
			}
		
		if(levelTwo[1][5] == "char " && key3)
			{
			System.out.println("You got the Key!");
			keyNumber++;
			key3 = false;
			}
		
		if(levelTwo[7][5] == "char " && sword)
			{
			System.out.println("You picked up the sword, your attack increased by 10!");
			attack = attack + 10;
			sword = false;
			}
		
		if(levelTwo[4][5] == "char " && shield)
			{
			System.out.println("You picked up the shield, your defense increased by 10!");
			defense = defense + 10;
			shield = false;
			}
		
		if(levelTwo[6][5] == "char " && potion2)
			{
			System.out.println("You picked up the potion, your health increased by 400!");
			health = health + 400;
			potion2 = false;
			}
		
		if(levelTwo[2][3] == "char " && conversation)
			{
			System.out.println("Giant: \"I'm surprised you've made it this far. You must be very skilled.\"");
			System.out.println("Player: \"I try my best.\"");
			System.out.println("Giant: \"Your abilities, however, do not match my ferocity.\"");
			System.out.println("Player: \"We'll just have to see, won't we?\"");
			conversation = false;
			levelTwo[2][4] = "wall ";
			}
		
		if(levelTwo[7][6] == "char ")
			{
			health = witchBattle(health, attack, defense);
			if (health > 0)
				{
				System.out.println("You defeated the Witch!");
				}
			else if(health <= 0)
				{
				System.out.println("You lose.");
				break;
				}
			}
		
		if(levelTwo[4][6] == "char ")
			{
			health = knightBattle(health, attack, defense);
			if (health > 0)
				{
				System.out.println("You defeated the Knight!");
				}
			else if(health <= 0)
				{
				System.out.println("You lose.");
				break;
				}
			}
		
		if(levelTwo[5][2] == "char ")
			{
			health = giantBattle(health, attack, defense);
			if (health > 0)
				{
				System.out.println("You defeated the Giant! Go to the portal!");
				}
			else if(health <= 0)
				{
				System.out.println("You lose.");
				break;
				}
			}
		
		if(levelTwo[8][1] == "char ")
			{
			System.out.println("Congradulations, you have been teleported to the promised land, you win. Enjoy!");
			break;
			}
		
		}
        
		}
		
		public static int witchBattle(int health, int attack, int defense)
		{
		int win = 0;
		while(health > 0 && witchHealth > 0)
			{
			health = health - witchAttack;
			witchHealth = witchHealth - (attack - witchDefense);
			}
		if(health <= 0)
			{
			win = 1; 
			}
		else if(witchHealth <= 0)
			{
			win = 2;
			}
		return health;
		}
		
		public static int knightBattle(int health, int attack, int defense)
			{
			int win = 0;
			while(health > 0 && knightHealth > 0)
				{
				health = health - (knightAttack - defense);
				knightHealth = knightHealth - (attack - knightDefense);
				}
			if(health <= 0)
				{
				win = 1; 
				}
			else if(knightHealth <= 0)
				{
				win = 2;
				}
			return health;
			}
		
		public static int slimeBattle(int health, int attack, int defense)
			{
			int win = 0;
			while(health > 0 && slimeHealth > 0)
				{
				health = health - (slimeAttack - defense);
				slimeHealth = slimeHealth - (attack - slimeDefense);
				}
			if(health <= 0)
				{
				win = 1; 
				}
			else if(slimeHealth <= 0)
				{
				win = 2;
				}
			return health;
			}
		
		public static int skeletonBattle(int health, int attack, int defense)
			{
			int win = 0;
			while(health > 0 && skeletonHealth > 0)
				{
				health = health - (skeletonAttack - defense);
				skeletonHealth = skeletonHealth - (attack - skeletonDefense);
				}
			if(health <= 0)
				{
				win = 1; 
				}
			else if(skeletonHealth <= 0)
				{
				win = 2;
				}
			return health;
			}
		
		public static int giantBattle(int health, int attack, int defense)
			{
			int win = 0;
			while(health > 0 && giantHealth > 0)
				{
				health = health - (giantAttack - defense);
				giantHealth = giantHealth - (attack - giantDefense);
				}
			if(health <= 0)
				{
				win = 1; 
				}
			else if(giantHealth <= 0)
				{
				win = 2;
				}
			return health;
			}
		
		
		
		
	}
