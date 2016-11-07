import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Playgame
	{
		static JFrame frame = new JFrame();
		public static void main(String[] args)
			{
				Object diff[] = {"Easy(10% mine)", "Normal(20% mine)", "Hard(30% mine)"};
				int choice = JOptionPane.showOptionDialog(null, "Choose difficulty","Steve's minesweeper",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null,diff, diff[1]);
				double difficult = 0.1*(choice+1);
				System.out.println("Input number of row.(10-100)");
				Scanner userInput= new Scanner(System.in);
				int row = userInput.nextInt();
				System.out.println("Input number of column.(10-100)");
				int col = userInput.nextInt();
				Easy.gameEasy(Math.max(Math.min(row,100),10), Math.max(Math.min(col,100),10), difficult);


			}

	}