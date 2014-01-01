package database;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class GUI {
public GUI(){}
public void frame(){
	JFrame frame=new JFrame();
	Container cp=frame.getContentPane();
	cp.setLayout(new BorderLayout());
	
	JPanel panel1 = new JPanel(new BorderLayout());
	JPanel panel2 = new JPanel(new GridLayout());
	JPanel panel3 = new JPanel(new GridLayout(1, 1));
	
	panel1.setBorder(new TitledBorder(new EtchedBorder(),
			"Customer"));
	
	cp.add(panel1);
	cp.add(panel2);
	cp.add(panel3);
	
	frame.setTitle("Order Form");
	frame.setSize(700, 900);
	frame.setVisible(true);
	frame.pack();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
