package database;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GUI {
	private JTextField number;
	private JTextField name;
	private JTextField address;
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JButton find;
	private JButton add;
	private JButton print;
	Connection connection=null;
	PreparedStatement ps=null;

	public GUI(){}
	public void frame(){
		final JFrame frame=new JFrame();
		Container cp=frame.getContentPane();

		JPanel panel1 = new JPanel(new GridBagLayout());
		GridBagConstraints c1=new GridBagConstraints();
		GridBagConstraints c2=new GridBagConstraints();
		GridBagConstraints c3=new GridBagConstraints();
		GridBagConstraints c4=new GridBagConstraints();
		GridBagConstraints c5=new GridBagConstraints();
		GridBagConstraints c6=new GridBagConstraints();
		GridBagConstraints c7=new GridBagConstraints();

		JPanel panel2 = new JPanel(new GridLayout());
		JPanel panel3 = new JPanel(new GridLayout(1, 1));

		panel1.setBorder(new TitledBorder(new EtchedBorder(),
				"Customer"));
		panel2.setBorder(new TitledBorder(new EtchedBorder(),
				"Customer"));
		panel3.setBorder(new TitledBorder(new EtchedBorder(),
				"Customer"));

		/*NumberFormat format=NumberFormat.getInstance();
		NumberFormatter formatter=new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(9);
		formatter.setMaximum(10);*/
		number=new JTextField();
		c1.fill=GridBagConstraints.HORIZONTAL;
		c1.gridx=1;
		c1.gridy=0;
		c1.weightx=0.05;
		c1.weighty=0.05;	

		name=new JTextField();
		c2.fill=GridBagConstraints.HORIZONTAL;
		c2.gridx=1;
		c2.gridy=1;
		c2.gridwidth=1;

		address=new JTextField();
		c3.fill=GridBagConstraints.HORIZONTAL;
		c3.gridx=1;
		c3.gridy=2;
		c3.gridwidth = 1;

		l1=new JLabel("Contact No:");
		c4.fill=GridBagConstraints.HORIZONTAL;
		c4.gridx=0;
		c4.gridy=0;
		c4.gridwidth=1;

		l2=new JLabel("Name:");
		c5.fill=GridBagConstraints.HORIZONTAL;
		c5.gridx=0;
		c5.gridy=1;
		c5.gridwidth=1;

		l3=new JLabel("Address:");
		c6.fill=GridBagConstraints.HORIZONTAL;
		c6.gridx=0;
		c6.gridy=2;
		c6.gridwidth=1;

		find=new JButton("Find");
		c7.fill=GridBagConstraints.HORIZONTAL;
		c7.gridx=2;
		c7.gridy=0;
		c7.gridwidth=1;
		c7.weightx=0.01;
		
		add=new JButton("Add");

		cp.add(panel1,BorderLayout.NORTH);
		cp.add(panel2,BorderLayout.CENTER);
		cp.add(panel3,BorderLayout.SOUTH);

		panel1.add(l1,c4);
		panel1.add(number,c1);
		panel1.add(find,c7);
		panel1.add(l2,c5);
		panel1.add(name,c2);
		panel1.add(l3,c6);
		panel1.add(address,c3);
		
		panel3.add(add);
		
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				String num=number.getText();
					
					JOptionPane.showMessageDialog(frame,num);
				
				/*else{
				
					JOptionPane.showMessageDialog(null, "Not valid");
					
				}*/
			}
		});
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				String custNum=number.getText();
				String custName=name.getText();
				String custAdd=address.getText();
				
				Customer cs=new Customer();
				cs.setContactNo(custNum);
				cs.setName(custName);
				cs.setAddress(custAdd);
				
				
				
				ConnectDatabase con=new ConnectDatabase(custNum,custName,custAdd);
				con.getConnected();
				
				
				/*Customer cust=new Customer(custNum,custName,custAdd);
				String n=cust.getName();
				JOptionPane.showMessageDialog(frame,n);*/
			}
		});
		
		frame.setTitle("Order Form");
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
public void addCustomer(Connection connection,PreparedStatement ps,String contactNo,String name,String address) throws SQLException{
        ps=connection.prepareStatement("INSERT INTO Customer(Contact_No, Name, Address) VALUES (?,?,?)");
        ps.setString(1,contactNo);
        ps.setString(2,name);
        ps.setString(3,address);    
        ps.executeUpdate();
	}
}
