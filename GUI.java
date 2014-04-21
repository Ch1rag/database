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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import javax.swing.text.NumberFormatter;

import org.omg.CORBA.Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GUI implements DocumentListener {
	private JTextField numberField;
	private JTextField nameField;
	private JTextField addressField;
	private JTextField subtotalField;
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JButton add;
	private JButton print;
	private NumberFormat format;
	private JTextArea order;
	private JScrollPane listScrollPane;
	private JTable table;
	private String custNum;
	private String custName;
	private JButton valuePack;
	private JButton familyPack;
	private JButton gourmetPack;
	private JButton bChk;
	private JButton cCurry;
	private JButton bVindaloo;
	private JButton lCurry;
	private JButton daal;
	private JButton vKorma;
	private JButton oBhaji;
	private JButton pakora;
	private JButton samosa;
	private JButton dum;
	private JButton mutterPan;
	private JButton palakPan;
	private JButton malaiKofta;
	private JButton Baigan;
	private JButton mashroom;
	private JButton navKorma;
	private JButton alooPalak;
	private JButton alooMutter;
	private JButton pumpkin;
	private JButton dMasala;
	private JButton dMaha;
	private JButton traditional;
	private JButton vindaloo;
	private JButton korma;
	private JButton saag;
	private JComboBox curriesCombobox;
	private JComboBox regionalCombobox;
	private DefaultTableModel model;
	private ConnectDatabase cd = new ConnectDatabase();
	private String col[] = { "Name", "Price" };
	private double subTotal;
	private int row = 0;
	private int orderNo=0;
	private JButton x;
	private JButton z;
	private JButton sRice;
	private JButton wRice;
	private JButton lambBiryani;
	private JButton chkBiryani;
	private JButton peaPulao;
	private JButton naan;
	private JButton roti;
	private JButton keemaNaan;
	private JButton kashNaan;
	private JButton alooParatha;
	private JButton paratha;
	private JButton rotiChennai;
	private JButton masalaKulcha;
	private double price=0.00;
	private String name=null;
	private JButton balance;
	

	// private double price=0.0;

	public GUI() {
	}

	public void frame() {
		final JFrame frame = new JFrame();
		Container cp = frame.getContentPane();
		JPanel containPanels = new JPanel(new GridBagLayout());

		GridBagConstraints c1 = new GridBagConstraints();
		GridBagConstraints c2 = new GridBagConstraints();
		GridBagConstraints c3 = new GridBagConstraints();
		GridBagConstraints c4 = new GridBagConstraints();
		GridBagConstraints c5 = new GridBagConstraints();
		GridBagConstraints c6 = new GridBagConstraints();
		GridBagConstraints c7 = new GridBagConstraints();
		GridBagConstraints c8 = new GridBagConstraints();
		GridBagConstraints c9 = new GridBagConstraints();
		GridBagConstraints c10 = new GridBagConstraints();
		// GridBagConstraints c11 = new GridBagConstraints();
		// GridBagConstraints c12 = new GridBagConstraints();
		// GridBagConstraints c13 = new GridBagConstraints();
		GridBagConstraints c14 = new GridBagConstraints();
		GridBagConstraints c15 = new GridBagConstraints();
		GridBagConstraints c16 = new GridBagConstraints();
		GridBagConstraints c17 = new GridBagConstraints();
		GridBagConstraints c18 = new GridBagConstraints();
		GridBagConstraints c19 = new GridBagConstraints();
		GridBagConstraints c07 = new GridBagConstraints();
		GridBagConstraints c08 = new GridBagConstraints();
		GridBagConstraints c09 = new GridBagConstraints();
		GridBagConstraints c010 = new GridBagConstraints();
		GridBagConstraints c011 = new GridBagConstraints();
		GridBagConstraints c012 = new GridBagConstraints();

		// Customer Panel and constraints
		JPanel panel1 = new JPanel(new GridBagLayout());
		GridBagConstraints panelCon1 = new GridBagConstraints();
		panelCon1.fill = GridBagConstraints.BOTH;
		panelCon1.gridx = 0;
		panelCon1.gridy = 0;
		panelCon1.weightx = 0.2;

		// Order Panel and constraints
		JPanel panel2 = new JPanel(new GridBagLayout());
		GridBagConstraints panelCon2 = new GridBagConstraints();
		panelCon2.fill = GridBagConstraints.BOTH;
		panelCon2.gridx = 4;
		panelCon2.gridy = 1;
		//panelCon2.weighty = 0.2;
		panelCon2.gridwidth =1;

		// Packs Panel and constraints
		JPanel panel4 = new JPanel(new GridBagLayout());
		GridBagConstraints panelCon4 = new GridBagConstraints();
		panelCon4.fill = GridBagConstraints.BOTH;
		panelCon4.gridx = 1;// 2
		panelCon4.gridy = 0;// 0
		// panelCon4.weightx=0.2;

		// Express Panel and constraints
		JPanel panel3 = new JPanel(new GridBagLayout());
		GridBagConstraints panelCon3 = new GridBagConstraints();
		panelCon3.fill = GridBagConstraints.BOTH;
		panelCon3.gridx = 2;// 2
		panelCon3.gridy = 0;// 3

		// Menu Panel and constraints
		JPanel panel5 = new JPanel(new GridBagLayout());
		GridBagConstraints panelCon5 = new GridBagConstraints();
		panelCon5.fill = GridBagConstraints.BOTH;
		panelCon5.gridx = 0;
		panelCon5.gridy = 1;
		panelCon5.gridwidth = 4;

		JPanel entreePanel = new JPanel(new GridBagLayout());
		GridBagConstraints entreeCon = new GridBagConstraints();
		entreeCon.fill = GridBagConstraints.BOTH;
		entreeCon.gridx = 0;
		entreeCon.gridy = 0;
		// entreeCon.weightx = 0.2;
		entreeCon.weighty = 0.2;

		// Tandoor
		JPanel tandoorPanel = new JPanel(new GridBagLayout());
		GridBagConstraints tandoorCon = new GridBagConstraints();
		tandoorCon.fill = GridBagConstraints.BOTH;
		tandoorCon.gridx = 0;
		tandoorCon.gridy = 1;

		// Curries
		JPanel curriesPanel = new JPanel(new GridBagLayout());
		GridBagConstraints curriesCon = new GridBagConstraints();
		curriesCon.fill = GridBagConstraints.BOTH;
		curriesCon.gridx = 2;
		curriesCon.gridy = 0;

		// Veg Curries
		JPanel vegCurriesPanel = new JPanel(new GridBagLayout());
		GridBagConstraints vegCon = new GridBagConstraints();
		vegCon.fill = GridBagConstraints.HORIZONTAL;
		vegCon.gridx = 3;
		vegCon.gridy = 0;

		// Rices
		JPanel ricesPanel = new JPanel(new GridBagLayout());
		GridBagConstraints ricesCon = new GridBagConstraints();
		ricesCon.fill = GridBagConstraints.BOTH;
		ricesCon.gridx = 3;
		ricesCon.gridy = 0;
		

		// Breads
		JPanel breadsPanel = new JPanel(new GridBagLayout());
		GridBagConstraints breadsCon = new GridBagConstraints();
		breadsCon.fill = GridBagConstraints.BOTH;
		breadsCon.gridx = 4;
		breadsCon.gridy = 0;

		JPanel classicCurriesPanel = new JPanel(new GridBagLayout());
		JPanel regionalCurriesPanel = new JPanel(new GridBagLayout());

		// Main panels
		panel1.setBorder(new TitledBorder(new EtchedBorder(), "Customer"));
		panel2.setBorder(new TitledBorder(new EtchedBorder(), "Order"));
		panel3.setBorder(new TitledBorder(new EtchedBorder(), "Express"));
		panel4.setBorder(new TitledBorder(new EtchedBorder(), "Packs"));
		panel5.setBorder(new TitledBorder(new EtchedBorder(), "Menu"));

		// Menu Panels borders
		entreePanel.setBorder(new TitledBorder(new EtchedBorder(), "Entree"));
		tandoorPanel.setBorder(new TitledBorder(new EtchedBorder(), "Tandoor"));
		curriesPanel.setBorder(new TitledBorder(new EtchedBorder(), "Curries"));
		breadsPanel.setBorder(new TitledBorder(new EtchedBorder(), "Breads"));
		ricesPanel.setBorder(new TitledBorder(new EtchedBorder(), "Rices"));
		vegCurriesPanel.setBorder(new TitledBorder(new EtchedBorder(),
				"Vegetarian"));

		classicCurriesPanel.setBorder(new TitledBorder(new EtchedBorder(),
				"Classic"));
		regionalCurriesPanel.setBorder(new TitledBorder(new EtchedBorder(),
				"Regional"));

		// Arrange components using GridBagConstarints
		numberField = new JTextField();
		c1.fill = GridBagConstraints.HORIZONTAL;
		c1.gridx = 1;
		c1.gridy = 0;

		nameField = new JTextField();
		// nameField.setColumns(10);
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.gridx = 1;
		c2.gridy = 2;
		c2.weightx = 0.05;
		c2.weighty = 0.05;

		addressField = new JTextField();
		// addressField.setColumns(50);
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.gridx = 1;
		c3.gridy = 1;

		l1 = new JLabel("Contact No:");
		c4.fill = GridBagConstraints.HORIZONTAL;
		c4.gridx = 0;
		c4.gridy = 0;

		l2 = new JLabel("Name:");
		c5.fill = GridBagConstraints.HORIZONTAL;
		c5.gridx = 0;
		c5.gridy = 2;

		l3 = new JLabel("Address:");
		c6.fill = GridBagConstraints.HORIZONTAL;
		c6.gridx = 0;
		c6.gridy = 1;

		valuePack = new JButton("Value Pack");
		c7.fill = GridBagConstraints.HORIZONTAL;
		c7.gridx = 3;
		c7.gridy = 0;
		c7.gridwidth = 1;

		familyPack = new JButton("Family Pack");
		c8.fill = GridBagConstraints.HORIZONTAL;
		c8.gridx = 3;
		c8.gridy = 1;
		c8.gridwidth = 1;

		gourmetPack = new JButton("Gourmet Pack");
		c9.fill = GridBagConstraints.HORIZONTAL;
		c9.gridx = 3;
		c9.gridy = 2;
		c9.gridwidth = 1;

		add = new JButton("Add");
		// Add panels to container
		add.setVisible(false);
		c10.fill = GridBagConstraints.HORIZONTAL;
		c10.gridx = 0;
		c10.gridy = 3;
		c10.gridwidth = 1;

		// express buttons
		bChk = new JButton("B.Chk");
		c14.fill = GridBagConstraints.BOTH;
		c14.gridx = 0;
		c14.gridy = 0;

		lCurry = new JButton("L.Curry");
		c15.fill = GridBagConstraints.BOTH;
		c15.gridx = 0;
		c15.gridy = 2;

		bVindaloo = new JButton("B.Vindaloo");
		c16.fill = GridBagConstraints.BOTH;
		c16.gridx = 0;
		c16.gridy = 3;

		daal = new JButton("Daal");
		c17.fill = GridBagConstraints.BOTH;
		c17.gridx = 0;
		c17.gridy = 4;

		vKorma = new JButton("V.Korma");
		c18.fill = GridBagConstraints.BOTH;
		c18.gridx = 0;
		c18.gridy = 5;

		cCurry = new JButton("C.Curry");
		c19.fill = GridBagConstraints.BOTH;
		c19.gridx = 0;
		c19.gridy = 6;

		// entree buttons
		oBhaji = new JButton("OnionBhaji");
		GridBagConstraints c11 = new GridBagConstraints();
		c11.fill = GridBagConstraints.BOTH;
		c11.gridx = 0;
		c11.gridy = 0;
		// c11.anchor = GridBagConstraints.CENTER;

		samosa = new JButton("Samosa");
		GridBagConstraints c12 = new GridBagConstraints();
		c12.fill = GridBagConstraints.BOTH;
		c12.gridx = 0;
		c12.gridy = 1;

		pakora = new JButton("Pakora");
		GridBagConstraints c13 = new GridBagConstraints();
		c13.fill = GridBagConstraints.BOTH;
		c13.gridx = 0;
		c13.gridy = 2;

		order = new JTextArea(50, 50);
		model = new DefaultTableModel(col, 50);
		table = new JTable(model) {
			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				return true;
			}
		};

		listScrollPane = new JScrollPane(table);
		GridBagConstraints scrollCon = new GridBagConstraints();
		scrollCon.fill = GridBagConstraints.BOTH;
		// scrollCon.gridx = 0;
		// scrollCon.gridy = 0;
		scrollCon.weightx = 0.2;
		scrollCon.weighty = 0.2;
		scrollCon.gridwidth=2;

		// Add components to panel
		panel1.add(l1, c4);
		panel1.add(numberField, c1);
		panel1.add(add, c7);
		panel1.add(l2, c5);
		panel1.add(nameField, c2);
		panel1.add(l3, c6);
		panel1.add(addressField, c3);
		panel2.add(listScrollPane, scrollCon);
		panel3.add(bChk, c14);
		panel3.add(cCurry, c15);
		panel3.add(lCurry, c16);
		panel3.add(bVindaloo, c17);
		panel3.add(daal, c18);
		panel3.add(vKorma, c19);
		panel4.add(valuePack, c7);
		panel4.add(familyPack, c8);
		panel4.add(gourmetPack, c9);
		panel1.add(add, c10);
		panel5.add(entreePanel, entreeCon);
		panel5.add(tandoorPanel, tandoorCon);
		panel5.add(curriesPanel, curriesCon);
		panel5.add(vegCurriesPanel, vegCon);
		//panel5.add(breadsPanel);
		//panel5.add(ricesPanel);

		entreePanel.add(oBhaji, c11);
		entreePanel.add(samosa, c12);
		entreePanel.add(pakora, c13);

		curriesPanel.add(classicCurriesPanel, c11);
		curriesPanel.add(regionalCurriesPanel, c12);

		// Traditional curries
		traditional = new JButton("Traditional");
		saag = new JButton("Saag");
		vindaloo = new JButton("Vindaloo");
		korma = new JButton("Korma");

		curriesCombobox = new JComboBox();
		curriesCombobox.addItem("Chicken");

		// vegetarian
		dum = new JButton("Dum Ka Paneer");
		mutterPan = new JButton("Mutter Paneer");
		palakPan = new JButton("Palak Paneer");
		malaiKofta = new JButton("Malai Kofta");
		Baigan = new JButton("Baigan Masala");
		mashroom = new JButton("Goa Mashroom");
		navKorma = new JButton("Veg Korma");
		c07.fill = GridBagConstraints.BOTH;
		c07.gridx = 0;
		c07.gridy = 7;
		alooPalak = new JButton("Allo Palak");
		c08.fill = GridBagConstraints.BOTH;
		c08.gridx = 0;
		c08.gridy = 8;
		alooMutter = new JButton("Aloo Mutter");
		c09.fill = GridBagConstraints.BOTH;
		c09.gridx = 0;
		c09.gridy = 9;
		pumpkin = new JButton("Pumkin Masala");
		c010.fill = GridBagConstraints.BOTH;
		c010.gridx = 0;
		c010.gridy = 10;
		dMasala = new JButton("Daal Masala");
		c011.fill = GridBagConstraints.BOTH;
		c011.gridx = 0;
		c011.gridy = 11;
		dMaha = new JButton("Daal Maharani");
		c012.fill = GridBagConstraints.BOTH;
		c012.gridx = 0;
		c012.gridy = 12;
		
		subtotalField=new JTextField();
		subtotalField.setEditable(false);
		panel2.add(subtotalField,c12);
		
		//Print
		print=new JButton("Print");
		GridBagConstraints c02 = new GridBagConstraints();
		c02.fill = GridBagConstraints.BOTH;
		c02.gridx = 0;
		c02.gridy = 2;
	    panel2.add(print,c02);
	    
	    //Balance
	    balance=new JButton("Balance");
	    GridBagConstraints c1r2 = new GridBagConstraints();
		c1r2.fill = GridBagConstraints.BOTH;
		c1r2.gridx = 1;
		c1r2.gridy = 2;
	    panel2.add(balance,c1r2);

		vegCurriesPanel.add(dum, c14);
		vegCurriesPanel.add(mutterPan, c15);
		vegCurriesPanel.add(palakPan, c16);
		vegCurriesPanel.add(malaiKofta, c17);
		vegCurriesPanel.add(Baigan, c18);
		vegCurriesPanel.add(mashroom, c19);
		vegCurriesPanel.add(navKorma, c07);
		vegCurriesPanel.add(alooPalak, c08);
		vegCurriesPanel.add(alooMutter, c09);
		vegCurriesPanel.add(pumpkin, c010);
		vegCurriesPanel.add(dMaha, c011);
		vegCurriesPanel.add(dMasala, c011);

		classicCurriesPanel.add(traditional, c11);
		classicCurriesPanel.add(saag, c12);
		classicCurriesPanel.add(vindaloo, c13);
		classicCurriesPanel.add(korma, c10);

		classicCurriesPanel.add(curriesCombobox);

		// Regional Curries
		regionalCombobox = new JComboBox();
		regionalCombobox.addItem("Madras Fish");
		regionalCurriesPanel.add(regionalCombobox);
		
		//Rices
		sRice=new JButton("Saffron");
		wRice=new JButton("White");
		lambBiryani=new JButton("Lamb");
		chkBiryani=new JButton("Chicken");
		peaPulao=new JButton("pea");
		
		//breads
		naan=new JButton("Naan");
		roti=new JButton("Roti");
		keemaNaan=new JButton("Keema");
		kashNaan=new JButton("Kashmiri");
		alooParatha=new JButton("Aloo Paratha");
		paratha=new JButton("Paratha");
		rotiChennai=new JButton("Roti Chennai");
		masalaKulcha=new JButton("Masala Kulcha");
		
		ricesPanel.add(sRice,c14);
		ricesPanel.add(wRice,c15);
		ricesPanel.add(peaPulao,c16);
		ricesPanel.add(lambBiryani,c17);
		ricesPanel.add(chkBiryani,c18);
		
		breadsPanel.add(naan,c14);
		breadsPanel.add(roti,c15);
		breadsPanel.add(keemaNaan,c16);
		breadsPanel.add(kashNaan,c17);
		breadsPanel.add(alooParatha,c18);
		breadsPanel.add(paratha,c19);
		breadsPanel.add(rotiChennai,c07);
		breadsPanel.add(masalaKulcha,c08);
		
		cp.add(containPanels);

		containPanels.add(panel1, panelCon1);
		containPanels.add(panel3, panelCon3);
		containPanels.add(panel2, panelCon2);
		containPanels.add(panel4, panelCon4);
		containPanels.add(panel5, panelCon5);
		containPanels.add(breadsPanel, breadsCon);
		containPanels.add(ricesPanel, ricesCon);
		//containPanels.add(panel5, panelCon5);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		boolean ROW_SELECTED = true;
		if (ROW_SELECTED) {
			ListSelectionModel rowSL = table.getSelectionModel();
			rowSL.addListSelectionListener(new ListSelectionListener() {

				public void valueChanged(ListSelectionEvent e) {
					if (e.getValueIsAdjusting())
						return;
					ListSelectionModel lsm = (ListSelectionModel) e.getSource();
					if (lsm.isSelectionEmpty()){
						
					} else {
						int selectedRow=table.getSelectedRow();
						double val=(Double) model.getValueAt(selectedRow, 1);
						double newVal=new Double(val);
						romeveRow(selectedRow);
						subTotal -= newVal;
					    newSubtotal(subTotal);
					      
					}
				}
			});
		} else {
			table.setRowSelectionAllowed(false);
		}

		custNum = numberField.getText();

		numberField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String newline = "\n";
				String custNum = numberField.getText();
				ArrayList<String> info = null;

				try {
					cd.getConnected();
					info = cd.findCustomer(custNum + newline);
					if (info.isEmpty()) {
						addressField.setText("Not Found");
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

		valuePack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> pack = null;
				String type = "Packs";
				int column = 0;
				try {
					cd.getConnected();
					pack = cd.newOrder(type);
					price = Double.parseDouble(pack.get(5));
					name = pack.get(4);
					table.setValueAt(name, row, column);
					column++;
					table.setValueAt(price, row, column);
					setSubtotal(price);
					  
				} catch (EmptyStackException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		familyPack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> pack = null;
				String type = "Packs";
				int column = 0;
				try {
					cd.getConnected();
					pack = cd.newOrder(type);
					double price = Double.parseDouble(pack.get(1));
					table.setValueAt(pack.get(0), row, column);
					column++;
					table.setValueAt(price, row, column);
					setSubtotal(price);
					

				} catch (EmptyStackException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		gourmetPack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> pack = null;
				String type = "Packs";
				int column = 0;
				try {
					cd.getConnected();
					pack = cd.newOrder(type);

					double price = Double.parseDouble(pack.get(3));
					table.setValueAt(pack.get(2), row, column);
					column++;
					table.setValueAt(price, row, column);

					setSubtotal(price);

				} catch (EmptyStackException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		bChk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> pack = null;
				String type = "Express";
				int column = 0;
				try {
					cd.getConnected();
					pack = cd.newOrder(type);
					double price = Double.parseDouble(pack.get(1));
					String name = pack.get(0);
					table.setValueAt(name, row, column);
					column++;
					table.setValueAt(price, row, column);
					setSubtotal(price);
				} catch (EmptyStackException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		cCurry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> pack = null;
				String type = "Express";
				int column = 0;
				try {
					cd.getConnected();
					pack = cd.newOrder(type);
					double price = Double.parseDouble(pack.get(3));
					String name = pack.get(2);
					table.setValueAt(name, row, column);
					column++;
					table.setValueAt(price, row, column);
					setSubtotal(price);
				} catch (EmptyStackException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		lCurry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> pack = null;
				String type = "Express";
				int column = 0;
				try {
					cd.getConnected();
					pack = cd.newOrder(type);
					double price = Double.parseDouble(pack.get(5));
					String name = pack.get(4);
					table.setValueAt(name, row, column);
					column++;
					table.setValueAt(price, row, column);
					setSubtotal(price);
				} catch (EmptyStackException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		bVindaloo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> pack = null;
				String type = "Express";
				int column = 0;
				try {
					cd.getConnected();
					pack = cd.newOrder(type);
					double price = Double.parseDouble(pack.get(7));
					String name = pack.get(6);
					table.setValueAt(name, row, column);
					column++;
					table.setValueAt(price, row, column);
					setSubtotal(price);
				} catch (EmptyStackException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		daal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> pack = null;
				String type = "Express";
				int column = 0;
				try {
					cd.getConnected();
					pack = cd.newOrder(type);
					double price = Double.parseDouble(pack.get(9));
					String name = pack.get(8);
					table.setValueAt(name, row, column);
					column++;
					table.setValueAt(price, row, column);
					setSubtotal(price);
				} catch (EmptyStackException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		vKorma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> pack = null;
				String type = "Express";
				int column = 0;
				try {
					cd.getConnected();
					pack = cd.newOrder(type);
					double price = Double.parseDouble(pack.get(11));
					String name = pack.get(10);
					table.setValueAt(name, row, column);
					column++;
					table.setValueAt(price, row, column);
					setSubtotal(price);
				} catch (EmptyStackException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		 
		frame.setTitle("Order Form");
		frame.pack();
		frame.setSize(1400, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void insertUpdate(DocumentEvent e) {
		int len = e.getLength();
		if (len == 10) {
			updateLog(e, custName);
		} else {
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

	}

	public void setSubtotal(double value) {
		
		subTotal += value;
		String Total=Double.toString(subTotal);
		subtotalField.setText("$"+Total);
		row++;
		orderNo++;
		Account acc=new Account(orderNo, subTotal);
		acc.calculateX();
	}
	
	public void newSubtotal(double value){
		
		String Total=Double.toString(subTotal);
		subtotalField.setText("$"+Total);
		row--;
		orderNo--;
	}
	
	public void romeveRow(int row){
		model.removeRow(row);
		table.revalidate();
		
	}

}
