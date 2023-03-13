package first.attempt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class genUI extends JFrame {
JFrame f = new JFrame();
JPanel jp;


public genUI() {
    f.setTitle("Simple Drawing");
    f.setSize(500, 550);
    f.setResizable(false);
    f.setDefaultCloseOperation(EXIT_ON_CLOSE);


    jp = new GPanel();
    JButton generateNew = new JButton("Generate");
    JButton Solve = new JButton("Solve");
    
    JPanel panel1 = new JPanel();
    panel1.add(generateNew);
    panel1.add(Solve);

    
    f.getContentPane().add(BorderLayout.SOUTH, panel1);
    f.getContentPane().add(BorderLayout.CENTER, jp);
    f.setVisible(true);
}

public static void main(String[] args) {
    genUI g1 = new genUI();
}

class GPanel extends JPanel {
//    public GPanel() {
//        f.setPreferredSize(new Dimension(300, 300));
//    }

    @Override
    public void paintComponent(Graphics g) {
    	
    	
    	
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
}
}