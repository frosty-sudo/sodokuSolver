package first.attempt;
import javax.swing.*;



import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		
		
		
		

//		
//		String[][] table = {
//				{".", ".", ".", ".", ".", ".", ".", ".", "."},
//				{".", ".", ".", ".", ".", ".", ".", ".", "."},
//				{".", ".", ".", ".", ".", ".", ".", ".", "."},
//				{".", ".", ".", ".", ".", ".", ".", ".", "."},
//				{".", ".", ".", ".", ".", ".", ".", ".", "."},
//				{".", ".", ".", ".", ".", ".", ".", ".", "."},
//				{".", ".", ".", ".", ".", ".", ".", ".", "."},
//				{".", ".", ".", ".", ".", ".", ".", ".", "."},
//				{".", ".", ".", ".", ".", ".", ".", ".", "."}
//				};
//		
		
		
		String[][] table = {
				{"8", ".", ".", ".", ".", ".", ".", ".", "."},
				{".", ".", "3", "6", ".", ".", ".", ".", "."},
				{".", "7", ".", ".", "0", ".", "2", ".", "."},
				{".", "5", ".", ".", ".", "7", ".", ".", "."},
				{".", ".", ".", ".", "4", "5", "7", ".", "."},
				{".", ".", ".", "1", ".", ".", ".", "3", "."},
				{".", ".", "1", ".", ".", ".", ".", "6", "8"},
				{".", ".", "8", "5", ".", ".", ".", "1", "."},
				{".", "0", ".", ".", ".", ".", "4", ".", "."}
				};
		
		
		
		
		
		Sodoku solver = new Sodoku(table);
		solver.display();
		solver.solve();
		solver.display();
		
		
		
		
		
		
		
		
		
		
		}
}

