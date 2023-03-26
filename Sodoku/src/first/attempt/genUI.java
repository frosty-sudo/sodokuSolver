package first.attempt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class genUI extends JFrame {
	JFrame f = new JFrame();
	JPanel jp;
	JTextField t;
	JTextField text;
	
	
	



	public String[][] soTable = {
			{".", ".", ".", ".", ".", ".", ".", ".", "."}, 
			{".", ".", ".", ".", ".", ".", ".", ".", "."}, 
			{".", ".", ".", ".", ".", ".", ".", ".", "."}, 
			{".", ".", ".", ".", ".", ".", ".", ".", "."}, 
			{".", ".", ".", ".", ".", ".", ".", ".", "."}, 
			{".", ".", ".", ".", ".", ".", ".", ".", "."}, 
			{".", ".", ".", ".", ".", ".", ".", ".", "."}, 
			{".", ".", ".", ".", ".", ".", ".", ".", "."}, 
			{".", ".", ".", ".", ".", ".", ".", ".", "."}
	};

	String[][] clean ={
			{".", ".", ".", ".", ".", ".", ".", ".", "."}, 
			{".", ".", ".", ".", ".", ".", ".", ".", "."}, 
			{".", ".", ".", ".", ".", ".", ".", ".", "."}, 
			{".", ".", ".", ".", ".", ".", ".", ".", "."}, 
			{".", ".", ".", ".", ".", ".", ".", ".", "."}, 
			{".", ".", ".", ".", ".", ".", ".", ".", "."}, 
			{".", ".", ".", ".", ".", ".", ".", ".", "."}, 
			{".", ".", ".", ".", ".", ".", ".", ".", "."}, 
			{".", ".", ".", ".", ".", ".", ".", ".", "."}
	};


	
	public void clear() {

		
		for(int i = 0; i < soTable.length; i++) {
			for(int i1 = 0; i1 < soTable.length; i1++) {
				soTable[i][i1] = ".";
			}
		}
		
		for (int i = 0; i < 9; i++) {
			for (int i1 = 0; i1 < 9; i1++) {
				jp.getGraphics().clearRect(i*50+20, i1*50+20, 40, 40);
			}
		}
	}
	
	
	public genUI() {
		f.setLocation(1920 / 2 - 250, 200);
		f.setTitle("Sodoku Solver");
		f.setSize(500, 550);
		f.setResizable(false);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);





		jp = new GPanel();

		JButton clear = new JButton("Clear");

		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clear();
			}
		});

		JButton solve = new JButton("Solve");

		solve.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Graphics g = jp.getGraphics();
				Sodoku solve = new Sodoku(soTable);

//				solve.display();
				solve.solve();
//				solve.display();
				
				String[][] solvedTable = solve.finnishedTable();

				clear();
				
				
				
				Font currentFont = g.getFont();
				Font newFont = currentFont.deriveFont(25f);
				g.setFont(newFont);
				
				for (int y = 0; y < soTable.length; y++) {
					for (int x = 0; x < soTable.length; x++) {
						g.drawString(solvedTable[y][x], (x)*50+36, (y)*50+48);
					}
				}

				
				
				
			}
		});




		JPanel panel1 = new JPanel();
		panel1.add(clear);
		panel1.add(solve);


		//		text.setEditable(false);
		//		text.setPreferredSize(new Dimension(200, 200));
		//		text.setSize(2, 2);






		f.getContentPane().add(BorderLayout.SOUTH, panel1);
		f.getContentPane().add(jp);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		genUI g1 = new genUI();
	}

	class GPanel extends JPanel implements MouseWheelListener, MouseListener, MouseMotionListener {
		//    public GPanel() {
		//        f.setPreferredSize(new Dimension(300, 300));
		//    }
		
		
		

		@Override
		public void paintComponent(Graphics g) {


			addMouseMotionListener(this);
			addMouseListener(this);
			addMouseWheelListener(this);
			
			
			Dimension size = this.getSize();

			int d = 450;
			int x = (size.width - d) / 2;
			int y = (size.height - d) / 2;




			g.drawRect(x, y, d, d);

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					g.drawRect(x, y, 50*i, 50*j);

				}
			}





		}





		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			// TODO Auto-generated method stub
			Dimension size = jp.getSize();



			int d = 450;
			int x = e.getX()-((size.width - d) / 2);
			int y = e.getY()-((size.height - d) / 2);

			Graphics g = jp.getGraphics();
			Font currentFont = g.getFont();
			Font newFont = currentFont.deriveFont(25f);
			g.setFont(newFont);

//			if (e.isControlDown())
//			{
				if (x == Math.abs(x) && y == Math.abs(y) && !(x >= 450 || y >= 450))  {





					if (e.getUnitsToScroll() == Math.abs(e.getUnitsToScroll())) {
						if (soTable[y/50][x/50].equals(".") || soTable[y/50][x/50].equals("0")) {
							soTable[y/50][x/50] = "8"; 
						} else {
							soTable[y/50][x/50] = Integer.toString(Integer.parseInt(soTable[y/50][x/50])-1);
						}



					} else {
						if (soTable[y/50][x/50].equals(".") || soTable[y/50][x/50].equals("8")) {
							soTable[y/50][x/50] = "0";
						} else {
							soTable[y/50][x/50] = Integer.toString(Integer.parseInt(soTable[y/50][x/50])+1);
						}



					}
					g.clearRect((x/50)*50+20, (y/50)*50+20, 40, 40);
					g.drawString(soTable[y/50][x/50], (x/50)*50+36, (y/50)*50+48);




				}
//			}
			else
			{
				getParent().dispatchEvent(e);
			}

		}





		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Graphics g = jp.getGraphics();
			
			
			
			
			
			
			
			
		}





		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			Graphics g = jp.getGraphics();


		}





		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}





		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}





		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}





		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub

			Dimension size = jp.getSize();



			int d = 450;
			int x = e.getX()-((size.width - d) / 2);
			int y = e.getY()-((size.height - d) / 2);
			
			Graphics g = jp.getGraphics();
			if (x == Math.abs(x) && y == Math.abs(y) && !(x >= 450 || y >= 450))  {

				g.clearRect((x/50)*50+20, (y/50)*50+20, 40, 40);
				soTable[y/50][x/50] = ".";
			}
		}





		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}





	}




}

