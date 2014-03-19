package database;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.EmptyStackException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import javax.swing.text.NumberFormatter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GUI implements DocumentListener {
	private JTextField numberField;
	private JTextField nameField;
	private JTextField addressField;
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JButton add;
	private JButton print;
	private NumberFormat format;
	private JTextArea CustOrder;
	private JScrollPane listScrollPane;
	private JTable table;
	private String custNum;
	private String custName;
	private JButton valuePack;
	private JButton familyPack;
	private JButton gourmetPack;
	
	public GUI() {
	}

	public void frame() {
		final JFrame frame = new JFrame();
		Container cp = frame.getContentPane();

		JPanel panel1 = new JPanel(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints();
		GridBagConstraints c2 = new GridBagConstraints();
		GridBagConstraints c3 = new GridBagConstraints();
		GridBagConstraints c4 = new GridBagConstraints();
		GridBagConstraints c5 = new GridBagConstraints();
		GridBagConstraints c6 = new GridBagConstraints();
		GridBagConstraints c7 = new GridBagConstraints();

		JPanel panel2 = new JPanel(new GridLayout());
		JPanel panel3 = new JPanel(new GridLayout());
		
		panel1.setBorder(new TitledBorder(new EtchedBorder(), "Customer"));
		panel2.setBorder(new TitledBorder(new EtchedBorder(), "List"));
		panel3.setBorder(new TitledBorder(new EtchedBorder(), "Packs"));
		//panel4.setBorder(new TitledBorder(new EtchedBorder(), "Customer"));

		// Arrange components using GridBagConstarints
		numberField = new JFormattedTextField(format);
		numberField.setColumns(10);
		c1.fill = GridBagConstraints.HORIZONTAL;
		c1.gridx = 1;
		c1.gridy = 0;
		c1.weightx = 0.05;
		c1.weighty = 0.05;

		nameField = new JTextField();
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.gridx = 1;
		c2.gridy = 1;
		c2.gridwidth = 1;

		addressField = new JTextField();
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.gridx = 1;
		c3.gridy = 2;
		c3.gridwidth = 1;

		l1 = new JLabel("Contact No:");
		c4.fill = GridBagConstraints.HORIZONTAL;
		c4.gridx = 0;
		c4.gridy = 0;
		c4.gridwidth = 1;

		l2 = new JLabel("Name:");
		c5.fill = GridBagConstraints.HORIZONTAL;
		c5.gridx = 0;
		c5.gridy = 1;
		c5.gridwidth = 1;

		l3 = new JLabel("Address:");
		c6.fill = GridBagConstraints.HORIZONTAL;
		c6.gridx = 0;
		c6.gridy = 2;
		c6.gridwidth = 1;

		add = new JButton("Add");
		// Add panels to container
		add.setVisible(false);
		cp.add(panel1, BorderLayout.NORTH);
		cp.add(panel2, BorderLayout.CENTER);
		cp.add(panel3, BorderLayout.SOUTH);
		
		valuePack=new JButton("Value Pack");
		familyPack=new JButton("Family Pack");
		gourmetPack=new JButton("Gourmet Pack");

		// custList=new JTextArea();

		listScrollPane = new JScrollPane(table);

		// Add components to panel
		panel1.add(l1, c4);
		panel1.add(numberField, c1);
		panel1.add(add, c7);
		panel1.add(l2, c5);
		panel1.add(nameField, c2);
		panel1.add(l3, c6);
		panel1.add(addressField, c3);
		panel2.add(listScrollPane);
		panel3.add(valuePack);
		panel3.add(familyPack);
		panel3.add(gourmetPack);
		// panel2.add(custList);
		// panel3.add(add);

		custNum = numberField.getText();

		numberField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String newline = "\n";
				String custNum = numberField.getText();
				ArrayList<String> info = null;
				ConnectDatabase cd = new ConnectDatabase();

				try {
					cd.getConnected();
					info = cd.findCustomer(custNum + newline);
					if (info.isEmpty()) {
						add.setVisible(true);
					} else {
						nameField.setText(info.get(1));
						addressField.setText(info.get(2));
					}

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(frame, e2.getMessage());
				} catch (EmptyStackException e3) {
					JOptionPane.showMessageDialog(frame, e3.getMessage());
				}
			}
		});
		numberField.getDocument().addDocumentListener(this);
		numberField.getDocument().putProperty(custNum, "Text Field");

		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String custNum = numberField.getText();
				String custName = nameField.getText();
				String custAdd = addressField.getText();
				int length = 9;
				if (!custNum.isEmpty() && !custName.isEmpty()
						&& !custAdd.isEmpty()) {
					if (custNum.length() < length) {
						JOptionPane.showMessageDialog(frame,
								"Please enter correct contact number");
					} else {
						try {
							ConnectDatabase con = new ConnectDatabase(custNum,
									custName, custAdd);
							con.getConnected();
							con.addCustomer();

						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(frame,
									e1.getMessage());
						}
					}
				} else {
					JOptionPane.showMessageDialog(frame,
							"Please enter all details!");
				}
			}
		});
		
		
		frame.setTitle("Order Form");
		frame.setSize(800,800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void insertUpdate(DocumentEvent e) {
		int len = e.getLength();
		if (len == 10) {
			updateLog(e, custName);
		}
		else{
			numberField.setToolTipText("Please enter correct number");
		}
	}

	public void removeUpdate(DocumentEvent e) {
		updateLog(e, "");
	}

	public void changedUpdate(DocumentEvent e) {
		// Plain text components don't fire these events.
	}

	public void updateLog(DocumentEvent e, String action) {
		Document doc = (Document) e.getDocument();
		nameField.setText(action);
		addressField.setText(action);
		add.setVisible(false);
	}
}
