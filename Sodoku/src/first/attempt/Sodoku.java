package first.attempt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class Sodoku {
	
	private String[][] table;

	
	
	public Sodoku(String[][] table) {
		this.table = table;
	}
	
	
	
	
	private ArrayList<Integer[]> getQuadrants() {
		ArrayList<Integer[]> quadrants = new ArrayList<Integer[]>();
		Integer[][] quadrants2 = new Integer[9][9];
		
		
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {

				
				int counter = 0;
				Integer[] vals = new Integer[9];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (!this.table[i+3*x][j+3*y].equals(".")) {							
							vals[counter] = Integer.parseInt(this.table[i+3*x][j+3*y]);
							//quadrants2[]
						} else {
							vals[counter] = -1;
						}
						counter++;
					}
				}
				quadrants.add(vals);
			}
		}
	
		
		return quadrants;

	}
	
	
	
	private boolean isValid(int x, int y, int num) {
		
	
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				//System.out.println((i+(x/3)) + " og " + (j+(y/3)) + " \nx: " + x + " y: " + y + "\ni: " + i + " j: " + j + "\n");
				if (this.table[i+(x/3)*3][j+(y/3)*3].equals(Integer.toString(num))) {
					return false;
				}
			}
		}
		
		
		
		
		
		
		
		for (int col = 0; col < table.length; col++) {
			for (int row = 0; row < table.length; row++) {
				if (this.table[x][col].equals(Integer.toString(num))) {
					return false;
				}
				if (this.table[row][y].equals(Integer.toString(num))) {
					return false;
				}
			}
		}
		
		
		
		
		
		
		
		return true;
	}
	
	
	
	public void solve() {
		ArrayList<Integer[]> placed = new ArrayList<Integer[]>();
		int start = 0;
		boolean nonValid = false;
		
		
		
		for (int i = 0; i < this.table.length; i++) {
			for (int j = 0; j < this.table[i].length; j++) {
				if (nonValid && placed.size()!=0) {
					//System.out.println("Placed size: " + placed.size());
					//System.out.println(placed.get(placed.size()-1)[0] + " " + placed.get(placed.size()-1)[1] + " " + placed.get(placed.size()-1)[2]);
					//this.display();
					i = placed.get(placed.size()-1)[0];
					j = placed.get(placed.size()-1)[1];
					start = placed.get(placed.size()-1)[2]+1;
					placed.remove(placed.size()-1);
					this.table[i][j] = ".";
					
				}
				for (int num = start; num < 9; num++) {
					if (this.table[i][j].equals(".")) {
						
						if (isValid(i, j, num)) {
							//this.display();
							this.table[i][j] = Integer.toString(num);
							
							Integer[] vals = new Integer[3];
							vals[0] = i;
							vals[1] = j;
							vals[2] = num;
							
							placed.add(vals);
							nonValid = false;
							start = 0;
							break;
						}
						nonValid = true;
					}
				}
				
			}
		}
		//System.out.println(placed.size());
	}
	
	
	
	
	public void display() {

		System.out.println(" ------------------------------------");
		//System.out.println(" |                                   |");
		for (int i = 0; i < this.table.length; i++) {
			for (int j = 0; j < this.table.length; j++) {
				System.out.print(" | ");
				
				System.out.print(this.table[i][j]);			
			}
			System.out.println(" |");
			System.out.println(" ------------------------------------");
		}

	}
	
	
	

}
